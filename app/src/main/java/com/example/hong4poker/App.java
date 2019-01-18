package com.example.hong4poker;

import android.app.Application;
import android.content.Intent;
import android.util.Log;

import com.example.hong4poker.network.ApiFileConfiguration;
import com.example.hong4poker.network.POJO.Configs;
import com.example.hong4poker.network.Service;

import java.io.IOException;

import io.reactivex.Scheduler;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;
import retrofit2.Response;


public class App extends Application {

    private static String ETag = "ErrorPokerAppClass";

    @Override
    public void onCreate() {
        super.onCreate();

        Service.createService(ApiFileConfiguration.class)
                .downloadConfigFile()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<Configs>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(Configs responseBody) {
                        parseConfigString(responseBody);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(ETag, e.getMessage());
                    }
                });
    }


    private void parseConfigString(Configs responseBody) {
      /*  String string = null;
        try {
            //responseBody.source().
            //string = responseBody.body().string();
            //responseBody.source()
        } catch (IOException e) {
            e.printStackTrace();
        }*/


    }

    private void runBrowser() {
        Intent intent = new Intent(context, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}
