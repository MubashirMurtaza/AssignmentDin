package com.example.dindin_miniassign

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition


class Recycler_Adapter(private val mDataset: List<Product>?, var mcontext: Context?) : RecyclerView.Adapter<Recycler_Adapter.MyViewHolder>() {
    var itemview: View? = null


    class MyViewHolder(v: View?) : RecyclerView.ViewHolder(v!!) {
        // each data item is just a string in this case
        var imgview: ImageView
        var heading_txt: TextView
        var pro_cap: TextView
        var pro_detail: TextView


        init {
            imgview = v!!.findViewById(R.id.imageView2)
            heading_txt = v!!.findViewById(R.id.heading_txt)
            pro_cap = v!!.findViewById(R.id.pro_cap)
            pro_detail = v!!.findViewById(R.id.pro_detail)
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): MyViewHolder {
        itemview = LayoutInflater.from(parent.context)
                .inflate(R.layout.main_recy_holder, parent, false)
        return MyViewHolder(itemview)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        if (mDataset != null || mDataset!!.size > 0) {

            holder.heading_txt.text = mDataset.get(position).headtxtg
            holder.pro_cap.text = mDataset.get(position).proddefineg
            holder.pro_detail.text = mDataset.get(position).prodetails

            Glide.with(mcontext!!)
                .load(mDataset[position].drawable_idg)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .skipMemoryCache(true)
                .into(object  : CustomTarget<Drawable?>(){
                    override fun onLoadCleared(placeholder: Drawable?) {


                    }

                    override fun onResourceReady(
                        resource: Drawable,
                        transition: Transition<in Drawable?>?
                    ) {
                        holder.imgview.background = resource
                    }

                });
        }
    }

    override fun getItemCount(): Int {
        return mDataset?.size ?: 0
    } // Return the size of your dataset (invoked by the layout manager)

}