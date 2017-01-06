package com.example.android.homepagev3;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ExpandableListView;
import java.util.ArrayList;
import android.os.Bundle;
import android.app.Activity;
import android.app.SearchManager;
import android.content.Context;
import android.view.Menu;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.SearchView;

import static android.R.attr.resource;

public class homepage extends Activity {

    ListView lv;
    EditText et;
    String[] skills = {"Organisation", "Initiative", "Creativity", "Client focus", "Commercial awareness", "Communication", "Teamwork", "Leadership", "Self motivation", "Adaptability", "Time management", "Decision making", "Trustworthiness"};
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_homepage);

        lv = (ListView) findViewById(R.id.skills_list_view);
        et = (EditText) findViewById(R.id.skills_search_view);

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, skills);
        lv.setAdapter(adapter);


        };



    }
}
