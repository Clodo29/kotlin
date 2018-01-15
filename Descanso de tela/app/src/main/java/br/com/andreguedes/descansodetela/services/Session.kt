package br.com.andreguedes.descansodetela.services

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.net.Uri

/**
 * Created by andreguedes on 10/01/18.
 */
class Session {

    companion object {

        private val REQUEST_LOGOUT = 111
        private val SESSION_TIMEOUT = (1000 * 60 * 0.05).toLong() // 0.05 minutes
        private var data: Uri? = null
        private var type: String? = null

        fun scheduleSessionTimeout(context: Context, activityDestination: Class<*>, timeOutTypeEnum: TimeOutTypeEnum) {
            val am = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
            val intent = Intent(context, TimeOutService::class.java)
            intent.action = timeOutTypeEnum.name
            intent.putExtra(TimeOutService.EXTRA_TIMEOUT, true)
            intent.putExtra(TimeOutService.EXTRA_DESTINATION, activityDestination)

            data = intent.data
            type = intent.type
            val pendingIntent = PendingIntent.getService(context, REQUEST_LOGOUT, intent, PendingIntent.FLAG_CANCEL_CURRENT)
            am.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + SESSION_TIMEOUT, pendingIntent)
        }

        fun cancelSessionTimeout(context: Context, timeOutTypeEnum: TimeOutTypeEnum) {
            val am = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
            val intent = Intent(context, TimeOutService::class.java)
            intent.action = timeOutTypeEnum.name
            intent.data = data
            intent.type = type
            val pendingIntent = PendingIntent.getService(context, REQUEST_LOGOUT, intent, PendingIntent.FLAG_CANCEL_CURRENT)
            am.cancel(pendingIntent)
            pendingIntent.cancel()
        }
    }

    enum class TimeOutTypeEnum {
        DESCANSO
    }

}