package pl.alaran.pe.character;

import android.app.Application;
import android.os.AsyncTask;
import android.util.Log;


import androidx.lifecycle.AndroidViewModel;

import pl.alaran.pe.GameRoomDatabase;

public class CharacterViewModel extends AndroidViewModel {

    private String TAG = this.getClass().getSimpleName();

    private CharacterDao characterDao;
    private GameRoomDatabase gameDB;

    public CharacterViewModel(Application application) {
        super(application);

        gameDB = GameRoomDatabase.getDatabase(application);
        characterDao = gameDB.characterDao();

    }
    public void insert(Character character) {
        new InsertAsyncTask(characterDao).execute(character);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        Log.i(TAG, "ViewModel Destroyed");
    }
    private class InsertAsyncTask extends AsyncTask<Character, Void, Void> {

        CharacterDao mCharacterDao;
        public InsertAsyncTask(CharacterDao mCharacterDao) {
            this.mCharacterDao = mCharacterDao;
        }
        @Override
        protected Void doInBackground(Character... characters) {
            mCharacterDao.insert(characters[0]);
            return null;
        }
    }
    public Character[] getAllCharacters(){
        return characterDao.getAllCharacters();
    }
    public Character getCharacter(int id) { return characterDao.getCharacter(id); }
}
