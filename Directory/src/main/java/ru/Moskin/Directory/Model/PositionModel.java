package ru.Moskin.Directory.Model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "position")
@Data
public class PositionModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;


    private int salary;

    public PositionModel() {

    }

    public PositionModel(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }
}
