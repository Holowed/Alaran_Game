package pl.alaran.pe;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import pl.alaran.pe.character.Character;
import pl.alaran.pe.character.CharacterDao;

@Database(entities = Character.class, version = 2)
public abstract class GameRoomDatabase extends RoomDatabase {

    public abstract CharacterDao characterDao();

    private static volatile GameRoomDatabase gameRoomInstance;
    public static GameRoomDatabase getDatabase(final Context context) {
        if(gameRoomInstance == null) {
            synchronized (GameRoomDatabase.class) {
                if (gameRoomInstance == null) {
                    gameRoomInstance = Room.databaseBuilder(context.getApplicationContext(),GameRoomDatabase.class, "game_database").allowMainThreadQueries().build();
                }
            }
        }
        return gameRoomInstance;
    }
}
