package br.edu.fecap.doesangueproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class BuscarFragment extends Fragment {

    private TextView text1, text2, text3, text4, text5, text6;
    private ImageView button1, button2, button3, button4, button5, button6;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public BuscarFragment() {
        // Required empty public constructor
    }

    public static BuscarFragment newInstance(String param1, String param2) {
        BuscarFragment fragment = new BuscarFragment();
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
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_buscar, container, false);

        text1 = view.findViewById(R.id.text1);
        text2 = view.findViewById(R.id.text2);
        text3 = view.findViewById(R.id.text3);
        text4 = view.findViewById(R.id.text4);
        text5 = view.findViewById(R.id.text5);
        text6 = view.findViewById(R.id.text6);

        button1 = view.findViewById(R.id.button1);
        button2 = view.findViewById(R.id.button2);
        button3 = view.findViewById(R.id.button3);
        button4 = view.findViewById(R.id.button4);
        button5 = view.findViewById(R.id.button5);
        button6 = view.findViewById(R.id.button6);

        setupButton(button1, text1, R.drawable.ic_arrow_up, R.drawable.ic_arrow_down);
        setupButton(button2, text2, R.drawable.ic_arrow_up, R.drawable.ic_arrow_down);
        setupButton(button3, text3, R.drawable.ic_arrow_up, R.drawable.ic_arrow_down);
        setupButton(button4, text4, R.drawable.ic_arrow_up, R.drawable.ic_arrow_down);
        setupButton(button5, text5, R.drawable.ic_arrow_up, R.drawable.ic_arrow_down);
        setupButton(button6, text6, R.drawable.ic_arrow_up, R.drawable.ic_arrow_down);

        ImageView buttonBack = view.findViewById(R.id.button_back);

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }

    private void setupButton(final ImageView button, final TextView textView, final int upDrawable, final int downDrawable) {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (textView.getVisibility() == View.GONE) {
                    textView.setVisibility(View.VISIBLE);
                    button.setImageResource(upDrawable);
                } else {
                    textView.setVisibility(View.GONE);
                    button.setImageResource(downDrawable);
                }
            }
        });
    }
}