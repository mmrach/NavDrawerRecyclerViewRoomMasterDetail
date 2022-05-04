package com.amm.navdrawerrecyclerviewroommasterdetail.guisos;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.amm.navdrawerrecyclerviewroommasterdetail.ingrediente.Ingrediente;
import com.amm.navdrawerrecyclerviewroommasterdetail.main.IngredientesViewModel;

import navdrawerrecyclerviewroommasterdetail.R;

public class GuisosAdapter extends ListAdapter<Guisos, GuisosAdapter.GuisosViewHolder> {

    //Declaramos una referencia al ingredientesViewModel
    private GuisosViewModel guisosViewModel;

    protected GuisosAdapter(@NonNull DiffUtil.ItemCallback<Guisos> diffCallback, ViewModelStoreOwner owner) {
        super(diffCallback);
        guisosViewModel = new ViewModelProvider(owner).get(GuisosViewModel.class);
    }

    @NonNull
    @Override
    public GuisosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        View view = inflater.inflate(R.layout.guiso_row_layout, parent, false);
        return new GuisosViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GuisosViewHolder holder, int position) {
        Guisos guiso = getCurrentList().get(position);
        if (guiso != null){
            holder.bind(guiso.getNombre());
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "Seleccionado: " + guiso.getNombre(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public class GuisosViewHolder extends RecyclerView.ViewHolder {
        private TextView tvGuiso;
        //private ImageButton ibDelete;

         public GuisosViewHolder(@NonNull View itemView) {
            super(itemView);
            tvGuiso = itemView.findViewById(R.id.tvGuiso);
        }

        public void bind(String string) {
             tvGuiso.setText(string);
        }
    }

}

