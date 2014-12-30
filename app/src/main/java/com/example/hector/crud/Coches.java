package com.example.hector.crud;

/**
 * Created by Hector on 28/12/2014.
 */
public class Coches {
    private String Matricula;
    private String Marca;
    private String Modelo;
    private String Motorizacion;
    private String Cilindrada;
    private String FechaCompra;

    public Coches() {

    }

    public String getMatricula() {
        return Matricula;
    }

    public void setMatricula(String matricula) {
        Matricula = matricula;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String marca) {
        Marca = marca;
    }

    public String getModelo() {
        return Modelo;
    }

    public void setModelo(String modelo) {
        Modelo = modelo;
    }

    public String getMotorizacion() {
        return Motorizacion;
    }

    public void setMotorizacion(String motorizacion) {
        Motorizacion = motorizacion;
    }

    public String getCilindrada() {
        return Cilindrada;
    }

    public void setCilindrada(String cilindrada) {
        Cilindrada = cilindrada;
    }

    public String getFechaCompra() {
        return FechaCompra;
    }

    public void setFechaCompra(String fechaCompra) {
        FechaCompra = fechaCompra;
    }

    public Coches(String matricula, String marca, String modelo, String motorizacion, String cilindrada, String fechaCompra) {

        Matricula = matricula;
        Marca = marca;
        Modelo = modelo;
        Motorizacion = motorizacion;
        Cilindrada = cilindrada;
        FechaCompra = fechaCompra;
    }

    public String toString() {
        return (getMatricula() + "\n" + getMarca() + "\n" + getModelo() + "\n" + getMotorizacion() +"\n"+ getCilindrada() + "\n" + getFechaCompra());
    }


}
