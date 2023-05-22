package com.example.cocktails

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

class StopperFragment : Fragment(), View.OnClickListener {
    private var seconds: Int = 0
    private var running: Boolean = false
    private  var wasRunning: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState != null) {
            seconds = savedInstanceState.getInt("seconds")
            running = savedInstanceState.getBoolean("running")
            wasRunning = savedInstanceState.getBoolean("wasRunning")
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val layout = inflater.inflate(R.layout.fragment_stoper, container, false)
        runStopper(layout)
        val startButton = layout.findViewById<Button>(R.id.start_button)
        startButton.setOnClickListener(this)
        val stopButton = layout.findViewById<Button>(R.id.stop_button)
        stopButton.setOnClickListener(this)
        val resetButton = layout.findViewById<Button>(R.id.reset_button)
        resetButton.setOnClickListener(this)
        return layout
    }

    private fun runStopper(view: View) {
        val timeView : TextView = view.findViewById(R.id.time_view)
        val handler = Handler()
        handler.post( object : Runnable {
            override fun run() {
                val hours = seconds / 3600
                val minutes = (seconds % 3600) / 60
                val secs = seconds % 60
                val time = String.format("%d:%02d:%02d", hours, minutes, secs)
                timeView.text = time
                if (running) {
                    seconds++
                }
                handler.postDelayed(this, 1000)
            }
        })
    }

    override fun onPause() {
        super.onPause()
        wasRunning = running
        running = false
    }

    override fun onResume() {
        super.onResume()
        if (wasRunning) {
            running = true
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("seconds", seconds)
        outState.putBoolean("running", running)
        outState.putBoolean("wasRunning", wasRunning)
    }

    private fun onClickStart() {
        running = true
    }

    private fun onClickStop() {
        running = false
    }

    private fun onClickReset() {
        running = false
        seconds = 0
    }

    override fun onClick(v: View?) {
        if (v != null) {
            when (v.id) {
                R.id.start_button -> onClickStart()
                R.id.stop_button -> onClickStop()
                R.id.reset_button -> onClickReset()
            }
        }
    }


}