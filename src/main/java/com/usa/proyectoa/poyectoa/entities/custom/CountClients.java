package com.usa.proyectoa.poyectoa.entities.custom;

import com.usa.proyectoa.poyectoa.entities.Client;

public class CountClients {
    private Long total;
    private Client client;

    public CountClients (Long total, Client client){
        this.total = total;
        this.client = client;
    }

    public Long getTotal (){
        return total;
    }

    public void setTotal (Long total){
        this.total = total;
    }

    public Client getClient (){
        return client;
    }

    public void setClient (Client client){
        this.client = client;
    }
}
