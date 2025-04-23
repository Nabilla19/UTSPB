package com.example.movietix.view;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.res.ResourcesCompat;

import com.example.movietix.R;

public class CustomTextView extends AppCompatTextView {

    public CustomTextView(@NonNull Context context) {
        super(context);
        init();
    }

    public CustomTextView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CustomTextView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        Typeface typeface = ResourcesCompat.getFont(getContext(), R.font.poppins_black_italic);
        if (typeface != null) {
            setTypeface(typeface);
        }
    }
}
