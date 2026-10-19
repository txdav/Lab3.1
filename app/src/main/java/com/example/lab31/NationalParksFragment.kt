
package com.example.lab31

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.codepath.asynchttpclient.AsyncHttpClient
import com.codepath.asynchttpclient.RequestParams
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import okhttp3.Headers
import org.json.JSONArray
class NationalParksFragment : Fragment() {

    private val client = AsyncHttpClient()
    private lateinit var recyclerView: RecyclerView

    companion object {
        // Keep your API key private. Insert it locally below.
        private const val API_KEY = "DEXD2BAHMYE2vbvKUtOP1aEEILiClSZD8f6tvAtq"
        private const val TAG = "NationalParksFragment"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(
            R.layout.fragment_national_parks,
            container,
            false
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        fetchParks()
    }

    private fun fetchParks() {
        val params = RequestParams()
        params["api_key"] = API_KEY
        params["fields"] = "images"

        client.get(
            "https://developer.nps.gov/api/v1/parks",
            params,
            object : JsonHttpResponseHandler() {

                override fun onSuccess(
                    statusCode: Int,
                    headers: Headers,
                    json: JsonHttpResponseHandler.JSON
                ) {
                    Log.d(TAG, "API request successful")

                    try {
                        val data = json.jsonObject.getJSONArray("data")
                        val listType =
                            object : TypeToken<List<NationalPark>>() {}.type

                        val parks: List<NationalPark> =
                            Gson().fromJson(data.toString(), listType)

                        activity?.runOnUiThread {
                            recyclerView.adapter =
                                NationalParksRecyclerViewAdapter(parks)
                        }

                        Log.d(TAG, "Number of parks: ${parks.size}")
                    } catch (e: Exception) {
                        Log.e(TAG, "Could not parse park data", e)
                    }
                }

                override fun onFailure(
                    statusCode: Int,
                    headers: Headers?,
                    response: String?,
                    throwable: Throwable?
                ) {
                    Log.e(TAG, "Request failed: $statusCode")
                    Log.e(TAG, "Response: $response")
                    throwable?.printStackTrace()
                }
            }
        )
    }
}