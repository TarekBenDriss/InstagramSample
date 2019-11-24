package instagram.mpsdm.com.instagram.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import instagram.mpsdm.com.instagram.FragmentDelegate
import instagram.mpsdm.com.instagram.R

class HomeFragment : Fragment() {

    var delegate: FragmentDelegate? = null


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
        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is FragmentDelegate) {
            delegate = context
        }
    }
}