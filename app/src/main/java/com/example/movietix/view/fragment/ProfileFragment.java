package com.example.movietix.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.movietix.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ProfileFragment extends Fragment {

    private FirebaseAuth auth;

    public ProfileFragment() {
        // Konstruktor kosong wajib
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inisialisasi FirebaseAuth
        auth = FirebaseAuth.getInstance();
        FirebaseUser currentUser = auth.getCurrentUser();

        // Inflate layout utama ProfileFragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        // Jika user belum login, tampilkan LoginFragment di dalam container
        if (currentUser == null) {
            FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
            transaction.replace(R.id.profile_container, new LoginFragment());
            transaction.commit();
        }
        // Jika user sudah login, tampilkan data langsung di fragment_profile.xml
        // atau bisa kamu isi data pengguna di sini nanti.

        return view;
    }
}
