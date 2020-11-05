
package com.bacteriainc.demo.data.entity;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;


public class Extra implements Parcelable {

    private String descripcion;
    private String id;
    private List<Item> items;
    private Long maximo;
    private Long minimo;
    private Long obligatorio;
    private Long status;
    private String titulo;

    public Extra(String descripcion, String id, List<Item> items, Long maximo, Long minimo, Long obligatorio, Long status, String titulo) {
        this.descripcion = descripcion;
        this.id = id;
        this.items = items;
        this.maximo = maximo;
        this.minimo = minimo;
        this.obligatorio = obligatorio;
        this.status = status;
        this.titulo = titulo;
    }

    public Extra() {
    }

    protected Extra(Parcel in) {
        descripcion = in.readString();
        id = in.readString();
        if (in.readByte() == 0) {
            maximo = null;
        } else {
            maximo = in.readLong();
        }
        if (in.readByte() == 0) {
            minimo = null;
        } else {
            minimo = in.readLong();
        }
        if (in.readByte() == 0) {
            obligatorio = null;
        } else {
            obligatorio = in.readLong();
        }
        if (in.readByte() == 0) {
            status = null;
        } else {
            status = in.readLong();
        }
        titulo = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(descripcion);
        dest.writeString(id);
        if (maximo == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(maximo);
        }
        if (minimo == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(minimo);
        }
        if (obligatorio == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(obligatorio);
        }
        if (status == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(status);
        }
        dest.writeString(titulo);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Extra> CREATOR = new Creator<Extra>() {
        @Override
        public Extra createFromParcel(Parcel in) {
            return new Extra(in);
        }

        @Override
        public Extra[] newArray(int size) {
            return new Extra[size];
        }
    };

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Long getMaximo() {
        return maximo;
    }

    public void setMaximo(Long maximo) {
        this.maximo = maximo;
    }

    public Long getMinimo() {
        return minimo;
    }

    public void setMinimo(Long minimo) {
        this.minimo = minimo;
    }

    public Long getObligatorio() {
        return obligatorio;
    }

    public void setObligatorio(Long obligatorio) {
        this.obligatorio = obligatorio;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

}
