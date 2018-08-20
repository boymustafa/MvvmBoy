package com.boymustafa.mvvmboy;

import android.app.Application;
import android.content.Context;

import com.boymustafa.mvvmboy.network.ApiFactory;
import com.boymustafa.mvvmboy.network.CharService;

import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

public class AppController extends Application {

    private CharService charService;
    private Scheduler scheduler;

    private static AppController get(Context context){
        return (AppController) context.getApplicationContext();
    }

    public static AppController create(Context context){
        return AppController.get(context);
    }

    public CharService getCharService() {
        if (charService == null){
            charService = ApiFactory.create();
        }
        return charService;
    }

    public Scheduler subscriceScheduler(){
        if (scheduler == null){
            scheduler = Schedulers.io();
        }

        return scheduler;
    }
}
