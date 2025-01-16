package ps.dotech.flickerimagesearch.common

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities


object Constants {



    fun isNetworkAvailable(context: Context): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE)
                as? ConnectivityManager
        connectivityManager?.let {
            val networkCapabilities = it.getNetworkCapabilities(it.activeNetwork)
            return networkCapabilities != null &&
                    networkCapabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
        }
        return false
    }
}