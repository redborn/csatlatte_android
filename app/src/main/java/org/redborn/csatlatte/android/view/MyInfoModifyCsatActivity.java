package org.redborn.csatlatte.android.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import org.redborn.csatlatte.android.R;
import org.redborn.csatlatte.android.view.commons.Navigation;

import java.util.ArrayList;

/**
 * Created by admin on 2017-06-21.
 */

public class MyInfoModifyCsatActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myinfo_modify_csat_activity);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ArrayList<String> satList = new ArrayList<String>();
        satList.add("2018학년도 대학수학능력시험(2017년 실시)");
        satList.add("2019학년도 대학수학능력시험");
        satList.add("2020학년도 대학수학능력시험");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, satList);

        Spinner spinner = (Spinner) findViewById(R.id.spinner_sat_list);
        spinner.setAdapter(adapter);

        Button btnMyInfoModifyCsatComplete = (Button) findViewById(R.id.btn_myinfo_modify_csat_complete);
        btnMyInfoModifyCsatComplete.setOnClickListener(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        boolean result = super.onOptionsItemSelected(item);
        int id = item.getItemId();

        if (id == android.R.id.home) {
            onBackPressed();
            result = true;
        }

        return result;
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        Context context = getApplicationContext();
        Intent intent = new Navigation(getApplicationContext()).header(view);

        if (id == R.id.btn_myinfo_modify_csat_complete) {
            onBackPressed();
        }

        if (intent != null) {
            startActivity(intent);
        }
    }
}
