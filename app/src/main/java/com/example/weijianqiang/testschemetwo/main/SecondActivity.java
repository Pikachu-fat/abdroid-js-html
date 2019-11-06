package com.example.weijianqiang.testschemetwo.main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.weijianqiang.testschemetwo.R;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        findViewById(R.id.second).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //finish();
                Intent intent = new Intent(SecondActivity.this,ThirdActivity.class);
//                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });
        Log.d("test_aa",this.toString());
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("test_aa","onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("test_aa","onDestroy");
    }
}
