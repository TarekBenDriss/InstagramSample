package instagram.mpsdm.com.instagram.adapters

import android.content.Context
import android.opengl.Visibility
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import instagram.mpsdm.com.instagram.R
import instagram.mpsdm.com.instagram.models.Post
import kotlinx.android.synthetic.main.messages_item.view.*
import kotlinx.android.synthetic.main.messages_item.view.nom
import kotlinx.android.synthetic.main.posts_item.view.*


class PostsAdapter(val items : ArrayList<Post>, val context: Context?) : RecyclerView.Adapter<PostsViewHolder>() {

    // Gets the number of animals in the list
    override fun getItemCount(): Int {
        return items.size
    }

    // Inflates the item views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostsViewHolder {
        return PostsViewHolder(LayoutInflater.from(context).inflate(R.layout.posts_item, parent, false))
    }

    // Binds each animal in the ArrayList to a view
    override fun onBindViewHolder(holder: PostsViewHolder, position: Int) {
        holder.nom?.text = items.get(position).profile
        holder.media?.setImageDrawable(context?.getDrawable(items.get(position).media))
        //holder.media?.setImageDrawable(context?.getDrawable(items.get(position).media))
        holder.description?.text = items.get(position).description
        holder.nom2?.text = items.get(position).profile
        holder.likes?.text = items.get(position).likes
        holder.time?.text = items.get(position).time
        if(items.get(position).comments.equals(""))
        {
            holder.comments.visibility = View.INVISIBLE
            holder.commentsSection.visibility = View.VISIBLE
        }
        else
        {
            holder.comments.visibility = View.VISIBLE
            holder.comments.text = items.get(position).comments
            holder.commentsSection.visibility = View.INVISIBLE
        }
        //= items.get(position).message
    }
}

class PostsViewHolder (view: View) : RecyclerView.ViewHolder(view) {
    // Holds the TextView that will add each animal to
    val nom = view.nom
    val nom2 = view.nom2
    val media = view.postContent
    val likes = view.likes
    val description = view.description
    val comments = view.comments
    val commentsSection = view.commentSection
    val time = view.passedTime

}