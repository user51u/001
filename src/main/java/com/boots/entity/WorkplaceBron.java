package com.boots.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Entity
@Table(name = "t_workplace_bron")
public class WorkplaceBron {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long number;
    private String detail;
    private Date date_start=null;
    private Date date_stop=null;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Date getDate_start() {
        return date_start;
    }

    public void setDate_start(Date date_start) {
        this.date_start = date_start;
    }

    public Date getDate_stop() {
        return date_stop;
    }

    public void setDate_stop(Date date_stop) {
        this.date_stop = date_stop;
    }

    @Override
    public String toString() {
        return "WorkplaceBron{" +
                "id=" + id +
                ", number=" + number +
                ", detail='" + detail + '\'' +
                ", date_start=" + date_start +
                ", date_stop=" + date_stop +
                '}';
    }
}
