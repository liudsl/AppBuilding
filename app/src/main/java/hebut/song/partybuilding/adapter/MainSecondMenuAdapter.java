package hebut.song.partybuilding.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.style.IconMarginSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import hebut.song.partybuilding.R;
import hebut.song.partybuilding.entity.MyMenu;

public class MainSecondMenuAdapter extends RecyclerView.Adapter<MainSecondMenuViewHolder> {
    Context context;
    List<MyMenu> menuList;

    public MainSecondMenuAdapter(Context context, List<MyMenu> menuList) {
        this.context = context;
        this.menuList = menuList;
    }

    @NonNull
    @Override
    public MainSecondMenuViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MainSecondMenuViewHolder(LayoutInflater.from(context).inflate(R.layout.item_scond_menu, null));
    }

    @Override
    public void onBindViewHolder(@NonNull MainSecondMenuViewHolder mainSecondMenuViewHolder, int i) {
        MyMenu myMenu  = menuList.get(i);
        mainSecondMenuViewHolder.imageView.setImageResource(myMenu.icon);
        mainSecondMenuViewHolder.textView.setText(myMenu.iconName);
    }

    @Override
    public int getItemCount() {
        return null!=menuList? menuList.size():0;
    }
}



class MainSecondMenuViewHolder extends RecyclerView.ViewHolder{

    ImageView imageView;
    TextView textView;

    public MainSecondMenuViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.main_second_menu_item_imageView);
        textView = itemView.findViewById(R.id.main_second_menu_item_textView);

    }
}

