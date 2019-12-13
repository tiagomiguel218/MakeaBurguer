package amsi.dei.estg.ipleiria.layout.vista.fragmentos;

import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;


import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import java.util.Calendar;
import java.util.TimeZone;

import amsi.dei.estg.ipleiria.layout.R;

public class ReservasFragment extends Fragment {


    public ReservasFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_reservas, container, false);
        Spinner lugares;
TextView tvlugares;
        lugares = (Spinner) view.findViewById(R.id.edtLugares);

        lugares.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int lugares = (int) parent.getItemAtPosition(position);
                switch (lugares) {
                    case 1:


                        break;

                    case 2:

                        break;

                    case 3 :

                        break;

                    case  4 :

                        break;
                    case 5 :

                        break;

                    case  6 :

                        break;

                    case  7 :

                        break;

                    case  8 :

                        break;
                    case  9 :

                        break;

                    case  10:

                        break;

                    case 11:

                        break;

                    case 12:

                        break;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // can leave this empty
            }
        });






        return view;
    }
}