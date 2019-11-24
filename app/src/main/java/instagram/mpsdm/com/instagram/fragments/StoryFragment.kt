package instagram.mpsdm.com.instagram.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.otaliastudios.cameraview.CameraView
import com.otaliastudios.cameraview.controls.Facing
import instagram.mpsdm.com.instagram.FragmentDelegate
import instagram.mpsdm.com.instagram.MainActivity
import instagram.mpsdm.com.instagram.R

class StoryFragment : Fragment() {

    var delegate: FragmentDelegate? = null



    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View?
    {
        val view:View =inflater.inflate(R.layout.fragment_story, container, false)
        val camera:CameraView = view.findViewById(R.id.camera)
        //camera.setLifecycleOwner(this)
        camera.setLifecycleOwner(getViewLifecycleOwner());

        //camera.start
        //camera.start()

        val rotate:ImageView = view.findViewById(R.id.rotate)
        val cancel:ImageView = view.findViewById(R.id.cancel)

        cancel.setOnClickListener {
            delegate?.storyFragmentDidClickCancelButton(this)
        }

        rotate.setOnClickListener{
            if(camera.facing==Facing.BACK)
                camera.facing=Facing.FRONT
            else
                camera.facing=Facing.BACK
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
