package pl.alaran.pe.character;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface CharacterDao {

    @Insert
    void insert(Character character);


    @Query("SELECT * FROM characters")
    Character[] getAllCharacters();

    @Query("SELECT * FROM characters WHERE id=:id")
    public Character getCharacter(int id);

    @Update
    void updateCharacter(Character character);
}
