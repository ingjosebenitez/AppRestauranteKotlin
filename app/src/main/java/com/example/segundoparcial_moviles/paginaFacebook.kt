package com.example.segundoparcial_moviles

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat
import kotlinx.android.synthetic.main.activity_pagina_facebook.*

class paginaFacebook : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pagina_facebook)

        if(ActivityCompat.checkSelfPermission(this, android.Manifest.permission.INTERNET)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.INTERNET),111)
        } // se encarga de pedir los permisos si el usuario no los ha dado desde la instanación
        wv1.webViewClient = MyWebViewClient()
        wv1.loadUrl("https://www.facebook.com/DON-pepito-107761961122853")//dirije a la url de la pagina de facebook
    }
/*
El visor reconoce la url y por defecto intenta acceder desde el navegador, por eso se crea esta clase que
obliga a la aplicación a ignorar el navegador predeterminado y abrir la url desde la activity
 */
    class MyWebViewClient : WebViewClient(){
        override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
            if (url != null) {
                view?.loadUrl(url)
            }
            return(true)
        }
    }
}






















