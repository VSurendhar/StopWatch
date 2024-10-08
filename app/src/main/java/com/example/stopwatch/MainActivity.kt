package com.example.stopwatch

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.SystemClock
import androidx.appcompat.app.AppCompatActivity
import com.example.stopwatch.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var handler: Handler

    var second: Int = 0
    var minute: Int = 0
    var millisecondsTime: Long = 0
    var elapsedTime: Long = 0
    var startTime: Long = 0L
    var timeBuff: Long = 0L
    var updateTime: Long = 0L
    var millisecond: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        handler = Handler(Looper.getMainLooper())

        binding.tvMinute.text = getString(R.string.Zero)
        binding.tvSecond.text = getString(R.string.Zero)
        binding.tvMilliSecond.text = getString(R.string.Zero)
        binding.textView3.text = ":"
        binding.textView5.text = ":"

        val runnable: Runnable = object : Runnable {
            override fun run() {
                millisecondsTime = SystemClock.uptimeMillis() - startTime
                updateTime = timeBuff + millisecondsTime
                second = (updateTime / 1000).toInt()
                minute = second / 60
                second %= 60
                millisecond = ((updateTime % 1000) / 10).toInt()

                binding.tvMilliSecond.text = String.format("%02d", millisecond)
                binding.tvSecond.text = String.format("%02d", second)
                binding.tvMinute.text = String.format("%02d", minute)

                handler.postDelayed(this, 50)
            }
        }

        binding.startBtn.setOnClickListener { startBtn(runnable) }
        binding.stopBtn.setOnClickListener { stopBtn(runnable) }
        binding.resetBtn.setOnClickListener { resetBtn() }

    }

    private fun startBtn(runnable: Runnable) {
        startTime = SystemClock.uptimeMillis()
        handler.postDelayed(runnable, 0)
        binding.resetBtn.isEnabled = false
        binding.startBtn.isEnabled = false
        binding.stopBtn.isEnabled = true
    }

    private fun stopBtn(runnable: Runnable) {
        timeBuff += SystemClock.uptimeMillis() - startTime
        handler.removeCallbacks(runnable)
        binding.resetBtn.isEnabled = true
        binding.stopBtn.isEnabled = false
        binding.startBtn.isEnabled = true
    }

    private fun resetBtn() {

        binding.startBtn.isEnabled = true
        binding.stopBtn.isEnabled = true
        second = 0
        timeBuff = 0L
        minute = 0
        updateTime = 0L
        millisecond = 0

        binding.tvMinute.text = getString(R.string.Zero)
        binding.tvSecond.text = getString(R.string.Zero)
        binding.tvMilliSecond.text = getString(R.string.Zero)
        binding.textView3.text = ":"
        binding.textView5.text = ":"

    }

}
