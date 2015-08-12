package tk.jinhao.volleyutils.util;

import android.content.Context;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

/**
 * Created by shanks on 15/8/1.
 */
public class VolleyUtil {
    private static RequestQueue mRequestQueue;
    private  static ImageLoader mImageLoader;

    private VolleyUtil() {
    }
//    need an applictionContext
    public static RequestQueue getVolleyRequestQueueInstance(Context context){
        if (null == mImageLoader){
            synchronized (VolleyUtil.class){
                mRequestQueue = Volley.newRequestQueue(context);
            }
        }
        return mRequestQueue;
    }

/*
*
*
* */
    public static <T> void addRequest(RequestQueue requestQueue,Request<T> request ,Object tag){
//        设置 tag
        if (null != tag){
            request.setTag(tag);
        }
//        是否缓存
        request.setShouldCache(false);
//        超时处理
        request.setRetryPolicy(new DefaultRetryPolicy(DefaultRetryPolicy.DEFAULT_TIMEOUT_MS,DefaultRetryPolicy.DEFAULT_MAX_RETRIES,DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
//        添加到队列
        requestQueue.add(request);


    }

    public static<T> void sendJsonObject(Context context, int method,String url){

    }





}
