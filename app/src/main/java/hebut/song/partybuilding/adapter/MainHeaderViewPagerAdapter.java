package hebut.song.partybuilding.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

public class MainHeaderViewPagerAdapter extends PagerAdapter {
    protected Context context;
    protected List<ImageView> imageList;


    public MainHeaderViewPagerAdapter(Context context, List<ImageView> list) {
        this.context = context;
        this.imageList = list;
    }

    @Override
    public int getCount() {
        return null != this.imageList?imageList.size():0;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        container.addView(imageList.get(position));
        return imageList.get(position);
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView(imageList.get(position));
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == o;
    }
}
