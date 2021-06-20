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
import com.practical.meditationapp.adapters.PopularNewAdapter;
import com.practical.meditationapp.interfaces.MusicInterface;
import com.practical.meditationapp.model.AllPracticesModel;
import com.practical.meditationapp.model.PopularNewListModel;

import java.util.ArrayList;

public class MeditationFragment extends Fragment {

    RecyclerView recyclerViewTraining, recyclerViewMusic;
    ArrayList<PopularNewListModel> trainingList = new ArrayList<>();
    ArrayList<AllPracticesModel> allPracticesList = new ArrayList<>();

    public static Fragment newInstance() {
        return new MeditationFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable  ViewGroup container, @Nullable  Bundle savedInstanceState) {
        View view;

        view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_meditation, null);
        recyclerViewTraining = view.findViewById(R.id.recyclerViewTraining);
        recyclerViewMusic = view.findViewById(R.id.recyclerViewMusic);

        recyclerViewTraining.setLayoutManager(new LinearLayoutManager(requireActivity(),LinearLayoutManager.HORIZONTAL, false));
        recyclerViewTraining.setItemAnimator(new DefaultItemAnimator());
        recyclerViewTraining.setFocusable(false);

        recyclerViewMusic.setLayoutManager(new LinearLayoutManager(requireActivity(),LinearLayoutManager.VERTICAL, false));
        recyclerViewMusic.setItemAnimator(new DefaultItemAnimator());
        recyclerViewMusic.setFocusable(false);

        setTrainingList();
        setAllPracticesList();

        return view;
    }

    private void setTrainingList() {

        trainingList.clear();

        PopularNewListModel popularNewListModel = new PopularNewListModel(R.drawable.ic_card_2);
        trainingList.add(popularNewListModel);

        PopularNewListModel popularNewListModel1 = new PopularNewListModel(R.drawable.ic_card_2);
        trainingList.add(popularNewListModel1);

        PopularNewAdapter popularNewAdapter = new PopularNewAdapter(requireActivity(), trainingList);
        recyclerViewTraining.setAdapter(popularNewAdapter);

    }

    private void setAllPracticesList() {

        allPracticesList.clear();

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

        allPracticesList.add(allPracticesModel1);
        allPracticesList.add(allPracticesModel2);
        allPracticesList.add(allPracticesModel3);
        allPracticesList.add(allPracticesModel4);
        allPracticesList.add(allPracticesModel5);
        allPracticesList.add(allPracticesModel6);
        allPracticesList.add(allPracticesModel7);
        allPracticesList.add(allPracticesModel8);
        allPracticesList.add(allPracticesModel9);

        AllPracticesAdapter allPracticesAdapter = new AllPracticesAdapter(requireActivity(), allPracticesList, new MusicInterface() {
            @Override
            public void onClick() {
                openFragment(PlayerFragment.newInstance());
            }
        });
        recyclerViewMusic.setAdapter(allPracticesAdapter);

    }

    public void openFragment(Fragment fragment) {
        FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
