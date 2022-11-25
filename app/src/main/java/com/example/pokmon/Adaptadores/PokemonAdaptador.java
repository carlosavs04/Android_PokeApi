package com.example.pokmon.Adaptadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.pokmon.Modelos.Pokemon;
import com.example.pokmon.Modelos.Results;
import com.example.pokmon.R;

import java.util.List;

public class PokemonAdaptador extends RecyclerView.Adapter<PokemonAdaptador.viewholder> {
    List<Results> LR;

    public PokemonAdaptador(List<Results> LR) {
        this.LR = LR;
    }

    @NonNull
    @Override
    public PokemonAdaptador.viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);

        return new viewholder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PokemonAdaptador.viewholder holder, int position) {
        holder.setData(LR.get(position));
    }

    @Override
    public int getItemCount() {
        return LR.size();
    }

    public class viewholder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView txtName;
        TextView txtUrl;
        Results pokemonHolder;

        public viewholder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txtName);
            txtUrl = itemView.findViewById(R.id.txtUrl);
            itemView.setOnClickListener(this);
        }

        public void setData(Results r) {
            pokemonHolder = r;
            txtName.setText(pokemonHolder.getName().toString());
            txtUrl.setText(pokemonHolder.getUrl().toString());
        }

        @Override
        public void onClick(View view) {

        }
    }
}
