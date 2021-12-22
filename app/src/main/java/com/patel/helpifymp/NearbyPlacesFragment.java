package com.patel.helpifymp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.patel.helpifymp.Adapters.NearbyPlaceAdapter;
import com.patel.helpifymp.Models.ItemNearbyPlace;
import com.patel.helpifymp.databinding.FragmentNearbyPlacesBinding;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NearbyPlacesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */

public class NearbyPlacesFragment extends Fragment {

    private FragmentNearbyPlacesBinding binding;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public NearbyPlacesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment NearbyPlacesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static NearbyPlacesFragment newInstance(String param1, String param2) {
        NearbyPlacesFragment fragment = new NearbyPlacesFragment();
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

        binding = FragmentNearbyPlacesBinding.inflate(inflater,container,false);
        View root = binding.getRoot();

        ArrayList<ItemNearbyPlace> listItemNearbyPlace = new ArrayList<ItemNearbyPlace>();

        listItemNearbyPlace.add(new ItemNearbyPlace("Sukoon Health", "Plot 4P, Sector 56, Gurugram, Haryana 122011", "+918448170041"));
        listItemNearbyPlace.add(new ItemNearbyPlace("Better LYF", "DGL 234, 2nd Floor, DLF Galleria, Mayur Vihar, Delhi, 110091","+919266626435" ));
        listItemNearbyPlace.add(new ItemNearbyPlace("Hand to Mental Health Psychological Intervention Clinic", "2nd floor aptm. no, J1/163, A6, Rajouri Garden, New Delhi, Delhi 110027", "+919910030005"));
        listItemNearbyPlace.add(new ItemNearbyPlace("Best Psychologist in India - Psychowellness Center", "J12/33 First Floor - B, Rajouri Garden, Delhi, 110027", "+919810636188"));
        listItemNearbyPlace.add(new ItemNearbyPlace("GoodPsyche", "Moti Nagar, Kailash Park, Basai Dara pur, Kirti Nagar, New Delhi, Delhi 110015", "+918375800870"));
        listItemNearbyPlace.add(new ItemNearbyPlace("Inside Out Mental Health Clinic", "SP-1, Maurya Enclave, Block SP, Poorvi Pitampura, Pitam Pura, Delhi, 110034", "+919354584798"));
        listItemNearbyPlace.add(new ItemNearbyPlace("TalktoAngel", "Block A 5B, A5C 62B, Janakpuri, New Delhi, Delhi 110058", "+919358193588"));
        listItemNearbyPlace.add(new ItemNearbyPlace("CIMBS at Cygnus Psychiatry & Psychology Services", "29 C 5, opp. IIT Delhi Main Rd, Safdarjung Development Area, Gate, New Delhi, Delhi 110016", "+919717402402"));
        listItemNearbyPlace.add(new ItemNearbyPlace("Asha Kiran Mental Hospital", " Block B, Pocket C, Sector 1, Rohini, Delhi, 110085", "01127512885"));
        listItemNearbyPlace.add(new ItemNearbyPlace("Untwine Therapy", "GL-18, G-Block, Jail Road, Hari Nagar, near OM Sweets, Hari Nagar, Delhi, New Delhi, Delhi 110064", "+918802082346"));
        listItemNearbyPlace.add(new ItemNearbyPlace("Kaleidoscope - Mental Wellness Centre", "32-B, Pusa Rd, Block 11, Old Rajinder Nagar, Karol Bagh, New Delhi, Delhi 110005", "+917428581953"));
        listItemNearbyPlace.add(new ItemNearbyPlace("Soulmate, Mental Health Centre", "106, Block B, Subhadra Colony, Daya Basti, New Delhi, Delhi 110035", "+919868243005"));
        listItemNearbyPlace.add(new ItemNearbyPlace("Institute of Psychometric Assessment and Counselling", "J-8/77, Nehru Pl Market Rd, Block J, Rajouri Garden Extension, Rajouri Garden, New Delhi, Delhi 110027", "+919911903358"));
        listItemNearbyPlace.add(new ItemNearbyPlace("SR mental health and deaddiction clinic", "159, Vardmaan Mall, Sector 19, Dwarka, New Delhi, Delhi 110075", "+918802002505"));
        listItemNearbyPlace.add(new ItemNearbyPlace("Shanti Home", "SHANTI MUKAMD HOSPITAL, VIKAS MARG, New Delhi, Delhi 110092", "+919811603233"));
        listItemNearbyPlace.add(new ItemNearbyPlace("Punah: Santulan", "F-60, Bali Nagar, Near Ramesh Nagar Metro Station, Gate 1, New Delhi, Delhi 110015", "01141721969"));
        listItemNearbyPlace.add(new ItemNearbyPlace("Yashaushwani Bakshi: Psychologist, Career Counsellor and Special Educator", "BF-20, FF, Janakpuri, New Delhi, Delhi 110058", "+919667224654"));
        listItemNearbyPlace.add(new ItemNearbyPlace("Sanjivini Society For Mental Health", " Above Shop No. 182, Above State Bank Of India, Under Defence Colony Flyover, Jungpura Side, New Delhi, Delhi 110024", "01124311918"));


        NearbyPlaceAdapter adapter = new NearbyPlaceAdapter(listItemNearbyPlace, getContext());
        binding.nearbyPlaces.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL,false));
        binding.nearbyPlaces.setAdapter(adapter);
        return root;
    }

}