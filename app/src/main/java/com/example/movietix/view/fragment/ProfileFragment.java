package com.example.movietix.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.movietix.R;
import com.example.movietix.view.activity.LoginActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ProfileFragment extends Fragment {

    private FirebaseAuth auth;
    private DatabaseReference userRef;

    private TextView emailText, nameText, phoneText, genreText;
    private LinearLayout loggedInLayout;
    private Button signOutBtn;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        // Inisialisasi Firebase Auth
        auth = FirebaseAuth.getInstance();
        FirebaseUser currentUser = auth.getCurrentUser();

        // Inisialisasi View
        loggedInLayout = view.findViewById(R.id.layout_logged_in);
        emailText = view.findViewById(R.id.text_email);
        nameText = view.findViewById(R.id.text_name);
        phoneText = view.findViewById(R.id.text_phone);
        genreText = view.findViewById(R.id.text_genre);
        signOutBtn = view.findViewById(R.id.btn_sign_out);

        if (currentUser != null) {
            loggedInLayout.setVisibility(View.VISIBLE);
            emailText.setText(currentUser.getEmail());

            userRef = FirebaseDatabase.getInstance().getReference("users").child(currentUser.getUid());

            // Gunakan single event jika tidak perlu update terus-menerus
            userRef.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    String name = snapshot.child("name").getValue(String.class);
                    String phone = snapshot.child("phone").getValue(String.class);
                    String genre = snapshot.child("favoriteGenre").getValue(String.class);

                    nameText.setText(name != null ? "Nama: " + name : "Nama: -");
                    phoneText.setText(phone != null ? "Nomor HP: " + phone : "Nomor HP: -");
                    genreText.setText(genre != null ? "Genre Favorit: " + genre : "Genre Favorit: -");
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    Toast.makeText(getContext(), "Gagal memuat data profil", Toast.LENGTH_SHORT).show();
                }
            });

            signOutBtn.setOnClickListener(v -> {
                auth.signOut();
                Toast.makeText(getContext(), "Berhasil keluar", Toast.LENGTH_SHORT).show();
                navigateToLoginActivity();
            });

        } else {
            // Kalau belum login, langsung arahkan ke LoginActivity
            navigateToLoginActivity();
        }

        return view;
    }

    private void navigateToLoginActivity() {
        if (getActivity() != null) {
            Intent intent = new Intent(getActivity(), LoginActivity.class);
            startActivity(intent);
            getActivity().finish();
        }
    }
}
