package com.exercise.movies.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "t_movie") //schema?
@EntityListeners(AuditingEntityListener.class)
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "oid", updatable = false)
    private Long oid;

    @Column(name = "title")
    private String title;

    @Column(name = "date")
    private Date date;

    @Column(name = "rank")
    private Double rank;

    @Column(name = "revenue")
    private Double revenue;

    public Movie(){}

    public Movie(String title, Date date, double rank, double revenue){
        this.title = title;
        this.date = date;
        if(rank >= 0 && rank <= 10)
            this.rank = rank;
        if(revenue >= 0)
            this.revenue = revenue;
    }

    public Long getOid(){
        return oid;
    }

    public void setOid(long oid){
        this.oid = oid;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public Date getDate(){
        return date;
    }

    public void setDate(Date date){
        this.date = date;
    }

    public Double getRank(){
        return rank;
    }

    public void setRank(double rank){
        if(rank >= 0 && rank <= 10)
            this.rank = rank;
    }

    public Double getRevenue(){
        return revenue;
    }

    public void setRevenue(double revenue){
        if(revenue >= 0)
            this.revenue = revenue;
    }






    
}
