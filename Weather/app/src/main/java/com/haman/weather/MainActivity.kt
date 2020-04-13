package com.haman.weather

import android.content.Context
import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import com.haman.weather.Data.Common
import com.haman.weather.Model.City
import com.haman.weather.Model.Weather
import org.json.JSONArray
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Exception
import java.net.URL

class MainActivity : AppCompatActivity() {

    private val TAG : String = ".MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        requestCity().execute()
    }

    private class requestCity : AsyncTask<String, Int, Boolean>() {

        private val cityArray : ArrayList<City> = ArrayList()

        override fun onPreExecute() {
            super.onPreExecute()
        }

        override fun onPostExecute(result: Boolean?) {
            super.onPostExecute(result)
            Log.i("MainActivity","Finish")
        }

        override fun doInBackground(vararg params: String?): Boolean {

            Log.i("MainActivity","Start")
            val gson = Gson()
            try {
                val jsonArray = JSONArray(request(Common.BASIC_URL+Common.REQUEST_CITY+"se"))
                for (index : Int in 0..jsonArray.length()-1){

                    val city = jsonArray.getJSONObject(index)
                    val woeid = city.getInt("woeid")

                    val cityData = City(city.getString("title"), woeid)
                    val weatherData : JSONArray = JSONObject(request(Common.BASIC_URL+Integer.toString(woeid))).getJSONArray("consolidated_weather")
                    for (i in 0..1){
                        val weather : Weather = gson.fromJson(weatherData.getJSONObject(i).toString(),Weather::class.java)
                        cityData.weather.add(weather)
                    }

                    cityArray.add(cityData)
                }
            } catch (exception: Exception) {
                Log.i("MainActivity", "Result : $exception")
                return false
            } finally {
                return true;
            }
        }

        private fun request(url : String) :String{
            var reader: BufferedReader? = null

            val url = URL(url)
            reader = BufferedReader(InputStreamReader(url.openStream()))
            val buffer = StringBuffer()

            val chars = CharArray(1024)
            var read: Int = reader.read(chars)

            while (read != -1) {
                buffer.append(chars, 0, read)
                read = reader.read(chars)
            }
            return buffer.toString()
        }
    }
}
