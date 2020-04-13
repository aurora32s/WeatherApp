package com.haman.weather.Data

import com.haman.weather.Model.City

object Common{
    const val BASIC_URL : String = "https://www.metaweather.com/api/location/"
    const val REQUEST_CITY : String = "search?query="

    val cities : ArrayList<City> = ArrayList()
}