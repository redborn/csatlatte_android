package org.redborn.csatlatte.android.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import org.redborn.csatlatte.android.R;
import org.redborn.csatlatte.android.view.commons.CsatlatteActivity;

/**
 * Created by admin on 2017-06-16.
 */

public class FindIdResultActivity extends CsatlatteActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.find_id_result_activity);
        ImageView appBarBackground = (ImageView) findViewById(R.id.app_bar_background);
        appBarBackground.setImageResource(R.drawable.find_title);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button btnFindPassword = (Button) findViewById(R.id.btn_find_password);
        Button btnFindIdResult = (Button) findViewById(R.id.btn_find_id_result);
        btnFindPassword.setOnClickListener(this);
        btnFindIdResult.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        Context context = getApplicationContext();
        Intent intent = null;

        if (id == R.id.btn_find_password) {
            intent = new Intent(context, FindPasswordActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);

        } else if (id == R.id.btn_find_id_result) {
            intent = new Intent(context, LoginIdActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        }

        if (intent != null) {
            startActivity(intent);
        }
    }
}