package hebut.song.partybuilding.util;

import android.content.Context;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import hebut.song.partybuilding.entity.MyMenu;
import hebut.song.partybuilding.entity.MyInfo;
import hebut.song.partybuilding.entity.MyNew;


public class DataUtil {

    /**
     * pagerView 数据提供函数
     * @param context
     * @param drawableList
     * @return
     */
    public static List<ImageView> getMainHeaderViewPagerInfo(Context context, int[] drawableList){

        List<ImageView> data = new ArrayList<>();
        for (int i:drawableList){
            ImageView imageView =  new ImageView(context);
            imageView.setImageResource(i);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            data.add(imageView);
        }
        return data;
    }


    public static List<MyMenu> getMainContentMenuInfo(int[] drawableList, String[] names){
        List<MyMenu> data = new ArrayList<>();
        for (int i=0; i<drawableList.length; i++){
            data.add(new MyMenu(drawableList[i], names[i]));
        }
        return data;
    }

    public static List<MyInfo> getInfosList(int[] drawableList, String[] titles){
        List<MyInfo> list = new ArrayList<>();
        for (int i =0; i<drawableList.length; i++){
            list.add(new MyInfo(titles[i], drawableList[i]));
        }
        return list;
    }

    public static List<MyNew> getNewsList(int[] drawable, String[] title, String[] time){
        List<MyNew> list = new ArrayList<>();
        for (int i=0; i<drawable.length;i++){
            list.add(new MyNew(title[i], drawable[i], time[i]));
        }
        return list;
    }
}
