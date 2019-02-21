package vesitlibrary.pavankumar.camp.VESITLibrary;

/** THIS PROJECT IS COPYRIGHT TO VESIT COLLAGE AND LIBRARY.TEAM AND APP DEVELOPERS ALL RIGHTS ARE RESERVED
 /**
 * Created by Pavankumar on for managing fragments about-dev
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import vesitlibrary.pavankumar.camp.VESITLibrary.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class AboutDevFragment extends Fragment {


    public AboutDevFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_about_dev, container, false);
    }

}
