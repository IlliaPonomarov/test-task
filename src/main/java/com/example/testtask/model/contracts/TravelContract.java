package com.example.testtask.model.contracts;


import com.example.testtask.model.Person;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "travel_contract")
@Getter
@Setter
@NoArgsConstructor
public class TravelContract extends Contract {

    @Id
    @OneToOne
    @JoinColumn(
            name = "contract_id",
            referencedColumnName = "id"
    )
    private Contract contractIdTravel;

    @Column(name = "date_beginning")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat()
    private Date beginningDate;

    @Column(name = "date_end")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat()
    private Date endDate;

    @Column(name = "liability_damage" )
    @NotNull
    private Boolean liabilityDamage;

    @Column(name = "accident_insure" )
    @NotNull
    private Boolean accidentInsure;

    public TravelContract(Long uniqueNumber, Date dateOfRegistration, Date createdAt, Person person, Date beginningDate, Date endDate, Boolean liabilityDamage, Boolean accidentInsure) {
        super(uniqueNumber, dateOfRegistration, createdAt, person);
        this.beginningDate = beginningDate;
        this.endDate = endDate;
        this.liabilityDamage = liabilityDamage;
        this.accidentInsure = accidentInsure;
    }






}
