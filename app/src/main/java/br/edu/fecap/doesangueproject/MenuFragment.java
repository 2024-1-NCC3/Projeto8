package br.edu.fecap.doesangueproject;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class MenuFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public MenuFragment() {
        // Required empty public constructor
    }

    public static MenuFragment newInstance(String param1, String param2) {
        MenuFragment fragment = new MenuFragment();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_menu, container, false);

        ImageView menu_card1 = rootView.findViewById(R.id.menu_card1);
        ImageView menu_card2 = rootView.findViewById(R.id.menu_card2);
        ImageView menu_card3 = rootView.findViewById(R.id.menu_card3);
        ImageView menu_card4 = rootView.findViewById(R.id.menu_card4);
        ImageView menu_card5 = rootView.findViewById(R.id.menu_card5);

        menu_card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Activity1.class);
                startActivity(intent);
            }
        });

        menu_card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Activity2.class);
                startActivity(intent);
            }
        });

        menu_card3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Activity3.class);
                startActivity(intent);
            }
        });

        menu_card4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Activity4.class);
                startActivity(intent);
            }
        });

        menu_card5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Activity5.class);
                startActivity(intent);
            }
        });

        ImageView buttonBack = rootView.findViewById(R.id.button_back);

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Aqui você pode iniciar a nova atividade
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
            }

        });

        return rootView;
    }

}