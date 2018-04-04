package com.example.whdalive.demovolley.Custom;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.TextView;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.example.whdalive.demovolley.R;
import org.xmlpull.v1.XmlPullParser;
import java.util.List;

public class VolleyCustom extends AppCompatActivity {
    private TextView mTextView;
    private RequestQueue mQueue;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reqyest_custom);
        mTextView = findViewById(R.id.text_view);
        mTextView.setMovementMethod(ScrollingMovementMethod.getInstance());
        findViewById(R.id.request_xml).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                useXMLRequest();
            }
        });
        findViewById(R.id.request_gson).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                useGSONRequest();
            }
        });

        mQueue = Volley.newRequestQueue(this);
    }

    private void useXMLRequest() {
        String url = "https://www.sojson.com/open/api/weather/xml.shtml?city=%E5%8C%97%E4%BA%AC";
        XMLRequest xmlRequest = new XMLRequest(url, new Response.Listener<XmlPullParser>() {
            @Override
            public void onResponse(XmlPullParser response) {
                try {
                    int eventType = response.getEventType();
                    while (eventType != XmlPullParser.END_DOCUMENT){
                        switch (eventType){
                            case XmlPullParser.START_TAG:
                                String name = response.getName();
                                if ("city".equals(name)){
                                    mTextView.setText(response.nextText());                                }
                                break;
                        }
                        eventType = response.next();
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                mTextView.setText(error.getMessage());
            }
        });
        mQueue.add(xmlRequest);
    }

    private void useGSONRequest() {
        String url = "https://www.sojson.com/open/api/weather/json.shtml?city=北京";

        GsonRequest<Weather> gsonRequest = new GsonRequest<Weather>(url, Weather.class,
                new Response.Listener<Weather>() {
                    @Override
                    public void onResponse(Weather response) {
                        Weather.DataBean dataBean = response.getData();
                        List<Weather.DataBean.ForecastBean> forecastList = dataBean.getForecast();
                        Weather.DataBean.YesterdayBean yesterday = dataBean.getYesterday();

                        StringBuilder builder = new StringBuilder();
                        builder.append("日期："+ response.getDate() + "\n");
                        builder.append("城市："+ response.getCity() + "\n" + "\n");

                        builder.append("当前天气" + "\n");
                        builder.append("湿度: "+dataBean.getShidu()+"\n");
                        builder.append("PM25: "+dataBean.getPm25()+"\n");
                        builder.append("PM10: "+dataBean.getPm10()+"\n");
                        builder.append("空气质量: "+dataBean.getQuality()+"\n");
                        builder.append("温度: "+dataBean.getWendu()+"\n");
                        builder.append("感冒指数: "+dataBean.getGanmao()+"\n"+ "\n");

                        builder.append("昨日天气" + "\n");
                        builder.append("日期: "+yesterday.getDate()+"\n");
                        builder.append("日出时间: "+yesterday.getSunrise()+"\n");
                        builder.append("最高温度: "+yesterday.getHigh()+"\n");
                        builder.append("最低温度: "+yesterday.getLow()+"\n");
                        builder.append("日落时间: "+yesterday.getSunset()+"\n");
                        builder.append("AQI: "+yesterday.getAqi()+"\n");
                        builder.append("风向: "+yesterday.getFx()+"\n");
                        builder.append("风力: "+yesterday.getFl()+"\n");
                        builder.append("天气: "+yesterday.getType()+"\n");
                        builder.append("注意: "+yesterday.getNotice()+"\n"+ "\n");
                       for (Weather.DataBean.ForecastBean forecast : forecastList){
                            builder.append("未来天气：" + "\n");
                           builder.append("日期: "+forecast.getDate()+"\n");
                           builder.append("日出时间: "+forecast.getSunrise()+"\n");
                           builder.append("最高温度: "+forecast.getHigh()+"\n");
                           builder.append("最低温度: "+forecast.getLow()+"\n");
                           builder.append("日落时间: "+forecast.getSunset()+"\n");
                           builder.append("AQI: "+forecast.getAqi()+"\n");
                           builder.append("风向: "+forecast.getFx()+"\n");
                           builder.append("风力: "+forecast.getFl()+"\n");
                           builder.append("天气: "+forecast.getType()+"\n");
                           builder.append("注意: "+forecast.getNotice()+"\n"+ "\n");
                        }
                        mTextView.setText(builder);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                mTextView.setText(error.getMessage());
            }
        });
        mQueue.add(gsonRequest);
    }

}
