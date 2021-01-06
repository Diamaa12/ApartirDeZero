package com.cherif.les_intents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class AutreActivity extends AppCompatActivity {

        private LinearLayout mLayout1;
        private Button mDeconnecter,mVisiteSite;
        public final static String BUTTONS = "DEUXIÈME_ACTIVITY";
        public final static int ACTIVITY_ID = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_autre);


        mLayout1 = (LinearLayout)findViewById(R.id.my_layout);
        mDeconnecter = (Button) findViewById(R.id.SeDeconnecter);
        mVisiteSite = (Button) findViewById(R.id.Visiter_site);
        EditText recupText = new EditText(this);

        Intent my_intent = getIntent();

        String text = my_intent.getStringExtra(MainActivity.USERNAME);
        recupText.setText(text);
        recupText.setTextColor(getResources().getColor(R.color.teal_200));
        recupText.setGravity(Gravity.CENTER);
        recupText.setTextSize(25);
        mLayout1.addView(recupText);

        mDeconnecter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_retour = new Intent();

                intent_retour.putExtra(MainActivity.USERNAME,text);
                setResult(RESULT_OK, intent_retour);
                finish();
            }
        });

        mVisiteSite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri bombilafou = Uri.parse("tel:06-06-24-46-78");
                Intent visiter_bombilafou = new Intent(Intent.ACTION_DIAL,bombilafou);
                startActivity(visiter_bombilafou);

            }
        });
    }
}