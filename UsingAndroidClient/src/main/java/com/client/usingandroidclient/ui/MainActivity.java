package com.client.usingandroidclient.ui;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.client.usingandroidclient.APICaller;
import com.client.usingandroidclient.R;
import com.client.usingandroidclient.SessionManager;
import com.kaltura.client.types.OTTUser;
import com.kaltura.client.utils.response.OnCompletion;
import com.kaltura.client.utils.response.base.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                APICaller.login(SessionManager.get().getClient(),
                                        "albert@gmail.com", "123456",
                                        new OnCompletion<Response<OTTUser>>(){
                                            @Override
                                            public void onComplete(Response<OTTUser> result) {
                                                String message = result.error != null ? result.error.getMessage() : null;
                                                if(!result.isEmpty()) {
                                                    Toast.makeText(MainActivity.this,
                                                            "hello "+ result.results.getFirstName(),
                                                            Toast.LENGTH_LONG).show();
                                                }
                                            }
                                        });
                            }
                        }).show();
            }
        });
    }

}
