package hebut.song.partybuilding.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;

import android.view.LayoutInflater;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import hebut.song.partybuilding.MainActivity;
import hebut.song.partybuilding.R;
import hebut.song.partybuilding.entity.MyMenu;
import hebut.song.partybuilding.interfaces.OnRecycleViewClickListener;

public class MainFirstMenuAdapter extends RecyclerView.Adapter<MainMenuViewHolder> {


    private Context context;
    private List<MyMenu> menuList;
    private OnRecycleViewClickListener myListener;

    public MainFirstMenuAdapter(Context context, List<MyMenu> menuList) {
        this.context = context;
        this.menuList = menuList;
    }

    public MainFirstMenuAdapter(Context context, List<MyMenu> menuList, OnRecycleViewClickListener myListener) {
        this.context = context;
        this.menuList = menuList;
        this.myListener = myListener;
    }

    @NonNull
    @Override
    public MainMenuViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MainMenuViewHolder(LayoutInflater.from(context).inflate(R.layout.item_main_menu, null));
    }

    @Override
    public void onBindViewHolder(@NonNull MainMenuViewHolder mainMenuViewHolder, final int i) {
        MyMenu menu = menuList.get(i);
        mainMenuViewHolder.imageView.setImageResource(menu.icon);
        mainMenuViewHolder.textView.setText(menu.iconName);


        if(this.myListener != null){
            mainMenuViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    myListener.myClick(v, i);
                }
            });

        }
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
