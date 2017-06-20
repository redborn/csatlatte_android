package org.redborn.csatlatte.android.view.commons;

import android.content.Context;
import android.content.Intent;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import org.redborn.csatlatte.android.R;
import org.redborn.csatlatte.android.view.LoginIdActivity;
import org.redborn.csatlatte.android.view.MainActivity;
import org.redborn.csatlatte.android.view.RandomQuestionActivity;
import org.redborn.csatlatte.android.view.RandomQuestionResultActivity;
import org.redborn.csatlatte.android.view.SettingActivity;

/**
 * Created by admin on 2017-06-14.
 */

public class Navigation {

    Context context;

    public Navigation(Context context) {
        this.context = context;
    }

    public Intent select(MenuItem item) {
        int id = item.getItemId();
        Intent intent = new Intent();

        if (id == R.id.nav_home) {
            intent = new Intent(context, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);

        } else if (id == R.id.nav_random_question) {
            intent = new Intent(context, RandomQuestionActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);

        } else if (id == R.id.nav_settings) {
            intent = new Intent(context, SettingActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);

        }

        return intent;
    }

    public Intent header(View view) {
        int id = view.getId();
        Intent intent = null;

        if (id == R.id.nav_header_layout) {
            intent = new Intent(context, LoginIdActivity.class);
        }

        return intent;
    }

}
