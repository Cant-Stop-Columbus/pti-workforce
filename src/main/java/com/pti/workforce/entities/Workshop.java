package com.pti.workforce.entities;

import jakarta.persistence.*;

@Entity
public class Workshop {

    @Id
    @GeneratedValue
    private long id;
    private String title;
    @Lob
    @Column(length = 1000000)
    private String details;

    public Workshop() {
    }

    public long getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetails() {
        return this.details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
