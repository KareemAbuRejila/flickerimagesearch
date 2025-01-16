package ps.dotech.flickerimagesearch.data.remote.auth


class TokenManager {

    // Function to fetch or refresh token (from cache or remote server)
    fun getToken(): String {
        // For simplicity, assume  returning a hardcoded token.
        // In real implementation, this could involve network calls or retrieving from cache/storage.
        return "TOKEN"
    }
}