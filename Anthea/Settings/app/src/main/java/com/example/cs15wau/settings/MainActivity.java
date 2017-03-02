package com.example.cs15wau.settings;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    RadioGroup rg;
    RadioButton rb;
    CheckBox a;

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rg = (RadioGroup) findViewById(R.id.radioGender);
        a = (CheckBox) findViewById(R.id.notify_me_checkbox);
        a.setOnClickListener(this);
        Switch i = (Switch) findViewById(R.id.soundSwitch);
        i.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(getApplicationContext(), "On", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Off", Toast.LENGTH_LONG).show();

                }
            }
        });
    }


    public void genderChoice(View v) {
        int radiobuttonid = rg.getCheckedRadioButtonId();
        rb = (RadioButton) findViewById(radiobuttonid);
        Toast.makeText(getBaseContext(), rb.getText(), Toast.LENGTH_LONG).show();
    }

    @Override
    //method which gets called whether the checkbox is checked or not
    public void onClick(View view) {

        CheckBox b = (CheckBox) view;
        if (b.isChecked()) {
            Toast.makeText(this, "Timer On", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Timer Off", Toast.LENGTH_SHORT).show();

        }

    }
}
