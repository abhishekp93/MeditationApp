package com.practical.meditationapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.practical.meditationapp.R;
import com.practical.meditationapp.adapters.PopularNewAdapter;
import com.practical.meditationapp.model.PopularNewListModel;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    RecyclerView recyclerViewPopular, recyclerViewNew;
    TextView lblSeeAllPopular, lblSeeAllNew;
    ArrayList<PopularNewListModel> popularList = new ArrayList<>();
    ArrayList<PopularNewListModel> newList = new ArrayList<>();

    public static Fragment newInstance() {
        return new HomeFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view;

        view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_home, null);
        recyclerViewPopular = view.findViewById(R.id.recyclerViewPopular);
        recyclerViewNew = view.findViewById(R.id.recyclerViewNew);
        lblSeeAllPopular = view.findViewById(R.id.lblSeeAllPopular);
        lblSeeAllNew = view.findViewById(R.id.lblSeeAllNew);

        recyclerViewPopular.setLayoutManager(new LinearLayoutManager(requireActivity(),LinearLayoutManager.HORIZONTAL, false));
        recyclerViewPopular.setItemAnimator(new DefaultItemAnimator());
        recyclerViewPopular.setFocusable(false);

        recyclerViewNew.setLayoutManager(new LinearLayoutManager(requireActivity(),LinearLayoutManager.HORIZONTAL, false));
        recyclerViewNew.setItemAnimator(new DefaultItemAnimator());
        recyclerViewNew.setFocusable(false);

        lblSeeAllPopular.setOnClickListener(listenerSeeAllPopular);
        lblSeeAllNew.setOnClickListener(listenerSeeAllNew);

        setPopularAndNewList();

        return view;
    }

    View.OnClickListener listenerSeeAllPopular = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            openFragment(PopularFragment.newInstance());
        }
    };

    View.OnClickListener listenerSeeAllNew = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            openFragment(PopularFragment.newInstance());
        }
    };

    private void setPopularAndNewList() {

        popularList.clear();
        newList.clear();

        PopularNewListModel popularNewListModel = new PopularNewListModel(R.drawable.ic_card_1);
        popularList.add(popularNewListModel);

        PopularNewListModel popularNewListModel1 = new PopularNewListModel(R.drawable.ic_card_3);
        popularList.add(popularNewListModel1);

        PopularNewAdapter popularNewAdapter = new PopularNewAdapter(requireActivity(), popularList);
        recyclerViewPopular.setAdapter(popularNewAdapter);

        PopularNewListModel popularNewListModel3 = new PopularNewListModel(R.drawable.ic_card_3);
        newList.add(popularNewListModel3);

        PopularNewListModel popularNewListModel4 = new PopularNewListModel(R.drawable.ic_card_1);
        newList.add(popularNewListModel4);

        PopularNewAdapter popularNewAdapter1 = new PopularNewAdapter(requireActivity(), newList);
        recyclerViewNew.setAdapter(popularNewAdapter1);

    }

    public void openFragment(Fragment fragment) {
        FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

}
