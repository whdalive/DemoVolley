package com.example.whdalive.demovolley;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.Volley;

//图片Request基类
public class VolleyImage extends AppCompatActivity {
    //请求队列，一个网络交互的Activity内有一个请求队列就足够了
    RequestQueue mQueue;
    private ImageView mImageView;
    private NetworkImageView mNetworkImageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.request_image);
        mImageView = findViewById(R.id.image_view);
        mNetworkImageView = findViewById(R.id.network_image_view);
        mQueue = Volley.newRequestQueue(getApplicationContext());
        //ImageRequest
        findViewById(R.id.request_imagerequest).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                useImageRequest();
            }
        });
        //ImageLoader
        findViewById(R.id.request_imageloader).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                useImageLoader();
            }
        });
        //NetworkImageview
        findViewById(R.id.request_networkimageview).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                useNetworkImageView();
            }
        });
    }
    //ImageRequest
    private void useImageRequest() {
        //url地址，我的简书的头像= =
        String url = "https://upload.jianshu.io/users/upload_avatars/11024422/9960fc0a-0e86-4a1b-ba25-bca296e674c9.jpg?imageMogr2/auto-orient/strip|imageView2/1/w/300/h/300";
        //创建ImageRequest对象
        /**
         * 参数说明：
         * 1. URL
         * 2. 图片请求成功的回调
         * 34. 指定图片最大的宽度和高度，如果网络图片高度或宽度大于这里的最大值，就会对图片进行压缩
         * 如果指定为0则表示不管图片多大都不会压缩图片
         * 5. 指定颜色属性
         * 6. 图片请求失败的回调
         */
        ImageRequest imageRequest = new ImageRequest(url, new Response.Listener<Bitmap>() {
            @Override
            public void onResponse(Bitmap response) {
                mImageView.setImageBitmap(response);
            }
        }, 0, 0, Bitmap.Config.RGB_565, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                mImageView.setImageResource(R.mipmap.ic_launcher);
            }
        });
        mQueue.add(imageRequest);
    }

    private void useImageLoader() {
        //简书头像的url
        String url = "https://upload.jianshu.io/users/upload_avatars/11024422/9960fc0a-0e86-4a1b-ba25-bca296e674c9.jpg?imageMogr2/auto-orient/strip|imageView2/1/w/300/h/300";
        //创建ImageLoader
        /**
         * 参数说明：
         * 1. 请求队列
         * 2. ImageCache，显然想实现一个性能好的缓存，避免不了使用LruChcae
         * 由于现在对LruCache不甚了解，就放上一个空ImageCache
         */
        ImageLoader imageLoader = new ImageLoader(mQueue, new ImageLoader.ImageCache() {
            @Override
            public Bitmap getBitmap(String url) {
                return null;
            }

            @Override
            public void putBitmap(String url, Bitmap bitmap) {

            }
        });
        //创建ImageListener对象
        /**
         * 参数说明：
         * 1. 指定显示图片的ImageView控件
         * 2. 加载过程中显示的图片
         * 3. 加载失败时显示的图片
         */
        ImageLoader.ImageListener listener = ImageLoader.getImageListener(
                mImageView,R.mipmap.load,R.mipmap.failure);
        //加载图片
        imageLoader.get(url,listener);
        /*
        //重载方法，可对大小进行限制
        imageLoader.get(url, listener, 200, 200);
        */
    }

    private void useNetworkImageView() {
        //url
        String url = "https://upload.jianshu.io/users/upload_avatars/11024422/9960fc0a-0e86-4a1b-ba25-bca296e674c9.jpg?imageMogr2/auto-orient/strip|imageView2/1/w/300/h/300";

        //创建ImageLoader，参数说明不在重复
        ImageLoader imageLoader = new ImageLoader(mQueue, new ImageLoader.ImageCache() {
            @Override
            public Bitmap getBitmap(String url) {
                return null;
            }

            @Override
            public void putBitmap(String url, Bitmap bitmap) {

            }
        });
        //下面两个方法同ImageLoader.ImageListener listener = ImageLoader.getImageListener(mImageView,R.mipmap.load,R.mipmap.failure);
        //作用是设置加载过程中和加载失败时显示的图片
        mNetworkImageView.setDefaultImageResId(R.mipmap.load);
        mNetworkImageView.setErrorImageResId(R.mipmap.failure);

        //设置加载的图片地址
        mNetworkImageView.setImageUrl(url,imageLoader);
    }


}

