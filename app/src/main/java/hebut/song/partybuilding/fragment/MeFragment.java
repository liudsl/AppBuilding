package hebut.song.partybuilding.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import hebut.song.partybuilding.LoginActivity;
import hebut.song.partybuilding.R;


public class MeFragment extends Fragment {

    Button loginButton;
    ClickListener clickListener;
    
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_me, container, false);
        InitView(view);
        return view;
    }

    private void InitView(View view) {
        loginButton = view.findViewById(R.id.me_header_button_login);
        clickListener = new ClickListener();
        loginButton.setOnClickListener(clickListener);
    }

    private class ClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.me_header_button_login:
                    Intent intent = new Intent(getActivity(), LoginActivity.class);
                    startActivity(intent);
                    break;
            }
            
        }
    }
}
