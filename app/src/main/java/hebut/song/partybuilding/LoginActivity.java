package hebut.song.partybuilding;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class LoginActivity extends AppCompatActivity {
    ImageView loginClose;
    ClickListener clickListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        InitView();
    }

    private void InitView() {
        loginClose = findViewById(R.id.login_header_ImageView_close);
        clickListener = new ClickListener();
        loginClose.setOnClickListener(clickListener);
    }

    private class ClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.login_header_ImageView_close:
                    finish();
                    break;
            }

        }
    }
}
