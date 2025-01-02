package Entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Car {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public String name;
    public String model;
    public String imagePath;
    public String videoUrl;
    public String videoDesc;

    // Getter ve Setter metodları
    public int getId() {return id;}

    public void setId(int id) {
        this.id = id;
    }

    public String getvideoUrl() {return videoUrl;}

    public void setvideoUrl(String model) {this.videoUrl = videoUrl;}

    public String getvideoDesc() {return videoDesc;}

    public void setvideoDesc(String model) {
        this.videoDesc = videoDesc;
    }

}
