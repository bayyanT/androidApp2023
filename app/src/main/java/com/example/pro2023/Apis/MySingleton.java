package com.example.pro2023.Apis;

import android.app.DownloadManager;
import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class MySingleton {
    private  static  MySingleton instance;
    private RequestQueue requestQueue;

    private static Context con;

    private  MySingleton (Context context){
        con=context;
        requestQueue=getRequestQueue();
    }

    public static synchronized  MySingleton getInstance(Context con){
        if(instance==null){
            instance=new MySingleton(con);
        }
        return  instance;
    }
    private RequestQueue getRequestQueue() {
         if(requestQueue==null){
             requestQueue= Volley.newRequestQueue(con.getApplicationContext());
         }
        return requestQueue  ;
    }

    public  <T>void addToRequestQueue(Request<T> req){
        getRequestQueue().add(req);

    }

}
