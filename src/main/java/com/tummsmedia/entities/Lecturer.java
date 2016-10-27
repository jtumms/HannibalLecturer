package com.tummsmedia.entities;

import javax.persistence.*;

/**
 * Created by john.tumminelli on 10/26/16.
 */
@Entity
@Table(name = "lecturers")
public class Lecturer {
    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String topic;

    @Column(nullable = false)
    private String image;

    public Lecturer() {
    }

    public Lecturer(String name, String topic, String image) {
        this.name = name;
        this.topic = topic;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
