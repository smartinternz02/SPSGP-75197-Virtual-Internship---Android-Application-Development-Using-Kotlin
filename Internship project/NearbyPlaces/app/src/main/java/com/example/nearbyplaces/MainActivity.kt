package com.example.nearbyplaces

import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.location.Criteria
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.core.app.ActivityCompat
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import id.inix.nearbyplaces.ParserPlace
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.net.HttpURLConnection
import java.net.URL

class MainActivity : AppCompatActivity(), LocationListener {

    var mGoogleMap: GoogleMap? = null
    var pBar: ProgressBar? = null
    var mLatitude = 0.0
    var mLongitude = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spinnerLocation = findViewById<Spinner>(R.id.spnLocation)
        pBar = findViewById(R.id.pBar)
        val fragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        fragment!!.getMapAsync { googleMap ->
            mGoogleMap = googleMap
            initMap()
        }
        val myAdapter = ArrayAdapter(
            this@MainActivity,
            android.R.layout.simple_list_item_1, resources.getStringArray(R.array.find_a_location)
        )
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerLocation.adapter = myAdapter
        spinnerLocation.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                adapterView: AdapterView<*>?,
                view: View,
                position: Int,
                l: Long
            ) {
                var xType = ""
                if (position == 1) {
                    xType = "temple"
                    Toast.makeText(
                        applicationContext,
                        "Searching for nearby temples...",
                        Toast.LENGTH_SHORT
                    ).show()
                } else if (position == 2) {
                    xType = "restaurant"
                    Toast.makeText(
                        applicationContext,
                        "Searching for nearby restaurants...",
                        Toast.LENGTH_SHORT
                    ).show()
                } else if (position == 3) {
                    xType = "atm"
                    Toast.makeText(
                        applicationContext,
                        "Searching for nearby ATMs...",
                        Toast.LENGTH_SHORT
                    ).show()
                } else if (position == 4) {
                    xType = "bank"
                    Toast.makeText(
                        applicationContext,
                        "Searching for nearby banks...",
                        Toast.LENGTH_SHORT
                    ).show()
                } else if (position == 5) {
                    xType = "fire_station"
                    Toast.makeText(
                        applicationContext,
                        "Searching for nearby fire stations...",
                        Toast.LENGTH_SHORT
                    ).show()
                } else if (position == 6) {
                    xType = "hospital"
                    Toast.makeText(
                        applicationContext,
                        "Searching for nearby hospitals...",
                        Toast.LENGTH_SHORT
                    ).show()
                } else if (position == 7) {
                    xType = "laundry"
                    Toast.makeText(
                        applicationContext,
                        "Searching for nearby laundries...",
                        Toast.LENGTH_SHORT
                    ).show()
                } else if (position == 8) {
                    xType = "movie_theater"
                    Toast.makeText(
                        applicationContext,
                        "Searching for nearby movie theaters...",
                        Toast.LENGTH_SHORT
                    ).show()
                } else if (position == 9) {
                    xType = "post_office"
                    Toast.makeText(
                        applicationContext,
                        "Searching for nearby post offices...",
                        Toast.LENGTH_SHORT
                    ).show()
                } else if (position == 10) {
                    xType = "police"
                    Toast.makeText(
                        applicationContext,
                        "Searching for nearby police stations...",
                        Toast.LENGTH_SHORT
                    ).show()
                } else if (position == 11) {
                    xType = "school"
                    Toast.makeText(
                        applicationContext,
                        "Searching for nearby schools...",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                if (position != 0) {
                    val sb = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?" +
                            "location=" + mLatitude + "," + mLongitude +
                            "&radius=5000+" +
                            "&types=" + xType +
                            "&senson=true" +
                            "&key=" + resources.getString(R.string.google_maps_key)
                    startProg()
                    PlacesTask().execute(sb)
                }
            }

            override fun onNothingSelected(adapterView: AdapterView<*>?) {}
        }
    }

    private fun initMap() {
        if (ActivityCompat.checkSelfPermission(
                this,
                android.Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED &&
            ActivityCompat.checkSelfPermission(
                this,
                android.Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION),
                115
            )
            return
        }
        if (mGoogleMap != null) {
            startProg()
            mGoogleMap!!.isMyLocationEnabled = true
            val locationManager = getSystemService(LOCATION_SERVICE) as LocationManager
            val criteria = Criteria()
            val provider = locationManager.getBestProvider(criteria, true)
            val location = provider?.let { locationManager.getLastKnownLocation(it) }
            if (location != null) {
                onLocationChanged(location)
            } else stopProg()
            if (provider != null) {
                locationManager.requestLocationUpdates(
                    provider,
                    20000, 0f, this
                )
            }
        }
    }

    override fun onLocationChanged(location: Location) {
        mLatitude = location.latitude
        mLongitude = location.longitude
        val latLng = LatLng(mLatitude, mLongitude)
        mGoogleMap!!.moveCamera(
            CameraUpdateFactory.newLatLng(latLng)
        )
        mGoogleMap!!.animateCamera(CameraUpdateFactory.zoomTo(12f))
        stopProg()
    }

    private fun stopProg() {
        pBar!!.visibility = View.GONE
    }

    private fun startProg() {
        pBar!!.visibility = View.VISIBLE
    }

    @SuppressLint("StaticFieldLeak")
    private inner class PlacesTask :
        AsyncTask<String?, Int?, String?>() {
        override fun doInBackground(vararg url: String?): String? {
            var data: String? = null
            try {
                data = downloadUrl(url[0].toString())
            } catch (e: Exception) {
                stopProg()
                e.printStackTrace()
            }
            return data
        }

        override fun onPostExecute(result: String?) {
            ParseTask().execute(result)
        }
    }

    private fun downloadUrl(strUrl: String): String {
        var data = ""
        val iStream: InputStream
        val urlConnection: HttpURLConnection
        try {
            val url = URL(strUrl)
            urlConnection = url.openConnection() as HttpURLConnection
            urlConnection.connect()
            iStream = urlConnection.inputStream
            val br = BufferedReader(InputStreamReader(iStream))
            val sb = StringBuilder()
            var line: String?
            while (br.readLine().also { line = it } != null) {
                sb.append(line)
            }
            data = sb.toString()
            br.close()
            iStream.close()
            urlConnection.disconnect()
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return data
    }

    @SuppressLint("StaticFieldLeak")
    private inner class ParseTask :
        AsyncTask<String?, Int?, List<HashMap<String, String>>?>() {
        var jObject: JSONObject? = null
        protected override fun doInBackground(vararg jsonData: String?): List<HashMap<String, String>>? {
            var places: List<HashMap<String, String>>? = null
            val parserPlace = ParserPlace()
            try {
                jObject = JSONObject(jsonData[0])
                places = parserPlace.parse(jObject!!)
            } catch (e: Exception) {
                e.printStackTrace()
            }
            return places
        }

        override fun onPostExecute(list: List<HashMap<String, String>>?) {
            mGoogleMap!!.clear()
            for (i in list!!.indices) {
                val markerOptions = MarkerOptions()
                val hmPlace = list[i]
                val pinDrop = BitmapDescriptorFactory.fromResource(R.drawable.ic_pin)
                val lat = hmPlace["lat"]!!.toDouble()
                val lng = hmPlace["lng"]!!.toDouble()
                val nama = hmPlace["place_name"]
                val namaJln = hmPlace["vicinity"]
                val latLng = LatLng(lat, lng)
                markerOptions.icon(pinDrop)
                markerOptions.position(latLng)
                markerOptions.title(nama)
                mGoogleMap!!.addMarker((markerOptions))
            }
            stopProg()
        }
    }
}