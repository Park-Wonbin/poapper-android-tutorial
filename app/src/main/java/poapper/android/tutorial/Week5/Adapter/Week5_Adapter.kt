package poapper.android.tutorial.Week5.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import poapper.android.tutorial.R
import poapper.android.tutorial.Week3.Model.Week5_Item

class Week5_Adapter: RecyclerView.Adapter<Week5_Adapter.ViewHolder>() {

    private lateinit var context: Context
    private var mData: ArrayList<Week5_Item>? = null

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val thisItem = mData!![position]

        holder.mTitle.text = thisItem.title
        holder.mContent.text = thisItem.description

        Glide
            .with(context)
            .load(thisItem.enclosures?.get(0)?.url)
            .centerCrop()
            .placeholder(R.drawable.o9)
            .into(holder.mImage)
    }

    override fun getItemCount(): Int {
        return if (mData == null) 0 else mData!!.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.week5_item, parent, false)
        return ViewHolder(view)
    }

    inner class ViewHolder(v: View): RecyclerView.ViewHolder(v) {
        var mCard: LinearLayout = v.findViewById(R.id.cardView_item)
        var mTitle: TextView = v.findViewById(R.id.textView_title)
        var mContent: TextView = v.findViewById(R.id.textView_content)
        var mImage: ImageView = v.findViewById(R.id.imageView)
    }

    fun setData(data: ArrayList<Week5_Item>) {
        mData = data
        notifyDataSetChanged()
    }
}