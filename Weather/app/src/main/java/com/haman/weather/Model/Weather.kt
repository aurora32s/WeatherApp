package com.haman.weather.Model

class Weather{
    var id : Long = 0
    var weather_state_name : String? = null
    var weather_state_abbr : String? = null
    var wind_direction_compass : String? = null
    var created : String? = null
    var applicable_date : String? = null
    var min_temp : Double = 0.0
    var max_temp : Double = 0.0
    var the_temp : Double = 0.0
    var wind_speed : Double = 0.0
    var wind_direction : Double = 0.0
    var air_pressure : Double = 0.0
    var humidity : Double = 0.0
    var visibility : Double = 0.0
    var predictability : Double = 0.0
}