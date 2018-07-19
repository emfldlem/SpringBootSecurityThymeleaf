package com.template.sbssth.Model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name ="customer")
public class Customer implements Serializable {

    private static final long serialVersionUID = -7291882322359393649L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "created_date")
    private Date created_date;

    public Customer(String name, String email, Date created_date) {
        this.name = name;
        this.email = email;
        this.created_date = created_date;
    }
    public Customer() {}

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", created_date=" + created_date +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreated_date() {
        return created_date;
    }

    public void setCreated_date(Date created_date) {
        this.created_date = created_date;
    }
}
