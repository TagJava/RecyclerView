package auto.kotlin.com.autopollrecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

import auto.kotlin.com.adapter.AutoPollAdapter;
import auto.kotlin.com.widget.AutoPollRecyclerView;

public class MainActivity extends AppCompatActivity {
    private AutoPollRecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mRecyclerView = (AutoPollRecyclerView) findViewById(R.id.rv_comments_list);
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 5; ) {
            list.add(" Item: " + ++i);
        }
        AutoPollAdapter adapter = new AutoPollAdapter(list);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mRecyclerView.stop();
    }
}
