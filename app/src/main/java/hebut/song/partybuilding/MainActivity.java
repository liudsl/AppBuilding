package hebut.song.partybuilding;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import hebut.song.partybuilding.fragment.FindFragment;
import hebut.song.partybuilding.fragment.MainFragment;
import hebut.song.partybuilding.fragment.MeFragment;
import hebut.song.partybuilding.fragment.MessageFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private FindFragment findFragment = new FindFragment();
    private MeFragment meFragment = new MeFragment();
    private MessageFragment messageFragment = new MessageFragment();
    private MainFragment mainFragment = new MainFragment();

    private ImageView menuMain;
    private ImageView menuFind;
    private ImageView menuMessage;
    private ImageView menuMe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.container_content, mainFragment)
                .add(R.id.container_content, findFragment)
                .add(R.id.container_content, meFragment)
                .add(R.id.container_content, messageFragment)
                .hide(findFragment)
                .hide(messageFragment)
                .hide(meFragment)
                .commit();

        InitView();
    }

    private void InitView() {
        menuMain = findViewById(R.id.menu_main_icon);
        menuFind = findViewById(R.id.menu_find_icon);
        menuMessage = findViewById(R.id.menu_message_icon);
        menuMe = findViewById(R.id.menu_me_icon);

        menuMain.setOnClickListener(this);
        menuFind.setOnClickListener(this);
        menuMessage.setOnClickListener(this);
        menuMe.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.menu_find_icon:
                this.getSupportFragmentManager()
                        .beginTransaction()
                        .hide(mainFragment)
                        .show(findFragment)
                        .hide(messageFragment)
                        .hide(meFragment)
                        .commit();
                break;
            case R.id.menu_main_icon:
                this.getSupportFragmentManager()
                        .beginTransaction()
                        .show(mainFragment)
                        .hide(findFragment)
                        .hide(messageFragment)
                        .hide(meFragment)
                        .commit();
                break;
            case R.id.menu_me_icon:
                this.getSupportFragmentManager()
                        .beginTransaction()
                        .hide(mainFragment)
                        .hide(findFragment)
                        .hide(messageFragment)
                        .show(meFragment)
                        .commit();
                break;

            case R.id.menu_message_icon:
                this.getSupportFragmentManager()
                        .beginTransaction()
                        .hide(mainFragment)
                        .hide(findFragment)
                        .show(messageFragment)
                        .hide(meFragment)
                        .commit();
                break;
        }
    }
}
