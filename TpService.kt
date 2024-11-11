package com.example.startingservices

import android.app.Service
import android.content.Intent
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import android.widget.Button
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class TpService : Service() {
    private val scope = CoroutineScope(Job() + Dispatchers.Default)

    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
        val countdownTime = intent?.getIntExtra("countdown_time", 0) ?: 0
        startCountdown(countdownTime)
        return START_STICKY
    }

    private fun startCountdown(seconds: Int) {
            scope.launch {
                for (i in seconds downTo 0) {
                    Log.d("CountdownService", "Countdown: $i seconds remaining")
                    delay(1000)
                }
                Log.d("CountdownService", "Countdown finished")
            }
    }

    override fun onBind(intent: Intent): IBinder? {
        return null
    }

    override fun onDestroy() {
        super.onDestroy()
        Job().cancel()
    }
}
