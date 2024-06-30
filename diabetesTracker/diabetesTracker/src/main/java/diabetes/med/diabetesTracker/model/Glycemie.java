package diabetes.med.diabetesTracker.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Glycemie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private double level;

    private String day;

    private String imageUrl;

    private LocalDate date;

    public Glycemie() {

    }

    public Glycemie(String name, double level, String day, String imageUrl, LocalDate date) {
        this.name = name;
        this.level = level;
        this.day = day;
        this.imageUrl = imageUrl;
        this.date = date;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLevel() {
        return level;
    }

    public void setLevel(double level) {
        this.level = level;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Glycemie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", level=" + level +
                ", day='" + day + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", date=" + date +
                '}';
    }
}
