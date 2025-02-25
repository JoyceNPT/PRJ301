/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ngoth
 */
public class users {

    private int _id;
    private String _username;
    private String _password;
    private int _role;

    public users() {
        _id = -1;
        _username = "";
        _password = "";
        _role = -1;
    }

    public users(int _id, String _username, String _password, int _role) {
        this._id = _id;
        this._username = _username;
        this._password = _password;
        this._role = _role;
    }

    public int getId() {
        return _id;
    }

    public void setId(int _id) {
        this._id = _id;
    }

    public String getUsername() {
        return _username;
    }

    public void setUsername(String _username) {
        this._username = _username;
    }

    public String getPassword() {
        return _password;
    }

    public void setPassword(String _password) {
        this._password = _password;
    }

    public int getRole() {
        return _role;
    }

    public void setRole(int _role) {
        this._role = _role;
    }

    @Override
    public String toString() {
        return "users{" + "_id=" + _id + ", _username=" + _username + ", _password=" + _password + ", _role=" + _role + '}';
    }

}
