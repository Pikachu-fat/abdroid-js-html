package com.example.weijianqiang.testschemetwo.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.weijianqiang.testschemetwo.R;

public class MinitypeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_minitype);
        TextView tv1 = (TextView) findViewById(R.id.tv1);
        if (getIntent() != null){
            tv1.setText(getIntent().getType());
        }
    }
}
