package com.example.testtask.model.contracts;


import com.example.testtask.enums.PropertyEnum;
import com.example.testtask.model.Address;
import com.example.testtask.model.Person;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "property_contract")
@Setter
@Getter
@NoArgsConstructor
public class PropertyContract extends Contract{

    @Id
    @OneToOne
    @JoinColumn(
            name = "contract_id",
            referencedColumnName = "id"
    )
    private Contract contractIdProperty;

    @OneToOne
    @JoinColumn(
            name = "address_id",
            referencedColumnName = "id"
    )
    private Address address;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "property_type")
    private PropertyEnum propertyType;


    @Column(name = "cost_property")
    private Double costOfProperty;

    public PropertyContract(Long uniqueNumber, Date dateOfRegistration, Date createdAt, Person person, Address address, PropertyEnum propertyType, Double costOfProperty) {
        super(uniqueNumber, dateOfRegistration, createdAt, person);
        this.address = address;
        this.propertyType = propertyType;
        this.costOfProperty = costOfProperty;
    }
}
