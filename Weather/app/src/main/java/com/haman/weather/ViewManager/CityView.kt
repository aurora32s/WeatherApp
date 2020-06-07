package com.haman.weather.ViewManager

import android.content.Context
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.haman.weather.Data.Common
import com.haman.weather.Model.City
import com.haman.weather.Model.Weather
import com.haman.weather.R
import com.squareup.picasso.Picasso

class CityView(view : View, val context : Context){

    val cityName : TextView = view.findViewById(R.id.txtCity)

    val imgTodayWeather : ImageView = view.findViewById(R.id.imageTodayWeather)
    val txtWeatherToday : TextView = view.findViewById(R.id.txtTodayWeather)
    val txtTempToday : TextView = view.findViewById(R.id.txtTempToday)
    val txtHumiToday : TextView = view.findViewById(R.id.txtHumiToday)

    val imgTomorrowWeather : ImageView = view.findViewById(R.id.imageTomorrowWeather)
    val txtWeatherTomorrow : TextView = view.findViewById(R.id.txtTomorrowWeather)
    val txtTempTomorrowy : TextView = view.findViewById(R.id.txtTempTomorrow)
    val txtHumiTomorrow : TextView = view.findViewById(R.id.txtHumiTomorrow)

    fun setData(city : City){
        cityName.text = city.title

        val todayWeather : Weather = city.weather.get(0)
        val tomorrowWeather : Weather = city.weather.get(1)

        //weather image
        Picasso.with(context).load(Common.REQUEST_WEATHER_ICON+todayWeather.weather_state_abbr+".png").into(imgTodayWeather)
        Picasso.with(context).load(Common.REQUEST_WEATHER_ICON+tomorrowWeather.weather_state_abbr+".png").into(imgTomorrowWeather)
        Log.i("MainActivity","image : "+Common.REQUEST_WEATHER_ICON+todayWeather.weather_state_abbr+".png")
        //weather text
        txtWeatherToday.text = todayWeather.weather_state_name
        txtWeatherTomorrow.text = tomorrowWeather.weather_state_name

        //temp text
        txtTempToday.text = Integer.toString(todayWeather.the_temp.toInt())
        txtTempTomorrowy.text = Integer.toString(tomorrowWeather.the_temp.toInt())

        //humidity text
        txtHumiToday.text = Integer.toString(todayWeather.humidity.toInt())
        txtHumiTomorrow.text = Integer.toString(tomorrowWeather.humidity.toInt())
    }
}