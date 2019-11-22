package instagram.mpsdm.com.instagram.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.OvershootInterpolator
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import instagram.mpsdm.com.instagram.R
import instagram.mpsdm.com.instagram.adapters.MessagesAdapter
import instagram.mpsdm.com.instagram.models.Message


class MessagesFragment : Fragment() {

    val messages: ArrayList<Message> = ArrayList()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view:View = inflater.inflate(R.layout.fragment_messages, container, false)

        val recyclerView: RecyclerView = view.findViewById(R.id.recycler)
        val mLayoutManager = LinearLayoutManager(getContext())

        addMessages()
        //var mSlideInUpAnimator: SlideInUpAnimator
        recyclerView.setLayoutManager(mLayoutManager)
        recyclerView.setHasFixedSize(true)

        recyclerView.setAdapter(MessagesAdapter(messages,context))
/*
        mSlideInUpAnimator = SlideInUpAnimator(OvershootInterpolator(1f))
        mSlideInUpAnimator.setAddDuration(2000)
        mRcvMovies.setItemAnimator(mSlideInUpAnimator)
*/
        return view
    }

    fun addMessages()
    {
       messages.add(Message("Tarek","Message"))
       messages.add(Message("Tarek2","Message"))
       messages.add(Message("Tarek3","Message"))
       messages.add(Message("Tarek4","Message"))
       messages.add(Message("Tarek5","Message"))
       messages.add(Message("Tarek6","Message"))
    }

}
