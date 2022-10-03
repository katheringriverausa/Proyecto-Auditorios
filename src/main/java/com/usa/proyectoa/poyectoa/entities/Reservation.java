package com.usa.proyectoa.poyectoa.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "reservation")
public class Reservation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date startDate;
    private Date devolutionDate;

    @ManyToOne
    @JoinColumn (name = "client")
    @JsonIgnoreProperties("reservations")
    private Client client;

    public Integer getId (){
        return id;
    }

    public void setId (Integer id){
        this.id = id;
    }

    public Date getStartDate (){
        return startDate;
    }

    public void setStartDate (Date startDate){
        this.startDate = startDate;
    }

    public Date getDevolutionDate (){
        return devolutionDate;
    }

    public void setDevolutionDate (Date devolutionDate){
        this.devolutionDate = devolutionDate;
    }

    public Client getClient (){
        return client;
    }

    public void setClient (Client client){
        this.client = client;
    }
}
