package com.reyzeny.zhatsapp.Home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.PagerAdapter
import com.reyzeny.zhatsapp.Home.Chats.ChatFragment
import com.reyzeny.zhatsapp.R
import kotlinx.android.synthetic.main.home_activity.*

class HomeActivity: AppCompatActivity() {
    lateinit var home_pager_adapter: HomePagerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_activity)
        setSupportActionBar(home_toolbar)
        setupUI()
    }

    private fun setupUI() {
        home_pager_adapter = HomePagerAdapter(supportFragmentManager).apply {
            addFragment(CameraFragment(), "")
            addFragment(ChatFragment(), getString(R.string.chats))
            addFragment(StatusFragment(), getString(R.string.status))
            addFragment(CallFragment(), getString(R.string.calls))
        }
        home_viewpager.adapter = home_pager_adapter
        home_viewpager.currentItem = 1
        home_tabs.setupWithViewPager(home_viewpager)
        home_tabs.getTabAt(0)?.setIcon(R.drawable.camera_tab_icon)


    }

    fun getCurrentFragmentTitle(): CharSequence? {
        return home_pager_adapter.getPageTitle(home_tabs.selectedTabPosition)
    }


}