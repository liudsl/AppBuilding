package hebut.song.partybuilding.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.HashMap;

import hebut.song.partybuilding.NewsActivity;
import hebut.song.partybuilding.R;
import hebut.song.partybuilding.adapter.MainFirstMenuAdapter;
import hebut.song.partybuilding.adapter.MainHeaderViewPagerAdapter;
import hebut.song.partybuilding.adapter.MainSecondMenuAdapter;
import hebut.song.partybuilding.adapter.MainSecondMenuDecoration;
import hebut.song.partybuilding.interfaces.OnRecycleViewClickListener;
import hebut.song.partybuilding.util.DataUtil;


public class MainFragment extends Fragment {
    ViewPager viewPager;
    private RecyclerView recyclerView;
    private RecyclerView secondRecyclerView;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        viewPager = getView().findViewById(R.id.main_header_ViewPager);
        recyclerView = getView().findViewById(R.id.main_recycleView_function);
        secondRecyclerView = getView().findViewById(R.id.main_recycleView_Second_function);


        int[] drawablePager = {R.drawable.main_pager_1, R.drawable.main_pager_2,
                R.drawable.main_pager_3, R.drawable.main_pager_4};

        int[] drawableMenu = {R.drawable.main_function_news, R.drawable.main_function_material, R.drawable.main_function_courses,
                R.drawable.main_function_names, R.drawable.main_function_activities, R.drawable.main_function_money};
        String[] menuName = getActivity().getResources().getStringArray(R.array.main_menu);

        int[] drawableSecondMenu = {R.drawable.main_function_books, R.drawable.main_function_exam,
                R.drawable.main_function_join, R.drawable.main_function_service, R.drawable.main_function_topic,
                R.drawable.main_function_tv};
        String[] secondMenuNames = getResources().getStringArray(R.array.main_second_menu);

        MainHeaderViewPagerAdapter mainHeaderViewPagerAdapter =
                new MainHeaderViewPagerAdapter(
                        getActivity(), DataUtil.getMainHeaderViewPagerInfo(getActivity(),drawablePager));

        MainFirstMenuAdapter mainContentRecyclerViewAdapter
                = new MainFirstMenuAdapter(getActivity(),
                DataUtil.getMainContentMenuInfo(drawableMenu, menuName
                ), new myRecyclerListener()
        );

        MainSecondMenuAdapter mainSecondMenuAdapter =
                new MainSecondMenuAdapter(getActivity(), DataUtil.getMainContentMenuInfo(
                        drawableSecondMenu, secondMenuNames
                ));

        viewPager.setAdapter(mainHeaderViewPagerAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        recyclerView.setAdapter(mainContentRecyclerViewAdapter);

        secondRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        secondRecyclerView.setAdapter(mainSecondMenuAdapter);
        secondRecyclerView.addItemDecoration(new MainSecondMenuDecoration(setDecoration()));
    }

    private HashMap<String, Integer> setDecoration(){
        HashMap<String, Integer> stringIntegerHashMap = new HashMap<>();
        stringIntegerHashMap.put(MainSecondMenuDecoration.TOP_DECORATION, 25);//top间距
        stringIntegerHashMap.put(MainSecondMenuDecoration.BOTTOM_DECORATION,25);//底部间距
        stringIntegerHashMap.put(MainSecondMenuDecoration.LEFT_DECORATION,15);//左间距
        stringIntegerHashMap.put(MainSecondMenuDecoration.RIGHT_DECORATION,15);
        return stringIntegerHashMap;
    }

    class myRecyclerListener implements OnRecycleViewClickListener{
        @Override
        public void myClick(View v, int pos) {
            if(pos == 0){
                startActivity(new Intent(getContext(), NewsActivity.class));
            }
            Toast.makeText(getContext(),"You Click me: " + pos, Toast.LENGTH_SHORT).show();
        }

        @Override
        public void mLongClick(View v, int pos) {

        }
    }
}
