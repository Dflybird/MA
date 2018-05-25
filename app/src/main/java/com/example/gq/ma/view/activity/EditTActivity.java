package com.example.gq.ma.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
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

public class EditTActivity extends BaseActivity {

    private EditText nameET;
    private EditText locationET;
    private EditText timeET;
    private Button changeBT;
    private RadioButton isTypeRB;

    private boolean isTerrain;
    int id;

    public static void TerrainActionStart(Context context, int id, String name, String location,
                                   String time, boolean isType){
        Intent intent = new Intent(context, EditTActivity.class);
        intent.putExtra("isTerrain",  true);
        intent.putExtra("name", name);
        intent.putExtra("location", location);
        intent.putExtra("time", time);
        intent.putExtra("isType", isType);
        intent.putExtra("id", id);
        context.startActivity(intent);
    }

    public static void targetActionStart(Context context, int id, String name, String location,
                                   String time, boolean isType){
        Intent intent = new Intent(context, EditTActivity.class);
        intent.putExtra("isTerrain",  false);
        intent.putExtra("name", name);
        intent.putExtra("location", location);
        intent.putExtra("time", time);
        intent.putExtra("isType", isType);
        intent.putExtra("id", id);
        context.startActivity(intent);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_t_edit);

        nameET = findViewById(R.id.t_edit_name);
        locationET = findViewById(R.id.t_edit_location);
        timeET = findViewById(R.id.t_edit_time);
        changeBT = findViewById(R.id.change_bt);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowCustomEnabled(true);
            actionBar.setDisplayShowHomeEnabled(false);
            actionBar.setDisplayShowTitleEnabled(true);
            setTitle("修改");
        }

        Intent intent = getIntent();
        isTerrain = intent.getBooleanExtra("isTerrain", false);
        id = intent.getIntExtra("id", 0);
        nameET.setText(intent.getStringExtra("name"));
        locationET.setText(intent.getStringExtra("location"));
        timeET.setText(intent.getStringExtra("time"));

        changeBT.setOnClickListener(new View.OnClickListener() {
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

                        target.update(id);
                    }
                }
            }
        });
    }

    private boolean validate() {
        return true;
    }
}
