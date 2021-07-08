package com.lp.lecture.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.lp.lecture.R
import com.lp.lecture.http.RetrofitHelper
import com.lp.lecture.mvp.model.bean.Banner
import com.lp.lecture.mvp.model.bean.HttpResult
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class HomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, null)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getData()
    }

    private fun getData() {
        RetrofitHelper.service.getBanners().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object
                : Observer<HttpResult<List<Banner>>> {
                override fun onSubscribe(d: Disposable) {
                    Log.e("tag", "onSubscribe")
                }

                override fun onNext(t: HttpResult<List<Banner>>) {
                    Log.e("tag", "onNext")
                }

                override fun onError(e: Throwable) {
                    Log.e("tag", "onError"+e.message)
                }

                override fun onComplete() {
                    Log.e("tag", "onComplete")
                }

            })
    }
}