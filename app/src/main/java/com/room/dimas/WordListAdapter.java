package com.room.dimas;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.WordViewHolder> {

    private Context context;

    private List<Word> mWords;

    public WordListAdapter(Context context) {
        this.context = context;
    }

    public void setmWords(List<Word> mWords) {
        this.mWords = mWords;
        notifyDataSetChanged();
    }

    @Override
    public WordListAdapter.WordViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.item_word, viewGroup, false);
        return new WordViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull WordListAdapter.WordViewHolder wordViewHolder, int position) {
        if (mWords != null) {
            Word current = mWords.get(position);
            wordViewHolder.wordItemView.setText(current.getWord());
        } else {
            // Covers the case of data not being ready yet.
            wordViewHolder.wordItemView.setText("No Word");
        }
    }

    @Override
    public int getItemCount() {
        if (mWords != null)
            return mWords.size();
        else return 0;
    }

    public class WordViewHolder extends RecyclerView.ViewHolder {

        private final TextView wordItemView;

        public WordViewHolder(@NonNull View itemView) {
            super(itemView);
            wordItemView = itemView.findViewById(R.id.textView);
        }
    }
}
