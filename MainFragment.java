package com.example.a2ndtask;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainFragment extends Fragment {
    public int index = -1;
    private SavedPreferences preferences;
    private String name;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.main_fragment, container, false);
        setHasOptionsMenu(true);
        //preferences.getProperty(name);
        return v;
    }
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_3, menu);
        //super.onCreateOptionsMenu(menu, inflater);
    }

//    public int translateIdToIndex(int id) {
//        int index = -1;
//        switch (id) {
//            case R.id.settings:
//                index = 1;
//                break;
//            case R.id.Search:
//                index = 2;
//                break;
//            case R.id.exit:
//                index = 3;
//                break;
//        }
//        return index;
//    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.settings:
                showMessage(getString(R.string.settings_toast));
                replaceFragment(new SearchFragment());
                return true;
            case R.id.Search:
                showMessage(getString(R.string.search_toast));
                replaceFragment(new SearchFragment());
                return true;
            case R.id.exit:
                showMessage(getString(R.string.exit_toast));
                getActivity().finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
        //return super.onOptionsItemSelected(item);
    }
    public void replaceFragment(Fragment fragment){
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.addToBackStack(null);
        transaction.replace(R.id.first_fragment, fragment);
        transaction.commit();
    }
//   public void onClick(View view) {
//        int buttonIndex = translateIdToIndex(view.getId());
//
//        // Временный код для получения индекса нажатой кнопки
//    }
//    public interface OnSelectedButtonListener {
//        void onButtonSelected(int buttonIndex);
//    }
    private void showMessage(String string){
        Toast.makeText(getActivity(), string, Toast.LENGTH_LONG).show();
    }
}
