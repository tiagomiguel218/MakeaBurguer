package amsi.dei.estg.ipleiria.layout.vista;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

import amsi.dei.estg.ipleiria.layout.R;
import amsi.dei.estg.ipleiria.layout.modelo.SessionHandler;
import amsi.dei.estg.ipleiria.layout.modelo.Singleton;

public class LoginActivity extends AppCompatActivity {

   /* private EditText etMail, etPass;

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
*/
    /*private void mostraRegisto() {
        Intent intentRegisto = new Intent(this, RegistoActivity.class);
        startActivity(intentRegisto);
        finish();
    }
*/


    private static final String KEY_STATUS = "status";
    private static final String KEY_MESSAGE = "message";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_NAME = "nome";
    private static final String KEY_PASSWORD = "password";
    private static final String KEY_EMPTY = "";
    private EditText etEmail;
    private EditText etPassword;
    private String email;
    private String password;
    private ProgressDialog pDialog;
    private String login_url = "http://localhost:8080";
    private SessionHandler session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        session = new SessionHandler(getApplicationContext());

        if(session.isLoggedIn()){
            loadMenuPrincipal();
        }
        setContentView(R.layout.activity_login);

        etEmail = findViewById(R.id.etMail);
        etPassword = findViewById(R.id.etPassword);

        Button register = findViewById(R.id.bttRegisto);
        Button login = findViewById(R.id.bttLogin);

        //Launch Registration screen when Register Button is clicked
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this, RegistoActivity.class);
                startActivity(i);
                finish();
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Retrieve the data entered in the edit texts
                email = etEmail.getText().toString().toLowerCase().trim();
                password = etPassword.getText().toString().trim();
                if (validateInputs()) {
                    login();
                }
            }
        });
    }

    /**
     * Launch Dashboard Activity on Successful Login
     */
    private void loadMenuPrincipal() {
        Intent i = new Intent(getApplicationContext(), MenuPrincipalActivity.class);
        startActivity(i);
        finish();

    }

    /**
     * Display Progress bar while Logging in
     */

    private void displayLoader() {
        pDialog = new ProgressDialog(LoginActivity.this);
        pDialog.setMessage("Logging In.. Please wait...");
        pDialog.setIndeterminate(false);
        pDialog.setCancelable(false);
        pDialog.show();

    }

    private void login() {
        displayLoader();
        JSONObject request = new JSONObject();
        try {
            //Populate the request parameters
            request.put(KEY_EMAIL, email);
            request.put(KEY_PASSWORD, password);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        JsonObjectRequest jsArrayRequest = new JsonObjectRequest
                (Request.Method.POST, login_url, request, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        pDialog.dismiss();
                        try {
                            //Check if user got logged in successfully

                            if (response.getInt(KEY_STATUS) == 0) {
                                session.loginUser(email,response.getString(KEY_NAME));
                                loadMenuPrincipal();

                            }else{
                                Toast.makeText(getApplicationContext(),
                                        response.getString(KEY_MESSAGE), Toast.LENGTH_LONG).show();

                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        pDialog.dismiss();

                        //Display error message whenever an error occurs
                        Toast.makeText(getApplicationContext(),
                                error.getMessage(), Toast.LENGTH_SHORT).show();

                    }
                });

        // Access the RequestQueue through your singleton class.
        Singleton.getInstance(this).addToRequestQueue(jsArrayRequest);
    }

    /**
     * Validates inputs and shows error if any
     * @return
     */
    private boolean validateInputs() {
        if(KEY_EMPTY.equals(email)){
            etEmail.setError("Username cannot be empty");
            etEmail.requestFocus();
            return false;
        }
        if(KEY_EMPTY.equals(password)){
            etPassword.setError("Password cannot be empty");
            etPassword.requestFocus();
            return false;
        }
        return true;
    }

    }


