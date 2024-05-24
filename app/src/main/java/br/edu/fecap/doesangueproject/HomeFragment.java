package br.edu.fecap.doesangueproject;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.interfaces.ItemClickListener;
import com.denzcoskun.imageslider.models.SlideModel;
import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        // Initialize ImageSlider and set images
        ImageSlider imageSlider = rootView.findViewById(R.id.imagemSlide);
        ArrayList<SlideModel> slideModels = new ArrayList<>();
        slideModels.add(new SlideModel(R.drawable.autoslide1, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.autoslide2, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.autoslide3, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.autoslide4, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.autoslide5, ScaleTypes.FIT));
        imageSlider.setImageList(slideModels, ScaleTypes.FIT);

        // Set click listener for ImageSlider
        imageSlider.setItemClickListener(new ItemClickListener() {
            @Override
            public void doubleClick(int i) {
                // Handle double click event if needed
            }

            @Override
            public void onItemSelected(int position) {
                // Determine the action based on the position of the clicked image
                switch (position) {
                    case 0:
                        startActivity(new Intent(getActivity(), Activity1.class));
                        break;
                    case 1:
                        startActivity(new Intent(getActivity(), Activity2.class));
                        break;
                    case 2:
                        startActivity(new Intent(getActivity(), Activity3.class));
                        break;
                    case 3:
                        startActivity(new Intent(getActivity(), Activity4.class));
                        break;
                    case 4:
                        startActivity(new Intent(getActivity(), Activity5.class));
                        break;
                    default:
                        break;
                }
            }
        });

        // Configurar o clique na ImageView para abrir o Drawer
        ImageView userIcon = rootView.findViewById(R.id.userIcon);
        userIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Chamar o método openDrawer() da MainActivity
                if (getActivity() instanceof MainActivity) {
                    ((MainActivity) getActivity()).openDrawer();
                }
            }
        });

        return rootView;
    }
}