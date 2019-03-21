package hebut.song.partybuilding.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import hebut.song.partybuilding.R;
import hebut.song.partybuilding.entity.MyNew;

public class NewsAdapter extends ArrayAdapter {

    public int resource;
    public Context context;
    public List<MyNew> list;

    public NewsAdapter(Context context, int resource, List<MyNew> objects) {
        super(context, resource, objects);
        this.context  = context;
        this.list = objects;
        this.resource = resource;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MyNew myNew = (MyNew) getItem(position);
        View view = LayoutInflater.from(context).inflate(resource, null);
        ImageView imageView = view.findViewById(R.id.item_new_image);
        TextView title = view.findViewById(R.id.item_new_title);
        TextView time = view.findViewById(R.id.item_new_time);
        imageView.setImageResource(myNew.Picture);
        title.setText(myNew.title);
        time.setText(myNew.time);
        return view;
    }
}
