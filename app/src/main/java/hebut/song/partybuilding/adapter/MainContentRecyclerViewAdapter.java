package hebut.song.partybuilding.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;

import android.view.LayoutInflater;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import hebut.song.partybuilding.R;
import hebut.song.partybuilding.entity.MyMenu;

public class MainContentRecyclerViewAdapter extends RecyclerView.Adapter<MainMenuViewHolder> {

    private Context context;
    private List<MyMenu> menuList;

    public MainContentRecyclerViewAdapter(Context context, List<MyMenu> menuList) {
        this.context = context;
        this.menuList = menuList;
    }

    @NonNull
    @Override
    public MainMenuViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MainMenuViewHolder(LayoutInflater.from(context).inflate(R.layout.item_main_menu, null));
    }

    @Override
    public void onBindViewHolder(@NonNull MainMenuViewHolder mainMenuViewHolder, int i) {
        MyMenu menu = menuList.get(i);
        mainMenuViewHolder.imageView.setImageResource(menu.icon);
        mainMenuViewHolder.textView.setText(menu.iconName);
    }

    @Override
    public int getItemCount() {
        return menuList == null ? 0 : menuList.size();
    }
}


class MainMenuViewHolder extends RecyclerView.ViewHolder {
    public ImageView imageView;
    public TextView textView;

    public MainMenuViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.item_main_menu_icon);
        textView = itemView.findViewById(R.id.item_main_menu_text);
    }
}
