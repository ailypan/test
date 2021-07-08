package com.lp.lecture.ui.actvity

import android.content.Context
import android.os.Bundle
import android.support.multidex.MultiDex
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.bottomnavigation.LabelVisibilityMode
import com.lp.lecture.R
import com.lp.lecture.ui.fragment.*

class MainActivity : AppCompatActivity() {
    private lateinit var bottomNavigationView: BottomNavigationView
    private var frameLayout: FrameLayout? = null
    private lateinit var mHomeFragment: HomeFragment
    private lateinit var mSquareFragment: SquareFragment
    private lateinit var mWechatFragment: WechatFragment
    private lateinit var mSystemFragment: SystemFragment
    private lateinit var mProjectFragment: ProjectFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottomNavigationView = findViewById(R.id.bottom_navigation)
        frameLayout = findViewById(R.id.frameLayout)
        bottomNavigationView.labelVisibilityMode = LabelVisibilityMode.LABEL_VISIBILITY_LABELED

        mHomeFragment = HomeFragment()
        mSquareFragment = SquareFragment()
        mWechatFragment = WechatFragment()
        mSystemFragment = SystemFragment()
        mProjectFragment = ProjectFragment()
        showFragment(0)

        bottomNavigationView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.action_home -> {
                    showFragment(0)
                    true
                }
                R.id.action_square -> {
                    showFragment(1)
                    true
                }
                R.id.action_wechat -> {
                    showFragment(2)
                    true
                }
                R.id.action_system -> {
                    showFragment(3)
                    true
                }
                R.id.action_project -> {
                    showFragment(4)
                    true
                }
                else -> {
                    true
                }
            }

        }
    }

    /**
     * 隐藏所有的Fragment
     */
    private fun showFragment(index: Int) {
        val transaction = supportFragmentManager.beginTransaction()
        hideAllFragments(transaction)
        when (index) {
            0 -> transaction.replace(R.id.frameLayout, mHomeFragment)
            1 -> transaction.replace(R.id.frameLayout, mSquareFragment)
            2 -> transaction.replace(R.id.frameLayout, mWechatFragment)
            3 -> transaction.replace(R.id.frameLayout, mSystemFragment)
            4 -> transaction.replace(R.id.frameLayout, mProjectFragment)
        }
        transaction.commit()
    }

    private fun hideAllFragments(transaction: FragmentTransaction) {
        mHomeFragment.let {
            transaction.hide(it)
        }
        mSquareFragment.let {
            transaction.hide(it)
        }
        mWechatFragment.let {
            transaction.hide(it)
        }
        mSystemFragment.let {
            transaction.hide(it)
        }
        mProjectFragment.let {
            transaction.hide(it)
        }
    }
}