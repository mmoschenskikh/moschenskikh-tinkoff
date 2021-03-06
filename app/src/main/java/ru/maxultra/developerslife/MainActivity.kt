package ru.maxultra.developerslife

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.databinding.DataBindingUtil
import com.google.android.material.tabs.TabLayoutMediator
import ru.maxultra.developerslife.databinding.ActivityMainBinding
import ru.maxultra.developerslife.ui.tablayout.PagerAdapter
import ru.maxultra.developerslife.util.getTabText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        val binding =
            DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        setSupportActionBar(binding.toolbar)
        supportActionBar?.title = null

        binding.viewPager.adapter = PagerAdapter(supportFragmentManager, lifecycle)
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = getTabText(position, resources)
        }.attach()
    }
}
