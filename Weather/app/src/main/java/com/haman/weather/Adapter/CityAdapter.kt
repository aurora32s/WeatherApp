package com.haman.weather.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.haman.weather.Data.Common
import com.haman.weather.Model.City
import com.haman.weather.R
import com.haman.weather.ViewManager.CityView

class CityAdapter(context: Context) : BaseAdapter(){

    private val context : Context = context
    private val inflater : LayoutInflater = LayoutInflater.from(context)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        var cityView : CityView? = null
        var view : View? = convertView
        if(view == null){
            view = inflater.inflate(R.layout.item_weather,parent,false)
            cityView = CityView(view,context)
            view.tag = cityView
        }else{
            cityView = view.tag as CityView
        }

        cityView.setData(getItem(position))
        return view!!
    }

    override fun getItem(position: Int): City = Common.cities.get(position)
    override fun getItemId(position: Int): Long = Common.cities.get(position).woeid.toLong()
    override fun getCount(): Int = Common.cities.size
}
