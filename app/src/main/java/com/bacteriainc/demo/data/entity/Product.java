
package com.bacteriainc.demo.data.entity;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Product implements Parcelable {

    private String descripcion;
    private Long descuento;
    private List<Extra> extras;
    private String id;
    private List<Price> precios;
    private Long status;
    private String tiendaId;
    private String titulo;

    @SerializedName("urlImagen")
    private String urlImagen;

    public Product(String descripcion, Long descuento, List<Extra> extras, String id, List<Price> precios, Long status, String tiendaId, String titulo, String urlImagen) {
        this.descripcion = descripcion;
        this.descuento = descuento;
        this.extras = extras;
        this.id = id;
        this.precios = precios;
        this.status = status;
        this.tiendaId = tiendaId;
        this.titulo = titulo;
        this.urlImagen = urlImagen;
    }

    public Product() {
    }

    protected Product(Parcel in) {
        descripcion = in.readString();
        if (in.readByte() == 0) {
            descuento = null;
        } else {
            descuento = in.readLong();
        }
        id = in.readString();
        if (in.readByte() == 0) {
            status = null;
        } else {
            status = in.readLong();
        }
        tiendaId = in.readString();
        titulo = in.readString();
        urlImagen = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(descripcion);
        if (descuento == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(descuento);
        }
        dest.writeString(id);
        if (status == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(status);
        }
        dest.writeString(tiendaId);
        dest.writeString(titulo);
        dest.writeString(urlImagen);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Product> CREATOR = new Creator<Product>() {
        @Override
        public Product createFromParcel(Parcel in) {
            return new Product(in);
        }

        @Override
        public Product[] newArray(int size) {
            return new Product[size];
        }
    };

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Long getDescuento() {
        return descuento;
    }

    public void setDescuento(Long descuento) {
        this.descuento = descuento;
    }

    public List<Extra> getExtras() {
        return extras;
    }

    public void setExtras(List<Extra> extras) {
        this.extras = extras;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Price> getPrecios() {
        return precios;
    }

    public void setPrecios(List<Price> precios) {
        this.precios = precios;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public String getTiendaId() {
        return tiendaId;
    }

    public void setTiendaId(String tiendaId) {
        this.tiendaId = tiendaId;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

}
