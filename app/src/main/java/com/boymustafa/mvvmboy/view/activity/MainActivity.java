package com.boymustafa.mvvmboy.view.activity;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.boymustafa.mvvmboy.R;

import java.util.Observable;
import java.util.Observer;
import com.boymustafa.mvvmboy.databinding.ActivityMainBinding;
import com.boymustafa.mvvmboy.view.adapter.CharAdapter;
import com.boymustafa.mvvmboy.viewModel.CharViewModel;

public class MainActivity extends AppCompatActivity implements Observer {

    private ActivityMainBinding activityMainBinding;
    private CharViewModel charViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        //init data binding
        activityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        charViewModel = new CharViewModel(this);
        activityMainBinding.setMainViewModel(charViewModel);

        //setup list of character
        CharAdapter adapter = new CharAdapter();
        activityMainBinding.listChar.setAdapter(adapter);
        activityMainBinding.listChar.setLayoutManager(new LinearLayoutManager(this));

        //setup observer
        charViewModel.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof CharViewModel){
            CharAdapter charAdapter = (CharAdapter) activityMainBinding.listChar.getAdapter();
            CharViewModel charViewModel = (CharViewModel) o;
            charAdapter.setCharacterList(charViewModel.getCharacters());
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        charViewModel.reset();
    }
}
