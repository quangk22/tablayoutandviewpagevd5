package org.o7planning.tablayoutandviewpagevd5;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ItemListFragment extends Fragment {
    private List<Actor> actorList;
    private RecyclerView recyclerView;
    private ActorAdapter actorAdapter;

    public ItemListFragment() {
        // Required empty public constructor
    }
    public static ItemListFragment newInstance(int tab) {
        ItemListFragment fragment = new ItemListFragment();
        Bundle args = new Bundle();
        args.putInt("Tab", tab);
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            int tab = getArguments().getInt("Tab");
            createData(tab);
        }
    }
    private void createData(int index) {
        actorList = new ArrayList<>();
        if(index == 0) {
            Actor actor = new Actor("Hulk", R.drawable.image_hulk);
            actorList.add(actor);
            actor = new Actor("spiderman", R.drawable.image_spiderman);
            actorList.add(actor);
            actor = new Actor("Thor", R.drawable.image_thor);
            actorList.add(actor);
            actor = new Actor("Ironman", R.drawable.image_ironman);
            actorList.add(actor);
        }
        if(index == 1){
            Actor actor = new Actor("Jonny Trí Nguyễn", R.drawable.image_spiderman);
            actorList.add(actor);
            actor = new Actor("Thanh Hằng", R.drawable.image_hulk);
            actorList.add(actor);
        }
        actorAdapter = new ActorAdapter( actorList, this);
        actorAdapter.notifyDataSetChanged();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_item_list, container, false);

        Context context = view.getContext();
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(context.getApplicationContext()));
        recyclerView.setAdapter(actorAdapter);

        return view;
    }
}
