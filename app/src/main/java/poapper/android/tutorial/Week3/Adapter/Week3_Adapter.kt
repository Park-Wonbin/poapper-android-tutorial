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
import java.lang.ref.WeakReference

class Week3_Adapter<T>(private var clickHandler: T): RecyclerView.Adapter<Week3_Adapter<T>.ViewHolder>() {

    private lateinit var context: Context
    private var mData: ArrayList<Week3_Post>? = null

    interface clickListener {
        fun goNextPage(data: Week3_Post)
    }

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
        return ViewHolder(view, clickHandler as clickListener)
    }

    inner class ViewHolder(v: View, listener: clickListener): RecyclerView.ViewHolder(v), View.OnClickListener {
        val listenerRef: WeakReference<clickListener> = WeakReference(listener)
        var mCard: LinearLayout = v.findViewById(R.id.cardView_item)
        var mTitle: TextView = v.findViewById(R.id.textView_title)
        var mTime: TextView = v.findViewById(R.id.textView_time)

        init {
            mCard.setOnClickListener(this)
        }

        override fun onClick(p0: View?) {
            listenerRef.get()?.goNextPage(mData!![adapterPosition])
        }
    }

    fun setData(data: ArrayList<Week3_Post>) {
        mData = data
        notifyDataSetChanged()
    }
}