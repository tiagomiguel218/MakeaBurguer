package amsi.dei.estg.ipleiria.layout.vista;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import amsi.dei.estg.ipleiria.layout.R;

public class RegistoActivity extends AppCompatActivity {

    private EditText etNome, etTelemovel, etMail, etNif, etPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registo);

        Button btRegisto = findViewById(R.id.bttRegisto);
        this.etNome = findViewById(R.id.etNome);
        this.etTelemovel = findViewById(R.id.etTelemovel);
        this.etMail = findViewById(R.id.etMail);
        this.etNif = findViewById(R.id.etNif);
        this.etPass = findViewById(R.id.etPass);

        btRegisto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                verificaRegisto();

            }
        });
    }

    private void verificaRegisto() {
        String nome = this.etNome.getText().toString();
        String telemovel = this.etTelemovel.getText().toString();
        String mail = this.etMail.getText().toString();
        String nif = this.etNif.getText().toString();
        String pass = this.etPass.getText().toString();

        if(!isNomeValido(nome)){
            this.etNome.setError(getString(R.string.TextErrorNome));
            return;
        }
        if(!isTelemovelValida(telemovel)) {
            this.etTelemovel.setError(getString(R.string.TextErrorTelemovel));
            return;
        }
        if(!isEmailValido(mail)){
            this.etMail.setError(getString(R.string.TextErrorMail));
            return;
        }
        if(!isNifValida(nif)) {
            this.etNif.setError(getString(R.string.TextErrorNif));
            return;
        }
        if(!isPassValido(pass)){
            this.etPass.setError(getString(R.string.TextErrorPassword));
            return;
        }
        Toast.makeText(this, "O jogo foi reiniciado!", Toast.LENGTH_SHORT).show();

    }


    private boolean isNomeValido(String nome){
        if(nome == null)
            return false;
        return true;
    }

    private boolean isTelemovelValida(String telemovel){
        if(telemovel == null)
            return false;
        if(telemovel.length() < 9)
            return false;
        if(telemovel.length() > 9)
            return false;
        return Patterns.PHONE.matcher(telemovel).matches();
    }

    private boolean isEmailValido(String mail){
        if(mail == null)
            return false;

        return Patterns.EMAIL_ADDRESS.matcher(mail).matches();
    }

    private boolean isNifValida(String nif) {
        if (nif == null)
            return false;
        if(nif.length() < 9)
            return false;
        if(nif.length() > 9)
            return false;
        return true;
    }

    private boolean isPassValido(String pass){
        if(pass == null)
            return false;
        if(pass.length() < 8)
            return false;
        if(pass.length() > 20)
            return false;
        return true;
    }

}