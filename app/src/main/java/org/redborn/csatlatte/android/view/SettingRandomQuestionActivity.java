package org.redborn.csatlatte.android.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import org.redborn.csatlatte.android.R;
import org.redborn.csatlatte.android.view.commons.Navigation;

/**
 * Created by admin on 2017-06-16.
 */

public class SettingRandomQuestionActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting_random_question_activity);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Button btnSettingRandomQuestionComplete = (Button) findViewById(R.id.btn_setting_random_question_complete);
        btnSettingRandomQuestionComplete.setOnClickListener(this);
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

        if (id == R.id.btn_setting_random_question_complete) {
            intent = new Intent(context, SettingActivity.class);
            finish();
        }

        if (intent != null) {
            startActivity(intent);

        }
    }
}
