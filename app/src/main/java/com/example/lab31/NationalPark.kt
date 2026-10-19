
package com.example.lab31

import com.google.gson.annotations.SerializedName

class NationalPark {

    @JvmField
    @SerializedName("fullName")
    var name: String? = null

    @JvmField
    @SerializedName("description")
    var description: String? = null

    @JvmField
    @SerializedName("states")
    var location: String? = null

    @JvmField
    @SerializedName("images")
    var images: List<ParkImage>? = null

    val imageUrl: String?
        get() = images?.firstOrNull()?.url

    class ParkImage {
        @JvmField
        @SerializedName("url")
        var url: String? = null
    }
}