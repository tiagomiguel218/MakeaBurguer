package amsi.dei.estg.ipleiria.layout.vista;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import amsi.dei.estg.ipleiria.layout.R;
import amsi.dei.estg.ipleiria.layout.modelo.SessionHandler;

public class RegistoActivity extends AppCompatActivity {

   /* private EditText etNome, etTelemovel, etMail, etNif, etPass;

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
        Toast.makeText(this, "Foi registado!", Toast.LENGTH_SHORT).show();

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
*/

    private static final String KEY_STATUS = "status";
    private static final String KEY_MESSAGE = "message";
    private static final String KEY_FULL_NAME = "full_name";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_PASSWORD = "password";
    private static final String KEY_EMPTY = "";

    private EditText etEmail;
    private EditText etPassword;
    private EditText etConfirmPassword;
    private EditText etFullName;

    private String username;
    private String password;
    private String confirmPassword;
    private String fullName;

    private ProgressDialog pDialog;
    private String register_url = "http://localhost:8080";
    private SessionHandler session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        session = new SessionHandler(getApplicationContext());
        setContentView(R.layout.activity_registo);

        etEmail = findViewById(R.id.etMail);
        etPassword = findViewById(R.id.etPassword);
        etConfirmPassword = findViewById(R.id.etPassRepetir);
        etFullName = findViewById(R.id.etFullName);

        Button login = findViewById(R.id.btnRegisterLogin);
        Button register = findViewById(R.id.btnRegister);

        //Launch Login screen when Login Button is clicked
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(i);
                finish();
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Retrieve the data entered in the edit texts
                username = etUsername.getText().toString().toLowerCase().trim();
                password = etPassword.getText().toString().trim();
                confirmPassword = etConfirmPassword.getText().toString().trim();
                fullName = etFullName.getText().toString().trim();
                if (validateInputs()) {
                    registerUser();
                }

            }
        });

    }

    /**
     * Display Progress bar while registering
     */
    private void displayLoader() {
        pDialog = new ProgressDialog(RegisterActivity.this);
        pDialog.setMessage("Signing Up.. Please wait...");
        pDialog.setIndeterminate(false);
        pDialog.setCancelable(false);
        pDialog.show();

    }

    /**
     * Launch Dashboard Activity on Successful Sign Up
     */
    private void loadDashboard() {
        Intent i = new Intent(getApplicationContext(), DashboardActivity.class);
        startActivity(i);
        finish();

    }

    private void registerUser() {
        displayLoader();
        JSONObject request = new JSONObject();
        try {
            //Populate the request parameters
            request.put(KEY_USERNAME, username);
            request.put(KEY_PASSWORD, password);
            request.put(KEY_FULL_NAME, fullName);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        JsonObjectRequest jsArrayRequest = new JsonObjectRequest
                (Request.Method.POST, register_url, request, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        pDialog.dismiss();
                        try {
                            //Check if user got registered successfully
                            if (response.getInt(KEY_STATUS) == 0) {
                                //Set the user session
                                session.loginUser(username,fullName);
                                loadDashboard();

                            }else if(response.getInt(KEY_STATUS) == 1){
                                //Display error message if username is already existsing
                                etUsername.setError("Username already taken!");
                                etUsername.requestFocus();

                            }else{
                                Toast.makeText(getApplicationContext(),
                                        response.getString(KEY_MESSAGE), Toast.LENGTH_SHORT).show();

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
        MySingleton.getInstance(this).addToRequestQueue(jsArrayRequest);
    }

    /**
     * Validates inputs and shows error if any
     * @return
     */
    private boolean validateInputs() {
        if (KEY_EMPTY.equals(fullName)) {
            etFullName.setError("Full Name cannot be empty");
            etFullName.requestFocus();
            return false;

        }
        if (KEY_EMPTY.equals(username)) {
            etUsername.setError("Username cannot be empty");
            etUsername.requestFocus();
            return false;
        }
        if (KEY_EMPTY.equals(password)) {
            etPassword.setError("Password cannot be empty");
            etPassword.requestFocus();
            return false;
        }

        if (KEY_EMPTY.equals(confirmPassword)) {
            etConfirmPassword.setError("Confirm Password cannot be empty");
            etConfirmPassword.requestFocus();
            return false;
        }
        if (!password.equals(confirmPassword)) {
            etConfirmPassword.setError("Password and Confirm Password does not match");
            etConfirmPassword.requestFocus();
            return false;
        }

        return true;
    }






}