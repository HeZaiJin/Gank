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

    /**retrofit 结合 rxjava 的api ****-start-**/
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
    /**retrofit 结合 rxjava 的api ****-end-**/

    /**retrofit  的api ****-start-**/
    @POST("toh")
    Call<ResponseListEvent> loadListInofsWithCall(@Query("v") String v, @Query("key") String key, @Query("month") int month, @Query("day") int day);

    /**retrofit  的api ****-end-**/


    /**gank api**/



    /**gank api[end]**/

}
