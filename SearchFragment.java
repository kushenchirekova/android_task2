package com.example.a2ndtask;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SearchFragment extends Fragment {
    public EditText mEditText;
    public Button mBtn;
    private SavedPreferences preferences;
    private String name;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.search, container, false);
        mEditText = v.findViewById(R.id.Input);
        mBtn = v.findViewById(R.id.sendText);
        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String search = SavedPreferences.getProperty(name);
                if(search.equals("www.google.com")){
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/search?q=" + mEditText.getText())));
                }else if(search.equals("www.yandex.kz")){
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.yandex.kz/search/?text=" + mEditText.getText())));
                }else if(search.equals("www.bing.com")){
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.bing.com/search?q=" + mEditText.getText())));
                }
            }
        });
        return v;
    }
//    public static SettingsFragment newInstance(){
//        Bundle args = new Bundle();
//        SettingsFragment fragment = new SettingsFragment();
//        fragment.setArguments(args);
//    };
}
