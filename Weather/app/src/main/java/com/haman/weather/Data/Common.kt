package com.haman.weather.Data

import com.haman.weather.Model.City

object Common{
    const val BASIC_URL : String = "https://www.metaweather.com/api/location/"
    const val REQUEST_CITY : String = "search?query="
    const val REQUEST_WEATHER_ICON : String = "https://www.metaweather.com/static/img/weather/png/"

    val cities : ArrayList<City> = ArrayList()
}