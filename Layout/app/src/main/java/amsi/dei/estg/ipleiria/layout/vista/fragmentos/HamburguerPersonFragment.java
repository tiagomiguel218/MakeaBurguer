package amsi.dei.estg.ipleiria.layout.vista.fragmentos;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import amsi.dei.estg.ipleiria.layout.R;
import amsi.dei.estg.ipleiria.layout.vista.HamburguerCustomizadoctivity;

public class HamburguerPersonFragment extends Fragment {


    public HamburguerPersonFragment() {
        // Required empty public constructor
    }
    private ListView listView;
    //private GridViewAdaptadorHamburguer adaptadorhamburguer;
    private FloatingActionButton FABAdd;
    private Button add;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_hamburguer_personalizado, container, false);

        this.listView = view.findViewById(R.id.listViewHamburguerPersonalizado);
        this.FABAdd=view.findViewById(R.id.FabAdd);
        this.add=view.findViewById(R.id.bttAdicionar);

        FABAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addBurguer();

            }
        });

       /* add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //AdicionarHamburguerPerson();
            }
        });*/

        return view;
    }

    private void addBurguer(){
        Intent intentPersonalizado = new Intent(getContext(), HamburguerCustomizadoctivity.class);
        startActivity(intentPersonalizado);
    }


   /* private void AdicionarHamburguerPerson() {
        //Toast.makeText(, "O hamburguer foi adicionado!", Toast.LENGTH_SHORT).show();
    }*/

}

