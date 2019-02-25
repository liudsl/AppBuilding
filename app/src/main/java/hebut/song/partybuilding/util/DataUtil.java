package hebut.song.partybuilding.util;

import android.content.Context;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import hebut.song.partybuilding.entity.MyMenu;


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
}
