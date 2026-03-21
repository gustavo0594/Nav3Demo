package com.konradgroup.nav3demo.ui.navigation.decorators

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.navigation3.runtime.NavEntryDecorator
import com.konradgroup.nav3demo.ui.analytics.LoggerAnalytics

class AnalyticsNavEntryDecorator<T : Any>(
    private val analyticsLogger: LoggerAnalytics,
) : NavEntryDecorator<T>(
    decorate = { entry ->
        // Called when this entry becomes active
        LaunchedEffect(entry.contentKey) {
            analyticsLogger.logScreenViewed(entry.contentKey.toString())
        }

        // Render the original screen
        entry.Content()
    },

    onPop = { contentKey ->
        LoggerAnalytics.logScreenPopped(contentKey.toString())
    }
)

@Composable
fun <T: Any> rememberAnalyticsNavEntryDecorator(): AnalyticsNavEntryDecorator<T> {
    return remember { AnalyticsNavEntryDecorator(LoggerAnalytics) }
}