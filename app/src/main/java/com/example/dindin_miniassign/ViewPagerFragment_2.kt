package com.example.dindin_miniassign

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ViewPagerFragment_2 : Fragment  (){


    var mlist: ArrayList<Product> = ArrayList()

    lateinit var recy_pro : RecyclerView
    lateinit var recyclerAdapter : Recycler_Adapter
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.viewpager_frag_2, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recy_pro = view.findViewById(R.id.recy_pro);
        mlist.add(Product(R.drawable.testimg,"California","This is test text about product"
                ,"01/2020/03 8:03"))
        mlist.add(Product(R.drawable.testimg,"California","This is test text about product"
                ,"01/2020/03 8:03"))
        mlist.add(Product(R.drawable.testimg,"California","This is test text about product"
                ,"01/2020/03 8:03"))
        mlist.add(Product(R.drawable.testimg,"California","This is test text about product"
                ,"01/2020/03 8:03"))


        recyclerAdapter = Recycler_Adapter(mlist, context)

        val layoutManager1 = LinearLayoutManager(
            context,
            LinearLayoutManager.VERTICAL, false
        )
        recy_pro.setLayoutManager(layoutManager1)
        recy_pro.setAdapter(recyclerAdapter)


        recy_pro.adapter = recyclerAdapter


    }



}


