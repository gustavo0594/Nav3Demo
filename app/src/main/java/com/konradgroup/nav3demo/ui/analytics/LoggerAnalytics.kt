package com.konradgroup.nav3demo.ui.analytics

import android.util.Log

object LoggerAnalytics {

    fun logScreenViewed(screenName: String) {
        Log.d("Analytics", "Screen viewed: $screenName")
    }

    fun logScreenPopped(contentKey: Any) {
        Log.d("Analytics", "Screen popped: $contentKey")
    }
}