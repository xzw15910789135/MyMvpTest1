package agent.cn.com.mymvptest1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.List;

import agent.cn.com.mymvptest1.presenter.MvpPresenter;
import agent.cn.com.mymvptest1.view.MvpView;

public class MainActivity extends AppCompatActivity implements MvpView {
    ListView listView;
    ProgressBar progressBar;
    MvpPresenter mvpPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView= (ListView) findViewById(R.id.list);
        progressBar= (ProgressBar) findViewById(R.id.progressBar);
        mvpPresenter=new MvpPresenter(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mvpPresenter.onResume();
    }

    @Override
    public void showloading() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hiedloading() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void itemData(List<String> list) {
        ArrayAdapter arrayAdapter=new ArrayAdapter(MainActivity.this,android.R.layout.simple_list_item_1,list);
        listView.setAdapter(arrayAdapter);
    }

    @Override
    public void showMessage(String str) {
        Toast.makeText(MainActivity.this,str,Toast.LENGTH_SHORT).show();
    }
}
