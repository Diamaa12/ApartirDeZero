package com.cherif.apartirdezero;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;


public class Activity3 extends AppCompatActivity {

    EditText champ1;
    EditText champ2;
    EditText champ3;
    EditText champ4;
    EditText champ5;
    EditText champ6;
    EditText champ7;

    EditText mRsultat1;
    Button mMoyen1, mMoyen2, mMoyen3;

    Button reset = null;
    ViewGroup group1, group2, group3;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        champ1 = findViewById(R.id.trmst1_btn1);
        champ2 = findViewById(R.id.trmst1_btn2);
        champ3 = findViewById(R.id.trmst1_btn3);
        champ4 = findViewById(R.id.trmst1_btn4);
        champ5 = findViewById(R.id.trmst1_btn5);
        champ6 = findViewById(R.id.trmst1_btn6);
        champ7 = findViewById(R.id.trmst1_btn7);

        mRsultat1 = findViewById(R.id.etxt_rst_1);
        mMoyen1 = findViewById(R.id.btn_view_rst1);

        reset = findViewById(R.id.reinitialiser);

        //Selection des EditText qui sont contenu dans la LinearLayout ayant l'id linear_1
        group1 = findViewById(R.id.linear_1);
        group2 = findViewById(R.id.linear_2);
        group3 = findViewById(R.id.linear_3);


        mMoyen1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String[] saisi = new String[7];

                saisi[0] = champ1.getText().toString();

                saisi[1] = champ2.getText().toString();
                saisi[2] = champ3.getText().toString();
                saisi[3] = champ4.getText().toString();
                saisi[4] = champ5.getText().toString();
                saisi[5] = champ6.getText().toString();
                saisi[6] = champ7.getText().toString();

                Integer convert = 0;
                for (int i = 0; i < saisi.length; i++) {

                    convert = convert + Integer.parseInt(saisi[i]);
                    System.out.println("Nous sommes à cette étape " + convert);
                }
                //Il faudra recuperer la moyenne ici avant de la convertir en String

                System.out.println("La somme total est de:" + convert);
                Log.d("Erreur 1", "Message 1");

                System.out.println("Calculer la moyenne des notes");
                Integer moyen = 0;
                moyen = convert / saisi.length;
                System.out.println("La Somme de Notes est:" + saisi.length);
                System.out.println("La moyenne des Notes est: " + moyen);
                String resfinal = moyen.toString();
                mRsultat1.setText(resfinal);


            }
        });
        //Reinitialisation des cases des EditText
        reset.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {


                for (int i = 0, count = group1.getChildCount(); i < count; i++) {
                    View view = group1.getChildAt(i);
                    if (view instanceof EditText) {
                        ((EditText) view).setText("");
                    }
                }
                for (int i = 0, count = group2.getChildCount(); i < count; i++) {
                    View view = group2.getChildAt(i);
                    if (view instanceof EditText) {
                        ((EditText) view).setText("");
                    }
                }
                for (int i = 0, count = group3.getChildCount(); i < count; i++) {
                    View view = group3.getChildAt(i);
                    if (view instanceof EditText) {
                        ((EditText) view).setText("");
                    }
                }
            }
        });

    }

}