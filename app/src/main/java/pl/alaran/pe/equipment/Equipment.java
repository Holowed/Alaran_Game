package pl.alaran.pe.equipment;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "equipment")
public class Equipment {

    @PrimaryKey(autoGenerate = true)
    private Integer id;

    //Foreign key
    private Integer item_id;

}
