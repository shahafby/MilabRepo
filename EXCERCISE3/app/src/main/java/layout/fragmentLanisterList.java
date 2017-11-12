package layout;

import android.app.Fragment;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import milab.excercise3.GOTcharacter;
import milab.excercise3.R;
import milab.excercise3.adapterCharacters;


public class fragmentLanisterList extends Fragment {

    protected List<GOTcharacter> characters;
    protected RecyclerView rvLanister;

    public fragmentLanisterList() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_lanister_list, container, false); // Inflate the layout for this fragment
        rvLanister = (RecyclerView)view.findViewById(R.id.rv_lanister);
        rvLanister.setLayoutManager(new LinearLayoutManager(getActivity()));
        initializeData();
        initializeAdapter();

        return view;
    }

    // This method creates an ArrayList that has three Person objects
    // Checkout the project associated with this tutorial on Github if
    // you want to use the same images.
    private void initializeData(){
        characters = new ArrayList<>();
        characters.add(new GOTcharacter("Tywin Lannister",
                "The lion does not concern himself with the opinions of the sheep.", R.drawable.tywin));
        characters.add(new GOTcharacter("Cersei Lannister",
                "When you play the game of thrones, you win or you die. There is no middle ground.", R.drawable.cersei));
        characters.add(new GOTcharacter("Jaime Lannister",
                "I don't blame him, and I don't blame you. We don't get to choose who we love.", R.drawable.jaime));
        characters.add(new GOTcharacter("Kevan Lannister",
                "I did not return to the capital to serve as your puppet.", R.drawable.kevan));
        characters.add(new GOTcharacter("Tyrion Lannister",
                "Never forget what you are. The rest of the world will not. Wear it like armor, " +
                        "and it can never be used to hurt you.", R.drawable.tyrion));
        characters.add(new GOTcharacter("Lancel Lannister",
                "I'm a different person now. I've found peace in the light of the Seven.", R.drawable.lancel));
        characters.add(new GOTcharacter("Alton Lannister",
                "I'll remember it all, until I die. That was the best day of my life.", R.drawable.alton));

    }

    private void initializeAdapter(){
        adapterCharacters adapter = new adapterCharacters(characters);
        rvLanister.setAdapter(adapter);
    }


}
