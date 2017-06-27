package org.redborn.csatlatte.android.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.design.widget.NavigationView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

import org.redborn.csatlatte.android.R;
import org.redborn.csatlatte.android.view.commons.Navigation;

/**
 * Created by admin on 2017-06-08.
 */

public class RandomQuestionResultActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.random_question_result_activity);
        ImageView appBarBackground = (ImageView) findViewById(R.id.app_bar_background);
        appBarBackground.setImageResource(R.drawable.random_question_test_title);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("2016년 6월 2학년 전국연합학력평가 - 영어");
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.random_question_result_drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        View headerLayout = navigationView.getHeaderView(0);
        LinearLayout linearLayout = (LinearLayout) headerLayout.findViewById(R.id.nav_header_layout);
        linearLayout.setOnClickListener(this);

        ImageButton btnResetting = (ImageButton) findViewById(R.id.btn_resetting);
        Button btnOtherQuestion = (Button) findViewById(R.id.btn_other_question);

        btnResetting.setOnClickListener(this);
        btnOtherQuestion.setOnClickListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        boolean result = false;
        Intent intent = new Navigation(getApplicationContext()).select(item);

        if (intent != null) {
            result = true;
            startActivity(intent);

            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.random_question_result_drawer_layout);
            drawer.closeDrawer(GravityCompat.START);
        }

        return result;
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        Context context = getApplicationContext();
        Intent intent = new Navigation(getApplicationContext()).header(view);

        if (id == R.id.btn_resetting) {
            intent = new Intent(context, RandomQuestionActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);

        } else if (id == R.id.btn_other_question) {
            intent = new Intent(context, RandomQuestionTestActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);

        }

        startActivity(intent);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.random_question_result_drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
    }
}
