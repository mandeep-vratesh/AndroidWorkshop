package com.example.mandeep.androidworkshop;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.TextView;

/**
 * Created by MANDEEP on 3/29/2017.
 */
public class ContactDetailsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contactdetails);

        WebView qr = (WebView) findViewById(R.id.qr);

        Bundle b = getIntent().getExtras();
        String name = b.getString("name");
        String number = b.getString("number");

        qr.loadUrl("http://api.qrserver.com/v1/create-qr-code/?color=000000&bgcolor=FFFFFF&data="+name+","+number+"&qzone=1&margin=0&size=400x400&ecc=L");
    }
}
