package dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import Entity.Car;
import java.util.List;

@Dao
public interface CarDao {
    @Insert
    void insertAll(Car... cars);

    @Query("SELECT * FROM car WHERE id = :carId")
    Car findById(int carId);
}


