package com.example.iitomoki.qr_load

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.google.zxing.integration.android.IntentIntegrator
import com.google.zxing.integration.android.IntentResult
import android.content.Intent
import android.util.Log

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        IntentIntegrator(this@MainActivity).initiateScan()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        /*IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if(result != null) {
            Log.d("readQR", result.getContents());
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }*/
        Log.d("TAG", "onActivityResult Start")
        Log.d("TAG", "requestCode: $requestCode resultCode: $resultCode data: $data")
        val intentResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)
        // null の場合
        if (intentResult == null) {
            Log.d("TAG", "Weird")
            super.onActivityResult(requestCode, resultCode, data)
            return
        }

        if (intentResult.contents == null) {
            // 戻るボタンをタップした場合
            Log.d("TAG", "Cancelled Scan")

        } else {
            // カメラで読み取った情報をラベルに表示
            Log.d("TAG", "Scanned! " + intentResult.contents)
        }
    }
}
