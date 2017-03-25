package com.mimbarsoft.mimbarsoft;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private LinearLayout amazingTeam;
    private RecyclerView recyclerView;
    private SliderAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // slider code
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        adapter = new SliderAdapter(SliderData.getData(),this);
        recyclerView.setAdapter(adapter);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),SendingMailActivity.class);
                startActivity(i);
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        // setting width and height of the image resources
        DisplayMetrics displaymetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        int screenWidth = (displaymetrics.widthPixels/4);
        int screenHeight = (displaymetrics.heightPixels/3);
        //Toast.makeText(getApplicationContext(),String.valueOf(screenWidth),Toast.LENGTH_LONG).show();
        // nayeem
        ImageView imageView_nayeem = (ImageView) findViewById(R.id.imageView_nayeem);
        imageView_nayeem.getLayoutParams().width = screenWidth;
        imageView_nayeem.getLayoutParams().height = screenWidth;
        // rahamat
        ImageView imageView_rahamat = (ImageView) findViewById(R.id.imageView_rahamat);
        imageView_rahamat.getLayoutParams().width = screenWidth;
        imageView_rahamat.getLayoutParams().height = screenWidth;
        //pial
        ImageView imageView_pial = (ImageView) findViewById(R.id.imageView_pial);
        imageView_pial.getLayoutParams().width = screenWidth;
        imageView_pial.getLayoutParams().height = screenWidth;
        //shihab
        ImageView imageViewShihab = (ImageView) findViewById(R.id.imageView_shihab);
        imageViewShihab.getLayoutParams().width = screenWidth;
        imageViewShihab.getLayoutParams().height = screenWidth;
        // shohan
        ImageView imageView_shohan = (ImageView) findViewById(R.id.imageView_shohan);
        imageView_shohan.getLayoutParams().width = screenWidth;
        imageView_shohan.getLayoutParams().height = screenWidth;
        // taifur
        ImageView imageView_taifur = (ImageView) findViewById(R.id.imageView_taifur);
        imageView_taifur.getLayoutParams().width = screenWidth;
        imageView_taifur.getLayoutParams().height = screenWidth;
    }

    // Event handling for team image
    public void showProfile(View view){
        String name = view.getResources().getResourceEntryName(view.getId());
        Intent i = new Intent(getApplicationContext(),ProfileActivity.class);
        i.putExtra("name",name);
        startActivity(i);
    }

    // contact us image button listener
    public void toFacebook(View view){
        Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.facebook.com/mimbarsoft"));
        startActivity(intent);
    }
    public void toTwitter(View view){
        Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("https://twitter.com/mimbarsoft"));
        startActivity(intent);
    }
    public void toGoogle(View view){
        Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.linkedin.com/company/mimbarsoft"));
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_rating) {
            Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("https://play.google.com/store?hl=en"));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_services) {
            NestedScrollView scrollView = (NestedScrollView) findViewById(R.id.content_main);
            View targetView = (View) findViewById(R.id.services_layout);
            scrollView.smoothScrollTo(0,(int)targetView.getTop()); // getTop supports all api where getY support api level 11 to upper

            //View targetView = (View) findViewById(R.id.textView7);
            //targetView.getParent().requestChildFocus(targetView,targetView);
        } else if (id == R.id.nav_work) {
            NestedScrollView scrollView = (NestedScrollView) findViewById(R.id.content_main);
            View targetView = (View) findViewById(R.id.latest_work);
            scrollView.smoothScrollTo(0,(int)targetView.getTop());
        } else if (id == R.id.nav_team) {
            NestedScrollView scrollView = (NestedScrollView) findViewById(R.id.content_main);
            View targetView = (View) findViewById(R.id.heading_team);
            scrollView.smoothScrollTo(0,(int)targetView.getTop());
            Toast.makeText(getApplicationContext(),"click for details",Toast.LENGTH_SHORT).show();
        }else if (id == R.id.nav_address) {
            NestedScrollView scrollView = (NestedScrollView) findViewById(R.id.content_main);
            View targetView = (View) findViewById(R.id.heading_cotact);
            scrollView.smoothScrollTo(0,(int)targetView.getTop());
        }else if (id == R.id.nav_blog) {
            Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("http://mimbarsoft.com/blog/"));
            startActivity(intent);
        }else if (id == R.id.nav_facebook) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/mimbarsoft"));
            startActivity(intent);
        }else if (id == R.id.nav_twitter) {
            Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("https://twitter.com/mimbarsoft"));
            startActivity(intent);
        }else if (id == R.id.nav_google) {
            Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.linkedin.com/company/mimbarsoft"));
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
