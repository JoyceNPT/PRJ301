/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ngoth
 */
public class Users {

    private int _id;
    private String _user;
    private String _pass;
    private int _role;

    public Users() {
        this._id = -1;
        this._user = "";
        this._pass = "";
        this._role = -1;
    }

    public Users(int _id, String _user, String _pass, int _role) {
        this._id = _id;
        this._user = _user;
        this._pass = _pass;
        this._role = _role;
    }

    public int getId() {
        return _id;
    }

    public void setId(int _id) {
        this._id = _id;
    }

    public String getUser() {
        return _user;
    }

    public void setUser(String _user) {
        this._user = _user;
    }

    public String getPass() {
        return _pass;
    }

    public void setPass(String _pass) {
        this._pass = _pass;
    }

    public int getRole() {
        return _role;
    }

    public void setRole(int _role) {
        this._role = _role;
    }

    @Override
    public String toString() {
        return "Users{" + "_id=" + _id + ", _user=" + _user + ", _pass=" + _pass + ", _role=" + _role + '}';
    }

}
