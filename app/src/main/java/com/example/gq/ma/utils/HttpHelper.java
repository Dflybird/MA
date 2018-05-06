package com.example.gq.ma.utils;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.gq.ma.bean.Environment;
import com.example.gq.ma.config.Const;
import com.example.gq.ma.view.inter.MyTitleBarInter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class HttpHelper {

    private JSONObject jsonObject = null;
    private RequestQueue mQueue;
    private MyTitleBarInter myTitleBarInter;

    public HttpHelper(Context context, MyTitleBarInter myTitleBarInter) {
        mQueue = Volley.newRequestQueue(context);
        this.myTitleBarInter = myTitleBarInter;
    }

    public void getWeatherJson(String cityCode){
        String url = Const.URL.WEATHER +
                "?city=" + cityCode +
                "&language=zh-chs&unit=c&aqi=city&alarm=1&key=78928e706123c1a8f1766f062bc8676b";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Environment environment = new Environment();
                        jsonObject = response;
                        try {
                            JSONArray jsonArray = jsonObject.getJSONArray("weather");
                            JSONObject nowWeather = jsonArray.getJSONObject(0).getJSONObject("now");
                            environment.setWeather(nowWeather.getString("text"));
                            environment.setHumidity(nowWeather.getString("humidity"));
                            environment.setTemperature(nowWeather.getString("temperature"));
                            myTitleBarInter.onShowWeather(environment);
                            GLog.d(nowWeather.toString());
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                GLog.d(error.toString());
            }
        });
        mQueue.add(jsonObjectRequest);
    }


}
