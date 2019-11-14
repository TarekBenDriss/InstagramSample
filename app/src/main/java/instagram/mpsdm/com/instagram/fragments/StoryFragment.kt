package instagram.mpsdm.com.instagram.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.otaliastudios.cameraview.CameraView
import instagram.mpsdm.com.instagram.R

class StoryFragment : Fragment() {




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
        return view
    }


}