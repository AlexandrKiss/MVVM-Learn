package ua.kiss.mvvm_learn.view.hw02

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import ua.kiss.mvvm_learn.databinding.ActivityTimeBinding

class TimeActivity: AppCompatActivity() {
    private lateinit var viewModel: TimeActivityViewModel
    private lateinit var binding: ActivityTimeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTimeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProviders.of(this).get(TimeActivityViewModel::class.java)

        viewModel.timeUpdater.observe(this, {
            binding.timeTextView.text = it
        })
        viewModel.dateUpdater.observe(this, {
            binding.dateTextView.text = it
        })

        viewModel.updateTime()
        viewModel.updateDate()
    }
}