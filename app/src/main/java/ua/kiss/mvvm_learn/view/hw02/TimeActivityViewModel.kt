package ua.kiss.mvvm_learn.view.hw02

import android.os.Handler
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.text.DateFormat
import java.util.*

class TimeActivityViewModel: ViewModel() {
    val timeUpdater: MutableLiveData<String> by lazy { MutableLiveData<String>() }
    val dateUpdater: MutableLiveData<String> by lazy { MutableLiveData<String>() }

    fun updateTime() {
        val handler = Handler()
        val runnableCode: Runnable = object : Runnable {
            override fun run() {
                val calendar = Calendar.getInstance(Locale.getDefault())
                val hour = calendar[Calendar.HOUR_OF_DAY]
                val minute = calendar[Calendar.MINUTE]
                val second = calendar[Calendar.SECOND]

//                postValue() не требуеться, так как работаем в основном потоке
//                timeUpdater.postValue("${setZero(hour)}:${setZero(minute)}:${setZero(second)}")

                timeUpdater.value = "${setZero(hour)}:${setZero(minute)}:${setZero(second)}"
                if (hour == minute && hour == second) updateDate()

                handler.postDelayed(this, 1000)
            }
        }
        handler.post(runnableCode); //выполнение Runnable-задачи в UIThread - безопасно для UI
    }

    fun updateDate() {
        val date = DateFormat.getDateInstance(DateFormat.LONG)
        dateUpdater.postValue(date.format(Calendar.getInstance().time))
    }

    private fun setZero(number: Int): String {
        if (number<10) return "0$number"
        return "$number"
    }
}