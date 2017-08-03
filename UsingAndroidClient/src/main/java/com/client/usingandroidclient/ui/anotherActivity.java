package com.client.usingandroidclient.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.client.usingandroidclient.R;
import com.kaltura.client.types.Asset;

public class anotherActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_another);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Bundle assetBundle = getIntent().getBundleExtra("passAsset");
        Asset asset = (Asset)assetBundle.getParcelable("passAsset");
        TextView fab = (TextView) findViewById(R.id.assetInput);
        fab.setText(asset != null  ? asset.getName() : "No Input");
    }

}
