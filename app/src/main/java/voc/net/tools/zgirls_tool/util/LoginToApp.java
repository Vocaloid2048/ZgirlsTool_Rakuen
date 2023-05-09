package voc.net.tools.zgirls_tool.util;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import voc.net.tools.zgirls_tool.R;
import voc.net.tools.zgirls_tool.old_ui.ANIActivity;

public class LoginToApp extends DialogFragment {

    public static final String TAG = "LoginDialog";

    public static LoginToApp newInstance() {
        LoginToApp login = new LoginToApp();
        login.setStyle(STYLE_NO_TITLE, 0);
        login.setCancelable(false);
        return login;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.dialog_login_to_app, container, false);


        final EditText passwordEditText = view.findViewById(R.id.dialog_login_password);
        Button loginButton = view.findViewById(R.id.dialog_login_loginBtn);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String password = passwordEditText.getText().toString();
                if (getActivity() != null) {
                    SharedPreferences sharedPreferences = getContext().getSharedPreferences("user_info", Context.MODE_PRIVATE);
                    boolean done = sharedPreferences.getBoolean("ani_pw", false);

                        String passwordFromShared;
                        passwordFromShared = "TrAsH_LuMi_GeT_OuT_Rn";
                        assert passwordFromShared != null;
                        if (password.matches(passwordFromShared)) {
                            LoginToApp.super.dismiss();
                            Intent intent = new Intent(getContext(), ANIActivity.class);
                            startActivity(intent);
                            SharedPreferences.Editor editor = sharedPreferences.edit();
                            editor.putBoolean("ani_pw", true);
                            editor.apply();
                        } else {
                            SharedPreferences.Editor editor = sharedPreferences.edit();
                            editor.putBoolean("ani_pw", false);
                            editor.apply();
                            LoginToApp.super.dismiss();
                        }


                }
            }
        });

        return view;
    }}