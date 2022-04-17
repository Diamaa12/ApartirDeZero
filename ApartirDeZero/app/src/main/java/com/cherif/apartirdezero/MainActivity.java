package com.cherif.apartirdezero;

import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    private final String defaut = "Cliquer sur le bouton << Calculer IMC >> pour voire les résultats";
    private final String megaString = "Vous êtes en poids normale";
    private TextView mMatext, mText;
    private LinearLayout layout;
    private EditText mInputPoids, mInputTaille;
    private CheckBox mCheckBox;
    private RadioGroup mRadioButton1;

    private Button mImc, mRaz;
    private TextView mResultat, mPoids, mTaille, mTextFinal;
    private final TextWatcher texWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            mResultat.setText(defaut);
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };
    private final View.OnClickListener envoyerListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (!mCheckBox.isChecked()) {

                String t = mInputPoids.getText().toString();

                String p = mInputTaille.getText().toString();

                float tValue = Float.valueOf(t);

                if (tValue == 0) {
                    Toast.makeText(MainActivity.this, "Votre poids n'est quand même pas égal à Zéro !", Toast.LENGTH_LONG).show();

                } else {
                    float pValue = Float.valueOf(p);

                    if (mRadioButton1.getCheckedRadioButtonId() == R.id.view_rbtn_2)
                        tValue = tValue / 100;
                    tValue = (float) Math.pow(tValue, 2);

                    float imc = pValue / tValue;
                    mResultat.setText("votre IMC est " + imc);
                    mResultat.getResources().getColor(R.color.magenta);
                }

            } else {

                mResultat.setTextSize(20);
                mResultat.setText(megaString);
                mResultat.getResources().getColor(R.color.magenta);


            }
        }
    };
    private final View.OnClickListener razListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mInputPoids.getText().clear();
            mInputTaille.getText().clear();
            mResultat.setText(defaut);
        }
    };
    private final View.OnClickListener checkListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (!((CheckBox) v).isChecked() && mResultat.getText().equals(megaString)) {
                mResultat.setText(defaut);
            }
        }
    };

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //layout = (LinearLayout) LinearLayout.inflate(this,R.layout.activity_main, null);

        mMatext = findViewById(R.id.ma_vue);
        mText = findViewById(R.id.view_poids);
        layout = findViewById(R.id.myLayout);

        mPoids = findViewById(R.id.view_poids);
        mTaille = findViewById(R.id.view_taille);
        mResultat = findViewById(R.id.view_resultat);

        mInputPoids = findViewById(R.id.view_input_poid);
        mInputTaille = findViewById(R.id.view_input_taille);

        mRadioButton1 = findViewById(R.id.view_radio_groupe);


        mCheckBox = findViewById(R.id.view_checkBox);

        mImc = findViewById(R.id.view_btn_1);
        mRaz = findViewById(R.id.view_btn_2);

        mResultat = findViewById(R.id.view_resultat);
        mTextFinal = findViewById(R.id.view_txt_final);

        //Attrubition de Listerner aux widgets qui en ont besoin

        mImc.setOnClickListener(envoyerListener);
        mRaz.setOnClickListener(razListener);

        mInputTaille.addTextChangedListener(texWatcher);
        mInputPoids.addTextChangedListener(texWatcher);

        mCheckBox.setOnClickListener(checkListener);


        Resources res = getResources();

        String chaine = res.getString(R.string.hello, "Mouhamad", 22);
        mMatext.getResources().getColor(R.color.purple_200);
        mMatext.setText(chaine);
        mText.getResources().getColor(R.color.teal_700);


        //En java
        TextView myTexview = new TextView(this);
        myTexview.setText(R.string.titre2);
        myTexview.setTextSize(35);
        myTexview.setGravity(Gravity.CENTER);
        myTexview.setTextColor(0x112211);
        layout.addView(myTexview);


    }
}