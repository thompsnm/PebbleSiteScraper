package com.pebblesifter;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

import com.example.pebblesifter.R;
import com.pebblesifter.sifters.PebbleSifter;
import com.pebblesifter.sifters.TeamTriviaAnswerSifter;

public class MainActivity extends Activity {

//	PebbleSifter sifter = new TeamTriviaAnswerSifter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//		TextView name = (TextView) findViewById(R.id.sifter_name);
//		name.setText("Name");
//		TextView siftedText = (TextView) findViewById(R.id.sifted_text);
//		siftedText.setText("Text");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
