package com.example.whdalive.demovolley;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;


public class VolleySimple extends AppCompatActivity {
    //请求队列，一个网络交互的Activity内有一个请求队列就足够了
    RequestQueue mQueue;

    private TextView mTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.request_simple);

        //创建请求队列的对象，传入当前Activity作为context即可
        mQueue =  Volley.newRequestQueue(this);

        mTextView = findViewById(R.id.simple_data);
        //TextView加入滑动条
        mTextView.setMovementMethod(ScrollingMovementMethod.getInstance());
        findViewById(R.id.request_string).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendStringRequest();
            }
        });
        findViewById(R.id.request_json).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendJSONRequest();
            }
        });
    }
    //StringRequest
    private void sendStringRequest(){
        //当然首先尝试一下访问百度了
        String url = "https://www.baidu.com";

        /**
         * 创建一个StringRequest对象
         * 参数说明：
         * 1.请求方法
         * 2.目标服务器的URL地址
         * 3.服务器响应成功的回调
         * 1.服务器响应失败的回调
        **/
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                mTextView.setText("The StringRequest's response is "+ response.substring(0,500));
            }
        }, new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {
                mTextView.setText("The StringRequest's response is: That didn't work!" );
            }
        });
        //将StringRequest放入请求队列中即可
        mQueue.add(stringRequest);
        /*以下为POST方式，需要传递数据时的处理
        StringRequest stringRequestPost = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> map = new HashMap<String,String>();
                map.put("param1","value1");
                map.put("param2","value2");
                return map;
            }
        }
        mQueue.add(stringRequestPost);
        */

    }
    //JSONRequest
    private void sendJSONRequest(){
        //网上找到的一个天气的API，暂时可用，稳定性待测= =
        String url = "https://www.sojson.com/open/api/weather/json.shtml?city=北京";
        //JsonObjectRequest和JsonArrayRequest是JsonRequest(抽象类)的子类
        //前者请求JSON数据，后者请求JSON数组
        /**
         * 参数说明：
         * 1：请求方法
         * 2：服务器的URL地址
         * 3：POST方式传递的JSON数据，如果为空则表示POST方式没有要提交的参数
         * 4：接收响应成功时返回的JSON数据的监听器
         * 4：接收响应失败时返回的错误信息的监听器
         */
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                mTextView.setText("The JSONRequest's response is " + response.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                mTextView.setText("The JSONRequest's response is: That didn't work!" );
            }
        });
        //将请求放入请求队列
        mQueue.add(jsonObjectRequest);
    }

}
