package com.amttech.workmanagerexample

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

class MyWorker(appContext: Context,workerParams: WorkerParameters) : Worker(appContext,workerParams) {
    override fun doWork(): Result {
        val total = 2 + 3
        Log.e("background process",total.toString())
        return Result.success()
    }
}