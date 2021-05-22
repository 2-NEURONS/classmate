package com.neuroapis.classmate.user;

import javax.persistence.*;
import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String displayName;
    private String userName;
    private String password;


    public User()
    {
    }
    public User(String displayName, String userName, String password)
    {
        this.displayName = displayName;
        this.userName = userName;
        this.password = password;
    }
   //Lombok's @Data Annotation will take care of my instance members including the constructor
}
