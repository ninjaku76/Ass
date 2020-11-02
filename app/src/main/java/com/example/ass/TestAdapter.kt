package com.example.ass
//ใช้ Adapter ในการแปลงข้อมูล JSON มาเป็น Objects

import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.util.Base64
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.test_list.view.*

class TestAdapter (val postList: List<sealImage>, val context: Context?) :
    RecyclerView.Adapter<TestAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.test_list, parent, false))
    }
    override fun getItemCount(): Int {
        return postList.size
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        holder.itemView.txtmessageCode.text = postList[position].messageCode
//        holder.itemView.txtmobileNo.text = postList[position].mobileNo
//        holder.itemView.txtrouteDate.text = postList[position].routeDate
//        holder.itemView.txttruckLicense.text = postList[position].truckLicense
//        holder.itemView.txtprovince.text = postList[position].province
//         //holder.itemView.txtsealImageList.text = postList1[position].sealImageSeq
//
//        Picasso.get().load(postList[position].thumbnail)
//            .error(R.mipmap.ic_launcher)
//            .placeholder(R.mipmap.ic_launcher)
//            .into(holder.itemView.imageView);

        Glide.with(holder.itemView.imageView)
            .load(fromBase64ToBitmap(holder.itemView.context, postList[position].sealImage ))
            .into(holder.itemView.imageView)
    }


    private fun fromBase64ToBitmap(context: Context, base64string: String?): BitmapDrawable {
        val decodedString = Base64.decode(base64string, Base64.DEFAULT)
        val bitmap = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.size)
        return BitmapDrawable(context.resources, bitmap)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view)
}