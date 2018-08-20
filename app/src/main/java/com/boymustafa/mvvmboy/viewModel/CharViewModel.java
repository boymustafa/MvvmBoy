package com.boymustafa.mvvmboy.viewModel;

import android.content.Context;
import android.view.View;

import com.boymustafa.mvvmboy.AppController;
import com.boymustafa.mvvmboy.model.Character;
import com.boymustafa.mvvmboy.model.CharacterResponse;
import com.boymustafa.mvvmboy.network.CharService;
import com.boymustafa.mvvmboy.util.Constant;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

public class CharViewModel extends Observable {

    private List<Character> characterList;
    private Context context;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    public CharViewModel(Context context){
        this.context = context;
        this.characterList = new ArrayList<>();
        getCharacterList();
    }

    private void getCharacterList(){
        AppController appController = AppController.create(context);
        CharService charService = appController.getCharService();

        Disposable disposable = charService.getChars(Constant.ALL_URL)
                .subscribeOn(appController.subscriceScheduler())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<CharacterResponse>() {
                    @Override
                    public void accept(CharacterResponse userResponse) throws Exception {
                        updateCharDataList(userResponse.getCharacters());

                    }
                }, new Consumer<Throwable>() {
                    @Override public void accept(Throwable throwable) throws Exception {

                    }
                });

        compositeDisposable.add(disposable);
    }

    private void updateCharDataList(List<Character> characterList){
        this.characterList = characterList;
        setChanged();
        notifyObservers();
    }

    public List<Character> getCharacters(){
        return this.characterList;
    }

    public void reset(){
        if (compositeDisposable != null && !compositeDisposable.isDisposed()){
            compositeDisposable.dispose();
        }
        compositeDisposable = null;
        context =null;
    }

}
