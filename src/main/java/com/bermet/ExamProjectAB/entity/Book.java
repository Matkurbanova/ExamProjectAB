package com.bermet.ExamProjectAB.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import java.util.Date;

@Entity
@NamedQuery(name = "find all books", query = "select p from Book p")
public class Book {

    @Id
    @GeneratedValue
    private int id;

    private String title;
    private Date publish_date;
    private int quantity;


    public Book(){}

    public Book(String title, Date publish_date, int quantity) {
        this.title = title;
        this.publish_date = publish_date;
        this.quantity = quantity;
    }

    public Book(int id, String title, Date publish_date, int quantity) {
        this.id=id;
        this.title = title;
        this.publish_date = publish_date;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getPublish_date() {
        return publish_date;
    }

    public void setPublish_date(Date publish_date) {
        this.publish_date = publish_date;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return String.format("\nBook [id=%d] [title='%s'] [publish_date='%s'] [quantity=%s]", id, title, publish_date, quantity);
    }
}
