package com.usa.proyectoa.poyectoa.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "message")
public class Message implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMessage;
    private String messageText;
    @ManyToOne
    @JoinColumn (name = "audience")
    @JsonIgnoreProperties({"messages", "reservations"})
    private Auditorium audience;
    @ManyToOne
    @JoinColumn (name = "client")
    @JsonIgnoreProperties({"messages", "reservations"})
    private Client client;

    public Integer getIdMessage (){
        return idMessage;
    }

    public void setIdMessage (Integer idMessage){
        this.idMessage = idMessage;
    }

    public Auditorium getAudience (){
        return audience;
    }

    public void setAudience (Auditorium audience){
        this.audience = audience;
    }

    public String getMessageText (){
        return messageText;
    }

    public void setMessageText (String messageText){
        this.messageText = messageText;
    }

    public Client getClient (){
        return client;
    }

    public void setClient (Client client){
        this.client = client;
    }
    }
