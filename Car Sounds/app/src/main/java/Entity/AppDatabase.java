package Entity;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import dao.CarDao;

@Database(entities = {Car.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract CarDao carDao();
}
