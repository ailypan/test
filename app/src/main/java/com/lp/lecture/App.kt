package com.lp.lecture

import android.app.Application
import android.content.Context
import android.support.multidex.MultiDex
import kotlin.properties.Delegates

class App : Application(){
    companion object{
        var context: Context by Delegates.notNull()
            private set
        lateinit var instance:Application
    }
    override fun onCreate() {
        super.onCreate()
        context = applicationContext
        instance = this
    }
    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(newBase)
        MultiDex.install(newBase)
    }
}