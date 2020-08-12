package com.pablo.clima.com.pablo.clima

import com.pablo.clima.Main
import com.pablo.clima.Weather
import com.pablo.clima.Wind

class Ciudad(name: String, weather: ArrayList<Weather>, main: Main, wind: Wind) {
    var name: String = ""
    var weather: ArrayList<Weather>? = null
    var main: Main? = null
    var wind: Wind? = null

    init {
        this.name = name
        this.weather = weather
        this.main = main
        this.wind = wind
    }
}