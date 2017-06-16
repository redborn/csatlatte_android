package org.redborn.csatlatte.android.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
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
 * Created by admin on 2017-06-15.
 */

public class LoginIdActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_id_activity);
        ImageView appBarBackground = (ImageView) findViewById(R.id.app_bar_background);
        appBarBackground.setImageResource(R.drawable.login_title);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.login_id_drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        View headerLayout = navigationView.getHeaderView(0);
        LinearLayout linearLayout = (LinearLayout) headerLayout.findViewById(R.id.nav_header_layout);
        linearLayout.setOnClickListener(this);

        Button btnLoginNext = (Button) findViewById(R.id.btn_login_next);
        Button btnJoin = (Button) findViewById(R.id.btn_join);
        btnLoginNext.setOnClickListener(this);
        btnJoin.setOnClickListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        boolean result = false;
        Intent intent = new Navigation(getApplicationContext()).select(item);

        if (intent != null) {
            result = true;
            startActivity(intent);

            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.login_id_drawer_layout);
            drawer.closeDrawer(GravityCompat.START);
        }

        return result;
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        Context context = getApplicationContext();
        Intent intent = new Navigation(context).header(view);

        if (id == R.id.btn_login_next) {
            intent = new Intent(context, LoginPasswordActivity.class);

        } else if (id == R.id.btn_join) {
            intent = new Intent(context, JoinLoginInfoActivity.class);

        }

        if (intent != null) {
            startActivity(intent);

            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.login_id_drawer_layout);
            drawer.closeDrawer(GravityCompat.START);
        }
    }
}
