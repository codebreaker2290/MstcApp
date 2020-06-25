package com.example.mstcapp.resourcespage;

import android.os.Bundle;
import android.os.RecoverySystem;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mstcapp.R;
import com.example.mstcapp.adapters.ResourcesFolderAdapter;

import java.util.ArrayList;
import java.util.List;

public class resfolderFragment extends Fragment {
    List <String> Sample_title_resfolder =new ArrayList<>();
    RecyclerView resFolder_recyclerview;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_resourcesfolder,container,false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Sample_title_resfolder.add("Activity & Lifecycle");
        Sample_title_resfolder.add("Shared Preferences");
        Sample_title_resfolder.add("Firebase");

        resFolder_recyclerview=view.findViewById(R.id.resfolder_recyclerview);
        resFolder_recyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        resFolder_recyclerview.setAdapter(new ResourcesFolderAdapter(Sample_title_resfolder));
    }
}
