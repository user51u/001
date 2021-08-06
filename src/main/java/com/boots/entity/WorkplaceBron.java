package com.boots.entity;

import javax.persistence.*;


import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "t_workplace_bron")
public class WorkplaceBron {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long number;
    private Long id_user;
    private String detail;
    private Timestamp date_start2=null;
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

    public Timestamp getDate_start2() {
        return date_start2;
    }

    public void setDate_start2(Timestamp date_start2) {
        this.date_start2 = date_start2;
    }

    public Date getDate_stop() {
        return date_stop;
    }

    public void setDate_stop(Date date_stop) {
        this.date_stop = date_stop;
    }

    public Long getId_user() {
        return id_user;
    }

    public void setId_user(Long id_user) {
        this.id_user = id_user;
    }

    @Override
    public String toString() {
        return "WorkplaceBron{" +
                "id=" + id +
                ", number=" + number +
                ", id_user=" + id_user +
                ", detail='" + detail + '\'' +
                ", date_start2=" + date_start2 +
                ", date_stop=" + date_stop +
                '}';
    }
}
