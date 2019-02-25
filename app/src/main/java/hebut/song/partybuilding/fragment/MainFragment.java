package hebut.song.partybuilding.fragment;

import android.media.Image;
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
import android.widget.ImageView;

import java.util.List;

import hebut.song.partybuilding.R;
import hebut.song.partybuilding.adapter.MainContentRecyclerViewAdapter;
import hebut.song.partybuilding.adapter.MainHeaderViewPagerAdapter;
import hebut.song.partybuilding.util.DataUtil;


public class MainFragment extends Fragment {
    ViewPager viewPager;
    private RecyclerView recyclerView;

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
        int[] drawablePager = {R.drawable.main_pager_1, R.drawable.main_pager_2,
                R.drawable.main_pager_3, R.drawable.main_pager_4};
        int[] drawableMenu = {R.drawable.main_function_news, R.drawable.main_function_material, R.drawable.main_function_courses,
                R.drawable.main_function_names, R.drawable.main_function_activities, R.drawable.main_function_money};
        String[] menuName = getActivity().getResources().getStringArray(R.array.main_menu);

        MainHeaderViewPagerAdapter mainHeaderViewPagerAdapter =
                new MainHeaderViewPagerAdapter(
                        getActivity(),
                        DataUtil.getMainHeaderViewPagerInfo(
                                getActivity(),
                                drawablePager
                        ));
        MainContentRecyclerViewAdapter mainContentRecyclerViewAdapter
                = new MainContentRecyclerViewAdapter(
                    getActivity(),
                    DataUtil.getMainContentMenuInfo(
                        drawableMenu, menuName
                    )
        );

        viewPager.setAdapter(mainHeaderViewPagerAdapter);

        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        recyclerView.setAdapter(mainContentRecyclerViewAdapter);

    }
}
