package com.lp.lecture.api

import com.lp.lecture.mvp.model.bean.Banner
import com.lp.lecture.mvp.model.bean.HttpResult
import io.reactivex.Observable
import retrofit2.http.GET

interface ApiService {
    /**
     * 获取轮播图
     * http://www.wanandroid.com/banner/json
     */
    @GET("banner/json")
    fun getBanners(): Observable<HttpResult<List<Banner>>>
}