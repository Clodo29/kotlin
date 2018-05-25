package com.example.andrericardodesouzaguedes.jobservice

import android.app.Application
import android.app.job.JobScheduler
import android.content.Context

class JobServiceApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        val jobInfo = Scheduler.getStartService(this)
        val jobScheduler = getSystemService(Context.JOB_SCHEDULER_SERVICE) as JobScheduler
        jobScheduler.schedule(jobInfo)

    }

}