
package com.bacteriainc.demo.data.entity;

import android.os.Parcel;
import android.os.Parcelable;

public class Price implements Parcelable {

    private String descripcion;
    private double precio;
    private String titulo;

    public Price(String descripcion, double precio, String titulo) {
        this.descripcion = descripcion;
        this.precio = precio;
        this.titulo = titulo;
    }

    public Price() {
    }

    protected Price(Parcel in) {
        descripcion = in.readString();

        precio = in.readDouble();

        titulo = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(descripcion);
        dest.writeDouble(precio);
        dest.writeString(titulo);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Price> CREATOR = new Creator<Price>() {
        @Override
        public Price createFromParcel(Parcel in) {
            return new Price(in);
        }

        @Override
        public Price[] newArray(int size) {
            return new Price[size];
        }
    };

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(Long precio) {
        this.precio = precio;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

}
