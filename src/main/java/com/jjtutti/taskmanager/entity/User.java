package com.jjtutti.taskmanager.entity;

import java.time.LocalDate;
import org.hibernate.annotations.CreationTimestamp;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User extends BaseEntity {
  
    @Column(nullable = false, unique = true)
    private String email;
    
    private String name;
  
    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDate createdOn;

    protected User() {}

    public User(String email, String name) {
        setEmail(email);
        setName(name);
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getCreatedOn() {
        return createdOn;
    }

    @Override
    public String toString() {
        return "User{id=" + id +
        ", email=" + email +
        ", name=" + name +
        ", createdOn=" + createdOn + "}";
    }

}
