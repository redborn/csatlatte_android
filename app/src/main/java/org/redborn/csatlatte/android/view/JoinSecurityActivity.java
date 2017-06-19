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
import android.widget.ImageView;
import android.widget.Spinner;

import org.redborn.csatlatte.android.R;
import org.redborn.csatlatte.android.view.commons.Navigation;

import java.util.ArrayList;

/**
 * Created by admin on 2017-06-16.
 */

public class JoinSecurityActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.join_security_activity);
        ImageView appBarBackground = (ImageView) findViewById(R.id.app_bar_background);
        appBarBackground.setImageResource(R.drawable.join_title);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ArrayList<String> securityQuestionList = new ArrayList<String>();
        securityQuestionList.add("꿈의 직업이 무엇인가요?");
        securityQuestionList.add("어린 시절의 별명이 무엇이었나요?");
        securityQuestionList.add("처음 배운 요리가 어떤건가요?");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, securityQuestionList);

        Spinner spinner = (Spinner) findViewById(R.id.spinner_security_question_list);
        spinner.setAdapter(adapter);

        Button btnJoinSecurityNext = (Button) findViewById(R.id.btn_join_security_next);
        btnJoinSecurityNext.setOnClickListener(this);
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
        Intent intent = new Navigation(context).header(view);

        if (id == R.id.btn_join_security_next) {
            intent = new Intent(context, JoinProfileActivity.class);
        }

        if (intent != null) {
            startActivity(intent);
        }
    }
}
