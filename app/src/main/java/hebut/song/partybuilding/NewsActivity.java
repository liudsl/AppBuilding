package hebut.song.partybuilding;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import hebut.song.partybuilding.adapter.NewsAdapter;
import hebut.song.partybuilding.util.DataUtil;

public class NewsActivity extends AppCompatActivity {
    int[] picture = {R.drawable.main_function_books, R.drawable.main_function_books, R.drawable.main_function_books,
            R.drawable.main_function_books, R.drawable.main_function_books, R.drawable.main_function_books
    };
    String[] titles = {"这是标题1", "这是标题2","这是标题3","这是标题4","这是标题5","这是标题6"};
    String[] times = {"XXXX-XX-XX","XXXX-XX-XX","XXXX-XX-XX","XXXX-XX-XX","XXXX-XX-XX","XXXX-XX-XX"};

    ListView listView;
    NewsAdapter newsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        InitView();
    }

    private void InitView() {
        listView = findViewById(R.id.activity_news_listView);
        newsAdapter = new NewsAdapter(
                this, R.layout.item_new, DataUtil.getNewsList(picture,titles, times)
                );
        listView.setAdapter(newsAdapter);
    }
}
