package org.redborn.csatlatte.android.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import org.redborn.csatlatte.android.R;
import org.redborn.csatlatte.android.view.commons.Navigation;

/**
 * Created by admin on 2017-06-16.
 */

public class FindPasswordResultActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.find_password_result_activity);
        ImageView appBarBackground = (ImageView) findViewById(R.id.app_bar_background);
        appBarBackground.setImageResource(R.drawable.find_title);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button btnFindPasswordSuccess = (Button) findViewById(R.id.btn_find_password_success);
        btnFindPasswordSuccess.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        Context context = getApplicationContext();
        Intent intent = new Navigation(context).header(view);

        if (id == R.id.btn_find_password_success) {
            intent = new Intent(context, LoginIdActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        }

        if (intent != null) {
            startActivity(intent);
        }
    }
}
