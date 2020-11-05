
package com.bacteriainc.demo.data.entity;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class Category implements Parcelable {

    private String categoria;
    private List<Product> productos;

    public Category(String categoria, List<Product> productos) {
        this.categoria = categoria;
        this.productos = productos;
    }

    public Category() {
    }

    protected Category(Parcel in) {
        categoria = in.readString();
        productos = in.createTypedArrayList(Product.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(categoria);
        dest.writeTypedList(productos);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Category> CREATOR = new Creator<Category>() {
        @Override
        public Category createFromParcel(Parcel in) {
            return new Category(in);
        }

        @Override
        public Category[] newArray(int size) {
            return new Category[size];
        }
    };

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public List<Product> getProductos() {
        return productos;
    }

    public void setProductos(List<Product> productos) {
        this.productos = productos;
    }

}
