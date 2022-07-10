package com.example.testtask.model;

import com.example.testtask.model.contracts.Contract;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.*;


@Entity
@Table(name = "person")
@NoArgsConstructor
@Getter
@Setter
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "unique_identity")
    @NotNull
    private Long unique_identity;

    @NotNull
    @Column(name = "first_name")
    private String firstName;

    @NotNull
    @Column(name = "second_name")
    private String secondName;

    @Email
    @NotNull
    private String email;

    @ManyToOne
    @JoinColumn(name = "permanent_address_id",referencedColumnName = "id")
    private Address permanentAddress;

    @ManyToOne
    @JoinColumn(name = "correspondence_address_id",referencedColumnName = "id")
    private Address correspondenceAddress;

    @OneToMany
    private List<Contract> contractList;


    public Person(Long unique_identity, String firstName, String secondName, String email, Address permanentAddress, Address correspondenceAddress) {
        this.unique_identity = unique_identity;
        this.firstName = firstName;
        this.secondName = secondName;
        this.email = email;
        this.permanentAddress = permanentAddress;
        this.correspondenceAddress = correspondenceAddress;
    }
}
