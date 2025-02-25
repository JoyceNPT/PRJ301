/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ngoth
 */
public class movies {

    private int _id;
    private String _title;
    private String _director;
    private int _release_year;
    private double _rating;
    private boolean _Is_rented;

    public movies() {
        _id = -1;
        _title = "";
        _director = "";
        _release_year = -1;
        _rating = -0.0;
        _Is_rented = false;
    }

    public movies(int _id, String _title, String _director, int _release_year, double _rating, boolean _Is_rented) {
        this._id = _id;
        this._title = _title;
        this._director = _director;
        this._release_year = _release_year;
        this._rating = _rating;
        this._Is_rented = _Is_rented;
    }

    public int getId() {
        return _id;
    }

    public void setId(int _id) {
        this._id = _id;
    }

    public String getTitle() {
        return _title;
    }

    public void setTitle(String _title) {
        this._title = _title;
    }

    public String getDirector() {
        return _director;
    }

    public void setDirector(String _director) {
        this._director = _director;
    }

    public int getRelease_year() {
        return _release_year;
    }

    public void setRelease_year(int _release_year) {
        this._release_year = _release_year;
    }

    public double getRating() {
        return _rating;
    }

    public void setRating(double _rating) {
        this._rating = _rating;
    }

    public boolean getIs_rented() {
        return _Is_rented;
    }

    public void setIs_rented(boolean _Is_rented) {
        this._Is_rented = _Is_rented;
    }

    @Override
    public String toString() {
        return "movies{" + "_id=" + _id + ", _title=" + _title + ", _director=" + _director + ", _release_year=" + _release_year + ", _rating=" + _rating + ", _Is_rented=" + _Is_rented + '}';
    }

}
