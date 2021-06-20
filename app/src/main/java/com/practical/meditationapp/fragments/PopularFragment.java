package com.practical.meditationapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.practical.meditationapp.R;
import com.practical.meditationapp.adapters.AllPracticesAdapter;
import com.practical.meditationapp.interfaces.MusicInterface;
import com.practical.meditationapp.model.AllPracticesModel;

import java.util.ArrayList;

public class PopularFragment extends Fragment {

    RecyclerView recyclerViewPopularList;
    ArrayList<AllPracticesModel> popularList = new ArrayList<>();

    public static Fragment newInstance() {
        return new PopularFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull  LayoutInflater inflater, @Nullable  ViewGroup container, @Nullable  Bundle savedInstanceState) {
        View view;

        view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_popular_list, null);
        recyclerViewPopularList = view.findViewById(R.id.recyclerViewPopularList);

        recyclerViewPopularList.setLayoutManager(new LinearLayoutManager(requireActivity(),LinearLayoutManager.VERTICAL, false));
        recyclerViewPopularList.setItemAnimator(new DefaultItemAnimator());
        recyclerViewPopularList.setFocusable(false);

        setPopularList();

        return view;
    }

    private void setPopularList() {

        popularList.clear();

        AllPracticesModel allPracticesModel1 = new AllPracticesModel("Mental Training",
                "3 min 43 sec", R.drawable.illustration_1, R.drawable.ic_icons_like);
        AllPracticesModel allPracticesModel2 = new AllPracticesModel("Gratitude",
                "2 min 33 sec", R.drawable.illustration_2, R.drawable.ic_icons_like);
        AllPracticesModel allPracticesModel3 = new AllPracticesModel("The Cure Of Boredom",
                "7 min 11 sec", R.drawable.illustration_3, R.drawable.ic_icons_like);
        AllPracticesModel allPracticesModel4 = new AllPracticesModel("Free Will 1",
                "11 min 14 sec", R.drawable.illustration_4, R.drawable.ic_icons_like);
        AllPracticesModel allPracticesModel5 = new AllPracticesModel("Free Will 2",
                "8 min 45 sec", R.drawable.illustration_5, R.drawable.ic_icons_like);
        AllPracticesModel allPracticesModel6 = new AllPracticesModel("Free Will 3",
                "6 min 43 sec", R.drawable.illustration_1, R.drawable.ic_icons_like);
        AllPracticesModel allPracticesModel7 = new AllPracticesModel("Spiritual 1",
                "5 min 33 sec", R.drawable.illustration_2, R.drawable.ic_icons_like);
        AllPracticesModel allPracticesModel8 = new AllPracticesModel("Spiritual 2",
                "4 min 43 sec", R.drawable.illustration_3, R.drawable.ic_icons_like);
        AllPracticesModel allPracticesModel9 = new AllPracticesModel("Anxiety",
                "6 min 11 sec", R.drawable.illustration_4, R.drawable.ic_icons_like);

        popularList.add(allPracticesModel1);
        popularList.add(allPracticesModel2);
        popularList.add(allPracticesModel3);
        popularList.add(allPracticesModel4);
        popularList.add(allPracticesModel5);
        popularList.add(allPracticesModel6);
        popularList.add(allPracticesModel7);
        popularList.add(allPracticesModel8);
        popularList.add(allPracticesModel9);

        AllPracticesAdapter allPracticesAdapter = new AllPracticesAdapter(requireActivity(), popularList, new MusicInterface() {
            @Override
            public void onClick() {
                openFragment(PlayerFragment.newInstance());
            }
        });
        recyclerViewPopularList.setAdapter(allPracticesAdapter);

    }


    public void openFragment(Fragment fragment) {
        FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
