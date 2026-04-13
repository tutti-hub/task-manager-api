package com.jjtutti.taskmanager.entity;

import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "users")
public class User {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Email
    @Column(nullable = false, unique = true)
    private String email;
    
    @NotBlank
    private String name;
    
    private LocalDate createdOn;

    protected User() {}

    public User (String email, String name) {
        this(email, name, LocalDate.now());
    }

    public User(String email, String name, LocalDate createdOn) {
        setEmail(email);
        setName(name);
        this.createdOn = createdOn;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        //TODO: validation
        this.email = email;
        
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        //TODO: validation
        this.name = name;
    }

    public LocalDate getCreatedOn() {
        return createdOn;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || !(obj instanceof User other) || this.id == null) return false;
        return Objects.equals(id, other.id);
    }

    @Override
    public int hashCode() {
        return id == null ? 0 : id.hashCode();
    }

    @Override
    public String toString() {
        return "User:{id=" + id +
        ", email=" + email +
        ", name=" + name +
        ", createdOn=" + createdOn + "}";
    }

}
