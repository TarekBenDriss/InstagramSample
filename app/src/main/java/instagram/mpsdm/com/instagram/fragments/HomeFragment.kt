package instagram.mpsdm.com.instagram.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import instagram.mpsdm.com.instagram.R

class HomeFragment : Fragment() {


    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val view:View = inflater.inflate(R.layout.fragment_home, container, false)

        val messages:ImageView = view.findViewById(R.id.messages)
        messages.setOnClickListener{

        }
        return view
    }
}