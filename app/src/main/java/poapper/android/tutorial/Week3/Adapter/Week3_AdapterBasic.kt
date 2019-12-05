package poapper.android.tutorial.Week3.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import poapper.android.tutorial.R
import poapper.android.tutorial.Week3.Model.Week3_Post

class Week3_AdapterBasic: RecyclerView.Adapter<Week3_AdapterBasic.ViewHolder>() {

    private lateinit var context: Context
    private var mData: ArrayList<Week3_Post>? = null

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val thisItem = mData!![position]

        holder.mTitle.text = thisItem.title
        holder.mTime.text = thisItem.time
    }

    override fun getItemCount(): Int {
        return if (mData == null) 0 else mData!!.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.week3_item, parent, false)
        return ViewHolder(view)
    }

    inner class ViewHolder(v: View): RecyclerView.ViewHolder(v) {
        var mCard: LinearLayout = v.findViewById(R.id.cardView_item)
        var mTitle: TextView = v.findViewById(R.id.textView_title)
        var mTime: TextView = v.findViewById(R.id.textView_time)
    }

    fun setData(data: ArrayList<Week3_Post>) {
        mData = data
        notifyDataSetChanged()
    }
}