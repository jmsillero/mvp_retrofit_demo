
package com.bacteriainc.demo.data.entity;

import android.os.Parcel;
import android.os.Parcelable;

public class Item implements Parcelable {

    private String id;
    private String nombre;
    private double precio;
    private Long status;

    public Item(String id, String nombre, Long precio, Long status) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.status = status;
    }

    public Item() {
    }

    protected Item(Parcel in) {
        id = in.readString();
        nombre = in.readString();
        precio = in.readDouble();

        if (in.readByte() == 0) {
            status = null;
        } else {
            status = in.readLong();
        }
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(nombre);
        dest.writeDouble(precio);

        if (status == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(status);
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Item> CREATOR = new Creator<Item>() {
        @Override
        public Item createFromParcel(Parcel in) {
            return new Item(in);
        }

        @Override
        public Item[] newArray(int size) {
            return new Item[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

}
