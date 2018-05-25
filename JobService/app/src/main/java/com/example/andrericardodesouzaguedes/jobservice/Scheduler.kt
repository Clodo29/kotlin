package com.example.andrericardodesouzaguedes.jobservice

import android.app.job.JobInfo
import android.app.job.JobParameters
import android.app.job.JobService
import android.content.ComponentName
import android.content.Context
import android.util.Log

class Scheduler : JobService() {

    companion object {

        private const val TIME_TO_JOB = (3000).toLong()

        fun getStartService(context: Context): JobInfo {
            Log.i("UndoJobService", "GET START JOBSERVICE")
            return JobInfo.Builder(25165, ComponentName(context, Scheduler::class.java))
                    .setPeriodic(TIME_TO_JOB)
                    .setPersisted(true)
                    .setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY)
                    .build()
        }
    }

    override fun onStopJob(params: JobParameters?): Boolean {
        Log.i("JOB", "STOP JOB")
        return true
    }

    override fun onStartJob(params: JobParameters?): Boolean {
        Log.i("JOB", "START JOB")
        return false
    }

}