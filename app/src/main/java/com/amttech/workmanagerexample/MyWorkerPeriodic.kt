package com.amttech.workmanagerexample

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

class MyWorkerPeriodic (appContext: Context, workerParams: WorkerParameters) : Worker(appContext,workerParams) {
    override fun doWork(): Result {
        Log.e("Periodic","Periodic Process")
        return Result.success()
    }
}