package com.room.dimas;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

public class WordViewModel extends AndroidViewModel {

    private WordRepository wordRepository;

    private LiveData<List<Word>> words;

    public WordViewModel(@NonNull Application application) {
        super(application);
        wordRepository = new WordRepository(application);
        words = wordRepository.getWords();
    }

    public LiveData<List<Word>> getWords() {
        return words;
    }

    public void insert(Word word){
        wordRepository.insert(word);
    }
}
