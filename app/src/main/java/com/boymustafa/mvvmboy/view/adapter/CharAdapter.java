package com.boymustafa.mvvmboy.view.adapter;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.boymustafa.mvvmboy.R;
import com.boymustafa.mvvmboy.databinding.ItemCharBinding;
import com.boymustafa.mvvmboy.model.Character;
import com.boymustafa.mvvmboy.viewModel.ItemViewModel;

import java.util.Collections;
import java.util.List;
//import com.boymustafa.mvvmboy.viewModel.CharViewModel;

public class CharAdapter extends RecyclerView.Adapter<CharAdapter.CharAdapterViewHolder> {

    private List<Character> characterList;

    public CharAdapter(){
        this.characterList = Collections.emptyList();
    }

    @NonNull
    @Override
    public CharAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemCharBinding itemCharBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.item_char,parent,false);
        return new CharAdapterViewHolder(itemCharBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull CharAdapterViewHolder holder, int position) {
        holder.bindChar(characterList.get(position));
    }

    @Override
    public int getItemCount() {
        return characterList.size();
    }

    public void setCharacterList(List<Character> characterList){
        this.characterList = characterList;
        notifyDataSetChanged();
    }


    public static class CharAdapterViewHolder extends RecyclerView.ViewHolder{
        ItemCharBinding itemCharBinding;

        public CharAdapterViewHolder(ItemCharBinding itemCharBinding){
            super(itemCharBinding.itemPeople);
            this.itemCharBinding = itemCharBinding;
        }

        void bindChar(Character character){
            if (itemCharBinding.getItemViewModel() == null){
                itemCharBinding.setItemViewModel(new ItemViewModel(character,itemView.getContext()));

            } else {
                itemCharBinding.getItemViewModel().setCharacter(character);
            }

        }
    }


}
