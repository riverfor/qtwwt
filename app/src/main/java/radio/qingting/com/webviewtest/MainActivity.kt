package radio.qingting.com.webviewtest

import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.webkit.*
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val webView = findViewById<WebView>(R.id.webView)
        val editUrl = findViewById<EditText>(R.id.url)
        val loadUrl = findViewById<TextView>(R.id.loadUrl)

        webView.settings.apply {
            cacheMode = WebSettings.LOAD_NO_CACHE
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                mediaPlaybackRequiresUserGesture = false
            }
            pluginState = WebSettings.PluginState.ON
            setAppCacheEnabled(true)
            useWideViewPort = true
            allowFileAccess = true
            domStorageEnabled = true
            javaScriptEnabled = true
            layoutAlgorithm = WebSettings.LayoutAlgorithm.NORMAL
            useWideViewPort = true
            loadWithOverviewMode = true
            domStorageEnabled = true
            databaseEnabled = true
            setSupportZoom(true)
            builtInZoomControls = true
            blockNetworkImage = false
            loadsImagesAutomatically = true
            javaScriptCanOpenWindowsAutomatically = true
        }
        webView.webViewClient = object :WebViewClient() {

            override fun shouldOverrideUrlLoading(view: WebView, url: String?): Boolean {
                view.loadUrl(url)
                return true
            }

            override fun shouldOverrideUrlLoading(view: WebView, request: WebResourceRequest): Boolean {
                view.loadUrl(request.url.toString())
                return true
            }

        }
        webView.webChromeClient = WebChromeClient()
        loadUrl.setOnClickListener {
            webView.loadUrl(editUrl.editableText.toString())
        }
        webView.loadUrl(editUrl.editableText.toString())
    }
}
