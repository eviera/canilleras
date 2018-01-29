package net.eviera.canilleras.manager

import android.app.Application

class CaniApp : Application() {

    val session = Session()

    override fun onCreate() {
        super.onCreate()

    }

}