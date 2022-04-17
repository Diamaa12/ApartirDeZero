package com.cherif.les_intents;

import android.app.Activity;
import android.os.Bundle;

public class PreferenceActivity extends Activity {
    
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.my_preference);


    }

    private void addPreferencesFromResource(int my_preference) {
    }
}
