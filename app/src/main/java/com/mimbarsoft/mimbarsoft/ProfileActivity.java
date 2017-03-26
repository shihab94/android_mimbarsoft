package com.mimbarsoft.mimbarsoft;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Bundle bundle = getIntent().getExtras();
        String id = bundle.getString("name");
        int width = bundle.getInt("width");
        int height = bundle.getInt("height");

        ImageView empImage = (ImageView) findViewById(R.id.emp_image);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int screenWidth = (displayMetrics.widthPixels/3);
        int sereenHeight = (displayMetrics.heightPixels/3);
        empImage.getLayoutParams().width = screenWidth;
        empImage.getLayoutParams().height = sereenHeight;

        TextView empName = (TextView) findViewById(R.id.emp_name);
        TextView empDesignation = (TextView) findViewById(R.id.emp_designation);
        TextView empDescription = (TextView) findViewById(R.id.emp_description);

        if(id.equals("imageView_nayeem")){
            empImage.setImageResource(R.drawable.nayeem);
            empName.setText(R.string.emp1_name);
            empDesignation.setText(R.string.emp1_designation);
            empDescription.setText(R.string.emp1_description);
        }else if(id.equals("imageView_rahamat")){
            empImage.setImageResource(R.drawable.rahamat);
            empName.setText(R.string.emp2_name);
            empDesignation.setText(R.string.emp2_designation);
            empDescription.setText(R.string.emp2_description);
        }else if(id.equals("imageView_pial")){
            empImage.setImageResource(R.drawable.pial);
            empName.setText(R.string.emp3_name);
            empDesignation.setText(R.string.emp3_designation);
            empDescription.setText(R.string.emp3_description);
        }else if(id.equals("imageView_shihab")){
            empImage.setImageResource(R.drawable.shihab);
            empName.setText(R.string.emp4_name);
            empDesignation.setText(R.string.emp4_designation);
            empDescription.setText(R.string.emp4_description);
        }else if(id.equals("imageView_shohan")){
            empImage.setImageResource(R.drawable.nayeem);
            empName.setText(R.string.emp5_name);
            empDesignation.setText(R.string.emp5_designation);
            empDescription.setText(R.string.emp5_description);
        }else if(id.equals("imageView_taifur")){
            empImage.setImageResource(R.drawable.taifur);
            empName.setText(R.string.emp6_name);
            empDesignation.setText(R.string.emp6_designation);
            empDescription.setText(R.string.emp6_description);
        }
    }
}
