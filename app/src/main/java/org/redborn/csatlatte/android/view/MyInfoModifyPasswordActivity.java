package org.redborn.csatlatte.android.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import org.redborn.csatlatte.android.R;
import org.redborn.csatlatte.android.view.commons.CsatlatteActivity;

/**
 * Created by admin on 2017-06-21.
 */

public class MyInfoModifyPasswordActivity extends CsatlatteActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myinfo_modify_password_activity);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Button btnMyInfoModifyPasswordComplete = (Button) findViewById(R.id.btn_myinfo_modify_password_complete);
        btnMyInfoModifyPasswordComplete.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        Context context = getApplicationContext();
        Intent intent = null;

        if (id == R.id.btn_myinfo_modify_password_complete) {
            intent = new Intent(context, MyInfoActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            
        }

        if (intent != null) {
            startActivity(intent);
        }
    }
}
