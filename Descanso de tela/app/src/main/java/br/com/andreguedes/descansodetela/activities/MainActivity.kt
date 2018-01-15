package br.com.andreguedes.descansodetela.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import br.com.andreguedes.descansodetela.R
import br.com.andreguedes.descansodetela.services.Session

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()

        Session.scheduleSessionTimeout(this, DescansoActivity::class.java, Session.TimeOutTypeEnum.DESCANSO)
    }

    override fun onDestroy() {
        super.onDestroy()

        Session.cancelSessionTimeout(this, Session.TimeOutTypeEnum.DESCANSO)
    }

}