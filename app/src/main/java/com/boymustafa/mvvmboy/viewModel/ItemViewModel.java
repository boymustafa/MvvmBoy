package com.boymustafa.mvvmboy.viewModel;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.boymustafa.mvvmboy.model.Character;
import com.bumptech.glide.Glide;

public class ItemViewModel extends BaseObservable {

    private Character character;
    private Context context;

    public ItemViewModel(Character character,Context context){
        this.character = character;
        this.context = context;
    }

    public String getId(){
        return character.id;
    }

    public String getName(){
        return "Name: "+character.name;
    }

    public String getStatus(){
        return "Status: "+character.status;
    }

    public String getSpecies(){
        return character.species;
    }

    public String getImg(){
        return character.image;
    }

    public void setCharacter(Character character){
        this.character = character;
        notifyChange();
    }

    @BindingAdapter("imgURL")
    public static void setImageUrl(ImageView view, String url){
        Glide.with(view.getContext()).load(url).into(view);
    }

}
