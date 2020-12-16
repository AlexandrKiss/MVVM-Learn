package ua.kiss.mvvm_learn.view.less02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import ua.kiss.mvvm_learn.databinding.ActivityLess02Binding

class TestActivity : AppCompatActivity() {
    private lateinit var viewModel: TestActivityViewModel
    private lateinit var binding: ActivityLess02Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLess02Binding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProviders.of(this)
            .get(TestActivityViewModel::class.java)
        viewModel.textUpdater.observe(this, Observer {
            binding.textView.text = it
        })
        binding.button.setOnClickListener{
            viewModel.updateString()
        }
    }
}