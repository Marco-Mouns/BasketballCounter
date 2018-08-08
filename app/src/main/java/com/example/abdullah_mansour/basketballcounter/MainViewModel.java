package com.example.abdullah_mansour.basketballcounter;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.util.Log;

import com.example.abdullah_mansour.basketballcounter.DB.AppDatabase;
import com.example.abdullah_mansour.basketballcounter.DB.MatchesEntry;

import java.util.List;

public class MainViewModel extends AndroidViewModel {

    // Constant for logging
    private static final String TAG = MainViewModel.class.getSimpleName();

    private LiveData<List<MatchesEntry>> mMatchesentry;

    public MainViewModel(Application application) {
        super(application);
        AppDatabase database = AppDatabase.getInstance(this.getApplication());
        Log.d(TAG, "Actively retrieving the tasks from the DataBase");
        mMatchesentry = database.matchesDAO().loadAllTasks();
    }

    public LiveData<List<MatchesEntry>> getmMatchesentry() {
        return mMatchesentry;
    }
}
