package org.redborn.csatlatte.android.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import org.redborn.csatlatte.android.R;

/**
 * Created by admin on 2017-06-21.
 */

public class MyInfoActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView myinfoListView = null;
    private ListViewAdapter adapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myinfo_activity);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        myinfoListView = (ListView) findViewById(R.id.settingListView);
        adapter = new ListViewAdapter(this);
        myinfoListView.setAdapter(adapter);

        adapter.addItem(getResources().getDrawable(R.drawable.ic_login), "비밀번호 변경");
        adapter.addItem(getResources().getDrawable(R.drawable.ic_lock), "보안질문 변경");
        adapter.addItem(getResources().getDrawable(R.drawable.ic_person), "프로필 사진 및 닉네임 변경");
        adapter.addItem(getResources().getDrawable(R.drawable.ic_change_csat), "수능 변경");
        adapter.addItem(getResources().getDrawable(R.drawable.ic_logout), "로그아웃");

        myinfoListView.setOnItemClickListener(this);
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
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        ListData data = adapter.listData.get(i);
        Context context = getApplicationContext();
        Intent intent = null;

        if (data.title == "비밀번호 변경") {

        } else if (data.title == "보안질문 변경") {

        } else if (data.title == "프로필 사진 및 닉네임 변경") {

        } else if (data.title == "수능 변경") {

        } else if (data.title == "로그아웃") {

        }

        if (intent != null) {
            startActivity(intent);
        }
    }

}
