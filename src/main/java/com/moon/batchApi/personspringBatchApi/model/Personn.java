package com.moon.batchApi.personspringBatchApi.model;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class Personn {

    @Id
    private Integer id;
    private String fistName;
    private String lastName;
    private int age;
    private String address;
    private String country;
    private int accountName;
    private String idSociety;

}
