/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ngoth
 */
public class Product {

    private int _id;
    private String _name;
    private long _price;
    private int _quantity;
    private String _descript;
    private Category cat;

    public Product() {
        this._id = -1;
        this._name = "";
        this._price = 0;
        this._quantity = 0;
        this._descript = "";
        this.cat = cat;
    }

    public Product(int _id, String _name, long _price, int _quantity, String _descript, Category cat) {
        this._id = _id;
        this._name = _name;
        this._price = _price;
        this._quantity = _quantity;
        this._descript = _descript;
        this.cat = cat;
    }

    public int getId() {
        return _id;
    }

    public void setId(int _id) {
        this._id = _id;
    }

    public String getName() {
        return _name;
    }

    public void setName(String _name) {
        this._name = _name;
    }

    public long getPrice() {
        return _price;
    }

    public void setPrice(long _price) {
        this._price = _price;
    }

    public int getQuantity() {
        return _quantity;
    }

    public void setQuantity(int _quantity) {
        this._quantity = _quantity;
    }

    public String getDescript() {
        return _descript;
    }

    public void setDescript(String _descript) {
        this._descript = _descript;
    }

    public Category getCat() {
        return cat;
    }

    public void setCat(Category cat) {
        this.cat = cat;
    }

    @Override
    public String toString() {
        return "Product{" + "_id=" + _id + ", _name=" + _name + ", _price=" + _price + ", _quantity=" + _quantity + ", _descript=" + _descript + ", cat=" + cat + '}';
    }

}
