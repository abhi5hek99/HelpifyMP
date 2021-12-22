package com.patel.helpifymp;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.patel.helpifymp.databinding.FragmentMentalBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MentalFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MentalFragment extends Fragment {

    private FragmentMentalBinding binding;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public MentalFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MentalFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MentalFragment newInstance(String param1, String param2) {
        MentalFragment fragment = new MentalFragment();
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

        binding = FragmentMentalBinding.inflate(inflater,container,false);
        View root = binding.getRoot();


        binding.CVMentalHealthTips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Opening Mental health tips", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getContext(), MentalHealthTipsActivity.class);
                startActivity(intent);
            }
        });

        binding.CVProfessionalHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Opening Professional helps index", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getContext(), ProfessionalHelpActivity.class);
                startActivity(intent);

            }
        });
        // Inflate the layout for this fragment
        return root;
    }
}