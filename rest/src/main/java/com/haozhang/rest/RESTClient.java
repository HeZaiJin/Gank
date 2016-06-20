package com.haozhang.rest;


import com.haozhang.rest.config.Configs;
import com.haozhang.rest.modle.RequestListEventParams;
import com.haozhang.rest.modle.ResponseListEvent;
import com.haozhang.rest.service.ApiServices;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

/**
 * 网络请求
 */
public class RESTClient {

    private static final String TAG = "RESTClient";

    private static final String DEFAULT_URL= Configs.API;

    /**
     * 适用rxjava的retrofit
     */
    private static final Retrofit sRetrofit_rx = new Retrofit.Builder()
            .baseUrl(DEFAULT_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .build();

    private static final Retrofit sRetrofit = new Retrofit.Builder()
            .baseUrl(DEFAULT_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    private static final ApiServices sHttpService = sRetrofit.create(ApiServices.class);


    private static final ApiServices sHttpService_rx = sRetrofit_rx.create(ApiServices.class);



    /**
     * 获取listevent 使用retrofit的callback模式
     * * @param params
     * @param callback
     */
    public static void qureyListEvent(RequestListEventParams params, Callback<ResponseListEvent> callback){
        Call<ResponseListEvent> call = sHttpService.loadListInofsWithCall(params.v, params.key, params.month, params.day);
        call.enqueue(callback);
    }

    /**
     * 获取ListEvent 使用retrofit 的 rxjava模式
     * @param params
     * @return
     */
    public static Observable<ResponseListEvent> queryListEvent(final RequestListEventParams params){
        return sHttpService_rx.loadListInofsWithRx(params.v,params.key,params.month,params.day);
    }

}
