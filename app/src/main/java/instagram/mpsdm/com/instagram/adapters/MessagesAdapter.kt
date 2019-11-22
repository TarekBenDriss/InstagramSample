package instagram.mpsdm.com.instagram.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import instagram.mpsdm.com.instagram.R
import instagram.mpsdm.com.instagram.models.Message
import kotlinx.android.synthetic.main.messages_item.view.*

class MessagesAdapter(val items : ArrayList<Message>, val context: Context?) : RecyclerView.Adapter<ViewHolder>() {

    // Gets the number of animals in the list
    override fun getItemCount(): Int {
        return items.size
    }

    // Inflates the item views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.messages_item, parent, false))
    }

    // Binds each animal in the ArrayList to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.nom?.text = items.get(position).nom
        holder.message?.text = items.get(position).message
    }
}

class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
    // Holds the TextView that will add each animal to
    val nom = view.nom
    val message = view.message
}