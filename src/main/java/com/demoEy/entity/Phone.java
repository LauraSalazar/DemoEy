package com.demoEy.entity;

import jakarta.persistence.*;
@Entity
@Table(name="PHONES")
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long phone_id;
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
    @Column(name = "numero")
    private String numero;

    @Column(name = "citycode")
    private String cityCode;

    @Column(name = "countrycode")
    private String countrycode;

    public Long getPhone_id() {
        return phone_id;
    }

    public void setPhone_id(Long phone_id) {
        this.phone_id = phone_id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getCountrycode() {
        return countrycode;
    }

    public void setCountrycode(String countrycode) {
        this.countrycode = countrycode;
    }
}
