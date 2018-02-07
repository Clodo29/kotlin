package br.com.andreguedes.descansodetela.services

import android.app.ActivityManager
import android.app.IntentService
import android.content.Context
import android.content.Intent
import android.util.Log

/**
 * Created by andreguedes on 10/01/18.
 */
class TimeOutService : IntentService("TimeOutService") {

    companion object {
        val EXTRA_TIMEOUT = "timeout"
        val EXTRA_DESTINATION = "destination"
    }

    override fun onHandleIntent(intent: Intent?) {
        val am = getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        val cn = am.getRunningTasks(1)[0].topActivity
        Log.d("TAG", "ClassName: ${cn.className}")

        val destination = intent?.extras?.getSerializable(EXTRA_DESTINATION)
        showDestination(this, destination as Class<*>)
    }

    private fun showDestination(context: Context, activityDestination: Class<*>) {
        val intent = Intent(context, activityDestination)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        context.startActivity(intent)
    }

}