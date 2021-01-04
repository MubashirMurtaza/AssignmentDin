package com.example.dindin_miniassign

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.airbnb.mvrx.MavericksState



class DaysViewModel : ViewModel(){
    val daytext = MutableLiveData<String>()

    init {
         daytext.value = "Monday\nDiscount"
    }
    fun changeData(d:String){
        daytext.value = d
    }

}

class ViewPagerFragment : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.viewpager_frag, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        var txtview: TextView = view.findViewById(R.id.texts);
        val daydiscountxt : TextView = view.findViewById(R.id.daydiscountxt);
        val s :String
        val daysViewModel = ViewModelProvider(this).get(DaysViewModel::class.java)

        arguments?.takeIf { it.containsKey("view") }?.apply {

            s = getString("view","noting");
            Log.d("fragmentchk",s);
//            txtview.setText(s);
            if(s.equals("1")){

                daysViewModel.changeData("Monday\nDiscount")
            }else if (s.equals("2")){
                daysViewModel.changeData("Tuesday\nDiscount")
            }else if(s.equals("3")){
                daysViewModel.changeData("Wednesday\nDiscount")
            }

        }

        daysViewModel.daytext.observe(viewLifecycleOwner, Observer {
            daydiscountxt.text = it.toString()
        })


    }
}


