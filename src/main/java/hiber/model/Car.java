package hiber.model;

import javax.persistence.*;

@Entity
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long series;

    @Column(name = "model")
    private String model;


    @OneToOne(mappedBy = "car")
    private User user;

    public Car(){}

    public Car(String model){
        this.model = model;
    }

    public Long getSeries() {
        return series;
    }

    public String getModel() {
        return model;
    }

    public void setSeries(Long series) {
        this.series = series;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "\nSeries = "    + series
                + "\nModel = "  + model
                + "\n";
    }
}
