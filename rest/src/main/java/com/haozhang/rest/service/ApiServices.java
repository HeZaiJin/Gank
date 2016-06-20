package com.haozhang.rest.service;


import com.haozhang.rest.modle.ResponseListEvent;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 *ApiServices
 */
public interface ApiServices {

    /**历史上的今天API START*/

    /***
     * 事件列表
     * params:
     *      key:
     *      v:1.0
     *      month:
     *      day:
     * @return
     */
    @POST("toh")
    Observable<ResponseListEvent> loadListInofsWithRx(@Query("v") String v, @Query("key") String key, @Query("month") int month, @Query("day") int day);


    @POST("toh")
    Call<ResponseListEvent> loadListInofsWithCall(@Query("v") String v, @Query("key") String key, @Query("month") int month, @Query("day") int day);

    /**历史上的今天API END*/

}
