package amsi.dei.estg.ipleiria.layout.vista;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import amsi.dei.estg.ipleiria.layout.R;

public class LoginActivity extends AppCompatActivity {

    private EditText etMail, etPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button btLogin = findViewById(R.id.bttLogin);
        Button btRegisto = findViewById(R.id.bttRegisto);
        this.etMail = findViewById(R.id.etMail);
        this.etPass = findViewById(R.id.etPassword);

        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                verificaLogin();

            }
        });
        btRegisto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mostraRegisto();
            }
        });
    }

    private void mostraRegisto() {
        Intent intentRegisto = new Intent(this, RegistoActivity.class);
        startActivity(intentRegisto);
        finish();
    }


    private void verificaLogin() {
        String pass = this.etPass.getText().toString();
        String mail = this.etMail.getText().toString();

        if(!isEmailValido(mail)){
            this.etMail.setError(getString(R.string.TextErrorMail));
            return;
        }

        if(!isPasswordValida(pass)) {
            this.etPass.setError(getString(R.string.TextErrorPassword));
            return;
        }
        mostraMenuPrincipal();

    }

    private void mostraMenuPrincipal() {
        Intent intentPrincipal = new Intent(this, MenuPrincipalActivity.class);
        startActivity(intentPrincipal);
        finish();
    }

    private boolean isEmailValido(String mail){
        if(mail == null)
            return false;

        return Patterns.EMAIL_ADDRESS.matcher(mail).matches();
    }

    private boolean isPasswordValida(String password){
        if(password == null)
            return false;
        if(password.length() < 8)
            return false;
        if(password.length() > 20)
            return false;
        return true;
    }

}

