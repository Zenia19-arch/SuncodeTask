package com.example.suncode.domain;

import javax.persistence.*;
import java.util.ArrayList;

import java.util.List;

@Entity
@Table(name = "tabela_testowa")
public class Test {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String kolumna1;
    private String kolumna2;
    private String kolumna3;
    private String kolumna4;

    public String getColumn() {
        return column;
    }

    public void setColumn(String column) {
        this.column = column;
    }

    @Transient
    private String column;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKolumna1() {
        return kolumna1;
    }

    public void setKolumna1(String kolumna1) {
        this.kolumna1 = kolumna1;
    }

    public String getKolumna2() {
        return kolumna2;
    }

    public void setKolumna2(String kolumna2) {
        this.kolumna2 = kolumna2;
    }

    public String getKolumna3() {
        return kolumna3;
    }

    public void setKolumna3(String kolumna3) {
        this.kolumna3 = kolumna3;
    }

    public String getKolumna4() {
        return kolumna4;
    }

    public void setKolumna4(String kolumna4) {
        this.kolumna4 = kolumna4;
    }
}
