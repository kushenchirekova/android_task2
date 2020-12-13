package com.example.a2ndtask;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SettingsFragment extends Fragment {
    public RadioButton googleBtn;
    public RadioButton yandexBtn;
    public RadioButton bingBtn;
    public String name = "browser";
    public String browser;
    private SavedPreferences mSavedPreferences;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_main, container, false);
        googleBtn = v.findViewById(R.id.google);
        yandexBtn = v.findViewById(R.id.yandex);
        bingBtn = v.findViewById(R.id.bing);
        return v;
    }
    public static SettingsFragment newInstance(){
        Bundle args = new Bundle();
        SettingsFragment fragment = new SettingsFragment();
        fragment.setArguments(args);
        return fragment;
    }
    View.OnClickListener radioButtonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            RadioButton rb = (RadioButton) v;
            switch (rb.getId()){
                case R.id.google:
                    browser = "www.google.com";
                    break;
                case R.id.yandex:
                    browser = "www.yandex.kz";
                    break;
                case R.id.bing:
                    browser = "www.bing.com";
                default:
                    break;
            }
            mSavedPreferences.addProperty(name, browser);
        }
    };
}
