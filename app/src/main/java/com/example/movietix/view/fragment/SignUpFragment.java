package com.example.movietix.view.fragment;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.movietix.R;
import com.google.firebase.auth.FirebaseAuth;

public class SignUpFragment extends Fragment {

    private EditText emailField, passwordField;
    private Button signUpBtn;
    private FirebaseAuth auth;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_signup, container, false);

        // Initialize Firebase Authentication
        auth = FirebaseAuth.getInstance();

        // Initialize the views with the correct IDs from the XML layout
        emailField = view.findViewById(R.id.etEmail); // Corrected ID
        passwordField = view.findViewById(R.id.etPassword); // Corrected ID
        signUpBtn = view.findViewById(R.id.btnSignUp); // Corrected ID

        // Set up the sign-up button click listener
        signUpBtn.setOnClickListener(v -> signUpUser());

        return view;
    }

    private void signUpUser() {
        // Get email and password from the EditText fields
        String email = emailField.getText().toString();
        String password = passwordField.getText().toString();

        // Validate the input fields
        if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
            Toast.makeText(getContext(), "Isi semua kolom!", Toast.LENGTH_SHORT).show();
            return;
        }

        // Firebase authentication to create the user
        auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        // Successful registration
                        Toast.makeText(getContext(), "Registrasi berhasil!", Toast.LENGTH_SHORT).show();

                        // Optionally navigate back to LoginFragment or proceed as needed
                        requireActivity().onBackPressed(); // Go back to previous fragment (LoginFragment)
                    } else {
                        // Registration failed, show the error message
                        String errorMessage = task.getException() != null ? task.getException().getMessage() : "Registrasi gagal!";
                        Toast.makeText(getContext(), "Registrasi gagal: " + errorMessage, Toast.LENGTH_LONG).show();
                    }
                });
    }
}
