package com.example.broadcasttest;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	private IntentFilter intentFilter;
	private LocalReceiver localReceiver;
//	private NetworkChangeReceiver networkChangeReceiver;
	private LocalBroadcastManager localBroadcastManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        localBroadcastManager = LocalBroadcastManager.getInstance(this);
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new OnClickListener(){
        	@Override
        	public void onClick(View v){
        		Intent intent = new Intent("com.example.broadcasttest.LOCAL_BROADCAST");
//        		sendOrderedBroadcast(intent,null);
        		localBroadcastManager.sendBroadcast(intent);
        	}
        });
        intentFilter = new IntentFilter();
        intentFilter.addAction("com.example.broadcasttest.LOCAL_BROADCAST");
        localReceiver = new LocalReceiver();
        localBroadcastManager.registerReceiver(localReceiver, intentFilter);
    }

    @Override
    protected void onDestroy(){
    	super.onDestroy();
//    	unregisterReceiver(networkChangeReceiver);
    	localBroadcastManager.unregisterReceiver(localReceiver);
    }
    
    class LocalReceiver extends BroadcastReceiver {
    	
    	@Override
    	public void onReceive(Context context,Intent intent){
//    		ConnectivityManager connectionManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
//    		NetworkInfo networkInfo = connectionManager.getActiveNetworkInfo();
//    		if (networkInfo != null && networkInfo.isAvailable()){
//    			Toast.makeText(context, "network is available", Toast.LENGTH_SHORT).show();
//    		}else{
//    			Toast.makeText(context, "network is unavailable", Toast.LENGTH_SHORT).show();
//    		}
    		Toast.makeText(context, "received local broadcast", Toast.LENGTH_LONG).show();
    	}
    }

}
