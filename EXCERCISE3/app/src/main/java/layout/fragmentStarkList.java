package layout;

import android.app.Fragment;
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


public class fragmentStarkList extends Fragment {

    protected List<GOTcharacter> characters;
    protected RecyclerView rvStark;

    public fragmentStarkList() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_stark_list, container, false); // Inflate the layout for this fragment
        rvStark = (RecyclerView)view.findViewById(R.id.rv_stark);
        rvStark.setLayoutManager(new LinearLayoutManager(getActivity()));
        initializeData();
        initializeAdapter();

        return view;
    }

    // This method creates an ArrayList that has three Person objects
    // Checkout the project associated with this tutorial on Github if
    // you want to use the same images.
    private void initializeData(){
        characters = new ArrayList<>();
        characters.add(new GOTcharacter("Ned Sratk",
                "The man who passes the sentence should swing the sword.", R.drawable.ned));
        characters.add(new GOTcharacter("Catelyn Sratk",
                "...all this horror that's come to my family... it's all because I couldn't love a motherless child.", R.drawable.catelyin));
        characters.add(new GOTcharacter("Banjen Sratk",
                "The dead don't rest.", R.drawable.benjen));
        characters.add(new GOTcharacter("Rickard Sratk",
                "Remember that you are a Stark. Comport yourself with dignity at the Vale and try to stay out of fights. " +
                        "But if you have to fight, win.", R.drawable.rickard));
        characters.add(new GOTcharacter("Lyanna Sratk",
                "Promise me, Ned. Promise me.", R.drawable.lyanna));
        characters.add(new GOTcharacter("Robb Sratk",
                "If we do it your way, Kingslayer, you'd win. We're not doing it your way", R.drawable.robb));
        characters.add(new GOTcharacter("Jon Snow",
                "I want to fight on the side that fights for the living.", R.drawable.jon));
        characters.add(new GOTcharacter("Sansa Sratk",
                "I'm a slow learner, it's true. But I learn.", R.drawable.sansa));
        characters.add(new GOTcharacter("Arya Sratk",
                "My name is Arya Stark. I want you to know that. The last thing you're ever going " +
                        "to see is a Stark smiling down at you as you die.", R.drawable.arya));
        characters.add(new GOTcharacter("Brandon Sratk",
                "Every night it's the same: I'm walking, running, but I'm not me.", R.drawable.brandon));
        characters.add(new GOTcharacter("Rickon Sratk",
                "I'm your brother. I have to protect you.", R.drawable.rickon));

    }

    private void initializeAdapter(){
        adapterCharacters adapter = new adapterCharacters(characters);
        rvStark.setAdapter(adapter);
    }


}
