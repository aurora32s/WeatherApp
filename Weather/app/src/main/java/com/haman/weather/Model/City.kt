package com.haman.weather.Model

class City(title : String, woeid : Int){
    val title = title
    val woeid = woeid
    val weather : ArrayList<Weather> = ArrayList()
}