package com.example.testtask.model.contracts;

import com.example.testtask.model.Person;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "contract")
@Setter
@Getter
@NoArgsConstructor
public abstract class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "unique_number")
    private Long uniqueNumber;

    @Column(name = "date_registration")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat()
    private Date dateOfRegistration;

    @Column(name = "created_at")
    private Date createdAt;

    @ManyToOne
    @JoinColumn(
            name = "person_id",
            referencedColumnName = "id"
    )
    private Person person;

    @OneToOne(mappedBy = "contractIdProperty")
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private PropertyContract propertyContract;

    @OneToOne(mappedBy = "contractIdTravel")
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private TravelContract travelContract;



    public Contract(Long uniqueNumber, Date dateOfRegistration, Date createdAt, Person person) {
        this.uniqueNumber = uniqueNumber;
        this.dateOfRegistration = dateOfRegistration;
        this.createdAt = createdAt;
        this.person = person;
    }
}
