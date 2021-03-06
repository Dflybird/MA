package com.example.gq.ma.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import com.example.gq.ma.R;
import com.example.gq.ma.base.BaseActivity;
import com.example.gq.ma.bean.Target;
import com.example.gq.ma.bean.Terrain;
import com.example.gq.ma.utils.GLog;

public class AddTActivity extends BaseActivity {

    private EditText nameET;
    private EditText locationET;
    private EditText timeET;
    private Button addBT;
    private RadioButton isTypeRB;

    private boolean isTerrain;

    public static void terrainActionStart(Context context){
        Intent intent = new Intent(context, AddTActivity.class);
        intent.putExtra("isTerrain",  true);
        context.startActivity(intent);
    }

    public static void targetActionStart(Context context){
        Intent intent = new Intent(context, MainActivity.class);
        intent.putExtra("isTerrain", false);
        context.startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            GLog.d(Integer.toString(item.getItemId()));
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_t_add);

        isTerrain = getIntent().getBooleanExtra("isTerrain", false);

        nameET = findViewById(R.id.t_add_name);
        locationET = findViewById(R.id.t_add_location);
        timeET = findViewById(R.id.t_add_time);
        addBT = findViewById(R.id.add_bt);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowCustomEnabled(true);
            actionBar.setDisplayShowHomeEnabled(false);
            actionBar.setDisplayShowTitleEnabled(true);
            setTitle("添加");
        }

        addBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validate()){
                    if (isTerrain){
                        Terrain terrain = new Terrain();
                        terrain.setName(nameET.getText().toString());
                        terrain.setLastDetectTime(timeET.getText().toString());
                        terrain.setLocation(locationET.getText().toString());

                        terrain.save();
                    } else {
                        Target target = new Target();
                        target.setName(nameET.getText().toString());
                        target.setLastTransportTime(timeET.getText().toString());
                        target.setLocation(locationET.getText().toString());

                        target.save();
                    }
                }

            }
        });

    }

    private boolean validate() {
        return  true;
    }
}
