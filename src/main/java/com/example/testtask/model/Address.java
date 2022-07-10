package com.example.testtask.model;

import com.example.testtask.enums.AddressEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.*;


@Entity
@Table(name = "address")
@NoArgsConstructor
@Getter
@Setter
public class Address {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotNull
    @Column(name = "zip_code")
    private Integer zipCode;

    @Column(name = "street_name")
    @NotEmpty
    private String streetName;

    @Column(name = "house_number")
    private int houseNumber;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "address_type")
    private AddressEnum addressType;

    @Column(name = "village_name")
    private String villageName;

    @OneToMany(mappedBy = "permanentAddress")
    private List<Person> personsWithPermanentAddress;

    @OneToMany(mappedBy = "correspondenceAddress")
    private List<Person> personsWithCorrespondenceAddress;


    public Address(Integer zipCode, String streetName, int houseNumber, AddressEnum addressType, String villageName) {
        this.zipCode = zipCode;
        this.streetName = streetName;
        this.houseNumber = houseNumber;
        this.addressType = addressType;
        this.villageName = villageName;
    }


}
