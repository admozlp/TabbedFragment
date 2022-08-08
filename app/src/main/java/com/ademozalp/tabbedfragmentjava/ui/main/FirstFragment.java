package com.ademozalp.tabbedfragmentjava.ui.main;

import static java.util.List.of;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.ademozalp.tabbedfragmentjava.R;
public class FirstFragment extends Fragment {

    PageViewModel pageViewModel;
    EditText textView;

    public static FirstFragment newInstance(){
        return new FirstFragment();
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageViewModel = new ViewModelProvider(requireActivity()).get(PageViewModel.class);// verileri pageViewModel de tutmak için obje ürettik
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_first,container,false);// fragment ile xml bağlama işlemi
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        textView = view.findViewById(R.id.editText);

        textView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                pageViewModel.setName(charSequence.toString());
                //Toast.makeText(getContext().getApplicationContext(), charSequence.toString(), Toast.LENGTH_LONG).show();  --> amaç aktiviteyi almayı öğrenmek
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
}