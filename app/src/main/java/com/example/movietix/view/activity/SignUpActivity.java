package com.example.movietix.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.movietix.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class SignUpActivity extends AppCompatActivity {

    private EditText etName, etPhone, etGenre, etEmail, etPassword, etConfirmPassword;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        auth = FirebaseAuth.getInstance();

        // Inisialisasi view
        etName = findViewById(R.id.et_name);
        etPhone = findViewById(R.id.et_phone);
        etGenre = findViewById(R.id.et_genre);
        etEmail = findViewById(R.id.et_email);
        etPassword = findViewById(R.id.et_password);
        etConfirmPassword = findViewById(R.id.et_confirm_password);

        Button btnRegister = findViewById(R.id.btn_register);
        TextView tvLogin = findViewById(R.id.tv_login);

        btnRegister.setOnClickListener(v -> daftarUser());

        tvLogin.setOnClickListener(v -> {
            startActivity(new Intent(this, LoginActivity.class));
            finish();
        });
    }

    private void daftarUser() {
        String name = etName.getText().toString().trim();
        String phone = etPhone.getText().toString().trim();
        String genre = etGenre.getText().toString().trim();
        String email = etEmail.getText().toString().trim();
        String password = etPassword.getText().toString().trim();
        String confirmPassword = etConfirmPassword.getText().toString().trim();

        if (email.isEmpty()) {
            etEmail.setError("Email harus diisi");
            return;
        }

        if (password.isEmpty()) {
            etPassword.setError("Password harus diisi");
            return;
        }

        if (!password.equals(confirmPassword)) {
            etConfirmPassword.setError("Password tidak sama");
            return;
        }

        if (name.isEmpty() || phone.isEmpty() || genre.isEmpty()) {
            Toast.makeText(this, "Isi semua data profil", Toast.LENGTH_SHORT).show();
            return;
        }

        auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()) {
                        FirebaseUser user = auth.getCurrentUser();
                        if (user != null) {
                            String uid = user.getUid();
                            DatabaseReference userRef = FirebaseDatabase.getInstance()
                                    .getReference("users").child(uid);

                            Map<String, Object> userData = new HashMap<>();
                            userData.put("name", name);
                            userData.put("phone", phone);
                            userData.put("favoriteGenre", genre);
                            userData.put("email", email);

                            userRef.setValue(userData).addOnCompleteListener(dbTask -> {
                                if (dbTask.isSuccessful()) {
                                    Toast.makeText(this, "Pendaftaran berhasil", Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(this, MainActivity.class));
                                    finish();
                                } else {
                                    Toast.makeText(this, "Gagal menyimpan data pengguna", Toast.LENGTH_SHORT).show();
                                }
                            });
                        }
                    } else {
                        Toast.makeText(this, "Pendaftaran gagal: " +
                                task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
