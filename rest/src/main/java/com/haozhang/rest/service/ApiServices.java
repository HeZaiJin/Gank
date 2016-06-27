package com.haozhang.rest.service;


import com.haozhang.rest.modle.BaseData;
import com.haozhang.rest.modle.ResponseListEvent;
import com.haozhang.rest.modle.SearchItemDatas;
import com.haozhang.rest.modle.WelfareItemDatas;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
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

    /**
     * 搜索 API
     http://gank.io/api/search/query/listview/category/Android/count/10/page/1
     注：
     category 后面可接受参数 all | Android | iOS | 休息视频 | 福利 | 拓展资源 | 前端 | 瞎推荐 | App
     count 最大 50
     2016-5-11 日更新:

     获取某几日干货网站数据:

     http://gank.io/api/history/content/2/1

     注： 2 代表 2 个数据，1 代表：取第一页数据
     获取特定日期网站数据:

     http://gank.io/api/history/content/day/2016/05/11

     2016-2-28 日更新:

     获取发过干货日期接口:

     http://gank.io/api/day/history 方式 GET

     2016-2-27 日更新:

     支持提交干货到审核区:

     https://gank.io/api/add2gank 方式: POST

     请勿滥用此接口,不然我还得加身份校验代码,很麻烦的!!!
     提交表单格式如下:

     字段	描述	备注
     url	想要提交的网页地址
     desc	对干货内容的描述	单独的文字描述
     who	提交者 ID	干货提交者的网络 ID
     type	干货类型	可选参数: Android | iOS | 休息视频 | 福利 | 拓展资源 | 前端 | 瞎推荐 | App
     debug	当前提交为测试数据	如果想要测试数据是否合法, 请设置 debug 为 true! 可选参数: true | false
     该 Api 玩儿法推荐:

     直接在你的博客发表博文处嵌入该代码, 感觉不错的博文可以自动提交过来
     写个 Chrome | Firefox | Safari 插件, 让更多人来分享干货, 妹子图和休息视频
     分类数据: http://gank.io/api/data/数据类型/请求个数/第几页

     数据类型： 福利 | Android | iOS | 休息视频 | 拓展资源 | 前端 | all
     请求个数： 数字，大于0
     第几页：数字，大于0
     例：
     http://gank.io/api/data/Android/10/1
     http://gank.io/api/data/福利/10/1
     http://gank.io/api/data/iOS/20/2
     http://gank.io/api/data/all/20/2
     每日数据： http://gank.io/api/day/年/月/日

     例：
     http://gank.io/api/day/2015/08/06
     随机数据：http://gank.io/api/random/data/分类/个数

     数据类型：福利 | Android | iOS | 休息视频 | 拓展资源 | 前端
     个数： 数字，大于0
     例：
     http://gank.io/api/random/data/Android/20
     *
     *
     * **/
    // base url : http://gank.io/api/

    // http://gank.io/api/search/query/listview/category/Android/count/10/page/1
    @GET("search/query/listview/category/{type}/count/10/page/{index}")
    Observable<BaseData<SearchItemDatas>> loadSearchDatas(@Path("type") String type, @Path("index") String index);

    @GET("search/query/listview/category/{type}/count/10/page/{index}")
    Observable<BaseData<WelfareItemDatas>> loadWelfareDatas(@Path("type") String type, @Path("index") String index);

    /**gank api[end]**/

}
