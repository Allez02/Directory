package ru.Moskin.Directory.Model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "branch")
@Data
public class BranchModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String city;

    private String address;

    private String name;

    public BranchModel() {

    }

    public BranchModel(String city, String address, String name) {
        this.name = name;
        this.address = address;
        this.city = city;
    }
}
