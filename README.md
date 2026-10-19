# National Parks Explorer

## Overview

National Parks Explorer is an Android application that allows users to explore U.S. national parks. The app retrieves park information from the National Park Service (NPS) API and displays each park's name, location, description, and image in a scrollable list.

## Demo

![National Parks Explorer Demo](https://media0.giphy.com/media/v1.Y2lkPTc5MGI3NjExd3FybXRrZHJ0a29ocW95NzQ2azR2bHJ5NHA2dmczNDF5aGNhbWVmeiZlcD12MV9pbnRlcm5hbF9naWZfYnlfaWQmY3Q9Zw/41L3ibd5XiERh5uYMk/giphy.gif)

## Features

* **National Parks List:** Browse U.S. national parks.
* **Park Information:** View each park's name, location, and description.
* **Park Images:** View images associated with each national park.
* **Scrollable Interface:** Navigate the list using RecyclerView.
* **API Integration:** Retrieve park data from the National Park Service API.

## Technologies Used

* **Kotlin** — primary programming language
* **Android Studio** — development environment
* **RecyclerView** — displays the list of parks
* **Glide** — loads and displays images
* **Gson** — parses JSON responses
* **AsyncHttpClient** — handles API requests
* **National Park Service API** — provides national park data

## Implementation

The application sends an HTTP request to the National Park Service API to retrieve park information. Gson converts the JSON response into Kotlin objects, RecyclerView displays the park information, and Glide loads images from their URLs.

## Setup

1. Clone this repository.
2. Open the project in Android Studio.
3. Add a valid National Park Service API key to `NationalParksFragment.kt`.
4. Sync the Gradle dependencies.
5. Run the app on an Android emulator or compatible device.

## Learning Objectives

* Make API requests from an Android application.
* Parse JSON responses into Kotlin objects.
* Display dynamic content using RecyclerView.
* Load remote images using Glide.
* Practice debugging and integrating Android libraries.

## Author

Taylor Davis

## Acknowledgments

Developed as part of CodePath's Intermediate Android Development course at Virginia State University.

Data provided by the [National Park Service API](https://www.nps.gov/subjects/developer/).
