package milab.excercise3;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by shahaf on 10/11/2017.
 */
public class adapterCharacters extends RecyclerView.Adapter<adapterCharacters.CharacterViewHolder> {

    public static class CharacterViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView characterName;
        TextView characterAge;
        ImageView characterPhoto;

        CharacterViewHolder(View itemView) {
            super(itemView);
            cv = (CardView) itemView.findViewById(R.id.cv);
            characterName = (TextView) itemView.findViewById(R.id.person_name);
            characterAge = (TextView) itemView.findViewById(R.id.person_slogen);
            characterPhoto = (ImageView) itemView.findViewById(R.id.person_photo);
        }
    }

    List<GOTcharacter> characters;

    public adapterCharacters(List<GOTcharacter> characters){
        this.characters = characters;
    }

    @Override
    public CharacterViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, viewGroup, false);
        CharacterViewHolder pvh = new CharacterViewHolder(v);
        return pvh;
    }
    @Override
    public void onBindViewHolder(CharacterViewHolder personViewHolder, int i) {
        personViewHolder.characterName.setText(characters.get(i).name);
        personViewHolder.characterAge.setText(characters.get(i).slogen);
        personViewHolder.characterPhoto.setImageResource(characters.get(i).photoId);
    }
    @Override
    public int getItemCount() {
        return characters.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}