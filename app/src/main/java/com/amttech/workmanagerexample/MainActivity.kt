package com.amttech.workmanagerexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import com.amttech.workmanagerexample.databinding.ActivityMainBinding
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonWork.setOnClickListener {
    //        val request = OneTimeWorkRequestBuilder<MyWorker>().setInitialDelay(3,TimeUnit.SECONDS).build()

            val request = PeriodicWorkRequestBuilder<MyWorkerPeriodic>(15,TimeUnit.MINUTES)
                .setInitialDelay(5,TimeUnit.SECONDS)
                .build()
            WorkManager.getInstance(this).enqueue(request)

            WorkManager.getInstance(this).getWorkInfoByIdLiveData(request.id).observe(this) {
                Log.e("Status",it.state.name)
            }
        }
    }
}