package hebut.song.partybuilding.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import hebut.song.partybuilding.InfoActivity;
import hebut.song.partybuilding.R;
import hebut.song.partybuilding.adapter.MessageInfoAdapter;
import hebut.song.partybuilding.util.DataUtil;


public class MessageFragment extends Fragment {

    ListView listView;
    MessageInfoAdapter adapter;

    private String[] news = { "通知1", "通知2", "通知3", "通知4",
            "通知5", "通知6", "通知7", "通知8", "通知9", "通知10"};

    private int[] picture = {
            R.drawable.main_function_exam,  R.drawable.main_function_exam,  R.drawable.main_function_exam,
            R.drawable.main_function_exam,  R.drawable.main_function_exam,  R.drawable.main_function_exam,
            R.drawable.main_function_exam,  R.drawable.main_function_exam,  R.drawable.main_function_exam,
            R.drawable.main_function_exam
    };
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_message, container, false);
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);

        listView = getView().findViewById(R.id.fragment_message_listView);

        adapter  = new MessageInfoAdapter(
                getActivity(), R.layout.item_info, DataUtil.getInfosList(picture, news)
        );

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity(), "you click "+position, Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getActivity(), InfoActivity.class));
            }
        });
    }
}
