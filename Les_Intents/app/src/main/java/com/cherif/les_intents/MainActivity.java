package com.cherif.les_intents;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import static com.cherif.les_intents.R.id.*;

public class MainActivity extends AppCompatActivity {


    private EditText mPsseudo, mPassword;
    private Button mConnecter;
    private LinearLayout myLayout;
    public final static String USERNAME = "USERNAME";
    public final static String PASSWORD = "PASSWORD";
    public  final static int ID_ACTIVITY = 0;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPsseudo = (EditText) findViewById(view_pseudo);
        mPassword = (EditText) findViewById(view_pass);
        mConnecter = (Button) findViewById(view_button);
        myLayout = (LinearLayout) findViewById(user_name);

        mConnecter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Vous venez de cliquer sur le Button!");
                String pseudo = mPsseudo.getText().toString();
                String password = mPassword.getText().toString();

                Intent intent = new Intent(MainActivity.this, AutreActivity.class);
                intent.putExtra(USERNAME, pseudo);
                intent.putExtra(PASSWORD, password);

                startActivityForResult(intent, ID_ACTIVITY);

            }
        });

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ID_ACTIVITY) {
            if (resultCode == RESULT_OK) {

                TextView myTextView = new TextView(this);
                String users = data.getStringExtra((USERNAME));

                myTextView.setText(users);
                myTextView.setTextSize(30);
                myTextView.getResources().getColor(R.color.teal_200);
                myLayout.addView(myTextView);
                Toast.makeText(this, "Vous voilà de retour M. " + users, Toast.LENGTH_LONG).show();
            }
        }
    }
}