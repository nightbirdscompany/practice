package com.nightbirds.newpractice;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawlay;
    MaterialToolbar toolbar;
    FrameLayout framlay;
    NavigationView navview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        drawlay = findViewById(R.id.drawlay);
        toolbar =findViewById(R.id.toolbar);
        framlay =findViewById(R.id.framlay);
        navview = findViewById(R.id.navview);


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                MainActivity.this, drawlay, toolbar, R.string.drawer_close, R.string.drawer_open);

        drawlay.addDrawerListener(toggle);

        navview.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                if (menuItem.getItemId()==R.id.nav_home){
                    Toast.makeText(MainActivity.this, "yeh working", Toast.LENGTH_LONG).show();
                    drawlay.closeDrawer(GravityCompat.START);
                }

              else   if (menuItem.getItemId()==R.id.nav_noti){
                    Toast.makeText(MainActivity.this, "yeh working", Toast.LENGTH_LONG).show();
                    drawlay.closeDrawer(GravityCompat.START);
                }

              else   if (menuItem.getItemId()==R.id.fb_page){
                    Toast.makeText(MainActivity.this, "yeh working", Toast.LENGTH_LONG).show();
                    drawlay.closeDrawer(GravityCompat.START);
                }

                else   if (menuItem.getItemId()==R.id.yt_channel){
                    Toast.makeText(MainActivity.this, "yeh working", Toast.LENGTH_LONG).show();
                    drawlay.closeDrawer(GravityCompat.START);
                }

                else   if (menuItem.getItemId()==R.id.settings){
                    Toast.makeText(MainActivity.this, "yeh working", Toast.LENGTH_LONG).show();
                    drawlay.closeDrawer(GravityCompat.START);
                }
                return true;
            }
        });

    }
    //========= ON creat end



}