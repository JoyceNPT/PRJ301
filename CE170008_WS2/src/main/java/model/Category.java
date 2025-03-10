/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ngoth
 */
public class Category {

    private int _id;
    private String _name;
    private String _descript;

    public Category() {
        this._id = -1;
        this._name = "";
        this._descript = "";
    }

    public Category(int _id, String _name, String _descript) {
        this._id = _id;
        this._name = _name;
        this._descript = _descript;
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

    public String getDescript() {
        return _descript;
    }

    public void setDescript(String _descript) {
        this._descript = _descript;
    }

    @Override
    public String toString() {
        return _name;
    }

}
