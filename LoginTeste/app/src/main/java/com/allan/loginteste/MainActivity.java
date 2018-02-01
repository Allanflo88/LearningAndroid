package com.allan.loginteste;

import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    private EditText edEmail;
    private EditText edSenha;
    private Button btEntrar;
    private FirebaseAuth auth;
    private String TAG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edEmail = findViewById(R.id.edEmail);
        edSenha = findViewById(R.id.edSenha);
        btEntrar = findViewById(R.id.btEntrar);
        auth = FirebaseAuth.getInstance();
        onStart();


        btEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login(edEmail.getText().toString(), edSenha.getText().toString());
            }
        });
    }

    public void createAccount(String email, String password){
        auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {


                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success");
                            FirebaseUser user = auth.getCurrentUser();
                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(MainActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            updateUI(null);
                        }


                        // ...
                    }
                });
    }

    public void login(final String email, final String password) {
        auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithEmail:success");
                            FirebaseUser user = auth.getCurrentUser();
                            Toast.makeText(MainActivity.this, user.getEmail(),Toast.LENGTH_SHORT);

                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            Toast.makeText(MainActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            createAccount(email,password);
                        }

                    }
                });
    }

    public void updateUI(FirebaseUser currentUser){
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setNeutralButton("OK", null);
        dialog.setMessage("login realizado " + currentUser.getEmail());
        dialog.show();
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = auth.getCurrentUser();
        try{
            updateUI(currentUser);
        }
        catch (Exception e){

            Toast.makeText(MainActivity.this, "usuário não logado", Toast.LENGTH_LONG).show();
        }

    }
}
