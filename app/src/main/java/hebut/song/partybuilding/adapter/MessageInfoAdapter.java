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
import hebut.song.partybuilding.entity.MyInfo;

public class MessageInfoAdapter extends ArrayAdapter {

    private int resource;

    private Context context;
    public MessageInfoAdapter(Context context, int resource, List<MyInfo> list) {
        super(context, resource, list);
        this.resource = resource;
        this.context = context;
    }

    @Override
    public View getView(int position,  View convertView, ViewGroup parent) {
        MyInfo myInfo = (MyInfo) getItem(position);
        View view = LayoutInflater.from(context).inflate(resource, null);
        ImageView image  = view.findViewById(R.id.info_image);
        TextView title = view.findViewById(R.id.info_title);
        image.setImageResource(myInfo.image);
        title.setText(myInfo.title);
        return view;
    }

}
