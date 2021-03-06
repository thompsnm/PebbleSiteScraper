package com.pebblesifter.android;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.ViewGroup;
import android.widget.Button;

import com.getpebble.android.kit.PebbleKit;
import com.pebblesifter.android.asyncTasks.DrawApp;
import com.pebblesifter.android.asyncTasks.SendSifters;
import com.pebblesifter.android.sifters.PebbleSifter;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {

  public static ArrayList<Button> sifterButtons = new ArrayList<Button>();
  public static ArrayList<PebbleSifter> sifters = new ArrayList<PebbleSifter>();

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    Log.i("MainActivity", "Called onCreate");
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
  }

  @Override
  protected void onStart() {
    DrawApp drawApp = new DrawApp(this, sifters.size() == 0);
    drawApp.execute();
    super.onStart();
  }

  @Override
  protected void onNewIntent(Intent intent) {
    Log.i("MainActivity", "Called onNewIntent");
    setIntent(intent);
    if (intent.hasExtra("handshake")) {
      SendSifters sendSifters = new SendSifters(this, sifters);
      sendSifters.execute();
    }
  }

  @Override
  protected void onStop() {
    ((ViewGroup)this.findViewById(R.id.button_layout)).removeAllViews();
    super.onStop();
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.main, menu);
    return true;
  }

}
