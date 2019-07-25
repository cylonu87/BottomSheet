package org.michaelbel.sample.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.StyleRes;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import org.michaelbel.sample.BuildConfig;
import org.michaelbel.sample.R;

public class MainActivity extends AppCompatActivity {

    public Toolbar toolbar;
    public FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fab = findViewById(R.id.fab);
    }

    @Override
    public void setTheme(@StyleRes int resId) {
        SharedPreferences prefs = getSharedPreferences("mainconfig", MODE_PRIVATE);
        boolean appTheme = prefs.getBoolean("theme", true);
        super.setTheme(appTheme ? R.style.AppThemeLight : R.style.AppThemeDark);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(R.string.about)
            .setIcon(R.drawable.ic_about)
            .setShowAsActionFlags(MenuItem.SHOW_AS_ACTION_IF_ROOM)
            .setOnMenuItemClickListener(item -> {
                View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.about_view, null);
                TextView textView = view.findViewById(R.id.text_view);
                textView.setText(getString(R.string.version_build_date, BuildConfig.VERSION_NAME, BuildConfig.VERSION_CODE, BuildConfig.VERSION_DATE));

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle(R.string.about);
                builder.setView(view);
                builder.setPositiveButton(R.string.ok, null);
                builder.show();
                return true;
            });

        menu.add(R.string.view_github)
            .setIcon(R.drawable.ic_github)
            .setShowAsActionFlags(MenuItem.SHOW_AS_ACTION_IF_ROOM)
            .setOnMenuItemClickListener(menuItem -> {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.github_url))));
                return true;
            });

        menu.add(R.string.change_theme)
            .setIcon(R.drawable.ic_theme)
            .setShowAsActionFlags(MenuItem.SHOW_AS_ACTION_IF_ROOM)
            .setOnMenuItemClickListener(menuItem -> {
                SharedPreferences prefs = getSharedPreferences("mainconfig", MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                boolean appTheme = prefs.getBoolean("theme", true);
                editor.putBoolean("theme", !appTheme);
                editor.apply();
                recreate();
                return true;
            });

        return super.onCreateOptionsMenu(menu);
    }
}