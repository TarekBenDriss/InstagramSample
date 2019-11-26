package instagram.mpsdm.com.instagram.fragments

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import instagram.mpsdm.com.instagram.FragmentDelegate
import instagram.mpsdm.com.instagram.adapters.PostsAdapter
import instagram.mpsdm.com.instagram.models.Post
import androidx.constraintlayout.widget.ConstraintLayout
import instagram.mpsdm.com.instagram.utils.HidingScrollListener
import instagram.mpsdm.com.instagram.R


class HomeFragment : Fragment() {

    var delegate: FragmentDelegate? = null
    val posts: ArrayList<Post> = ArrayList()

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val view:View = inflater.inflate(R.layout.fragment_home, container, false)

        val messages:ImageView = view.findViewById(R.id.messages)
        val story:ImageView = view.findViewById(R.id.storyImg)

        story.setOnClickListener {
            delegate?.homeFragmentDidClickStoryButton(this)
        }

        messages.setOnClickListener{
            delegate?.homeFragmentDidClickMessagesButton(this)
        }

        addPosts()

        var recyclerPosts:RecyclerView = view.findViewById(R.id.postsRecycler)
        val mLayoutManager = LinearLayoutManager(getContext())

        recyclerPosts.setLayoutManager(mLayoutManager)
        recyclerPosts.setHasFixedSize(true)

        recyclerPosts.setAdapter(PostsAdapter(posts,context))

        var stories:ConstraintLayout = view.findViewById(R.id.storyLayout)



        recyclerPosts.addOnScrollListener(object : HidingScrollListener() {

            override fun hide() {
                //stories.animate().translationY(stories.height.toFloat()).setInterpolator(AccelerateInterpolator(2f)).start()
                  //  stories.visibility=View.INVISIBLE
            }

            override fun show() {
                //stories.animate().translationY(0.toFloat()).setInterpolator(DecelerateInterpolator(2f)).start()
             //   stories.visibility=View.VISIBLE
            }
        })
/*
        var intent:Intent = Intent(activity,LoginActivity::class.java)
        intent.setAction(Intent.ACTION_VIEW)
        startActivity(intent)
*/
        return view
    }


    fun addPosts()
    {
        posts.add(Post("a9wel_moudablja",R.drawable.paris,"22 j'aimes","Ici c'est paris","Il y'a 2 heures",""))
        posts.add(Post("van_dric",R.drawable.paris,"72 j'aimes","XXX Amsterdam XXX","Il y'a 2 heures","Voir les 5 commentaires"))
        posts.add(Post("tarajiofficiel",R.drawable.paris,"102 j'aimes","Taraji Ya Dawla","Il y'a 2 heures",""))
        posts.add(Post("a9wel_moudablja",R.drawable.paris,"92 j'aimes","Ici c'est Tunis","Il y'a 2 heures","Voir les 22 commentaires"))
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is FragmentDelegate) {
            delegate = context
        }
    }
}