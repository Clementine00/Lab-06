package com.example.listycity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * This is a class that keep a list of city objects
 */
public class CityList {
    private List<City> cities = new ArrayList<>();

    /**
     * This adds a city to the list if the city does not already exist
     * @param city
     *          This is a candidate city to add
     */
    public void add(City city){
        if (cities.contains(city)){
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }

    /**
     * This returns an ordered list of cities that are in the list
     * @return
     */
    public List<City> getCities() {
        List<City> list = cities;
        Collections.sort(list);
        return list;
    }

    /**
     * this removes a city from a list if it exists
     * @param city
     *          This is the candidate city to be deleted
     */
    public void delete(City city){
        if (cities.contains(city)){
            cities.remove(city);
        }
        else {
            throw new IllegalArgumentException();
        }
    }

    /**
     * This returns the number of city objects in a list
     * @return the number of cities in the list
     */
    public int countCities(){
        return cities.size();
    }

    /**
     * This returns true if candidate city is in a list, false if not
     * @param city
     *             this is the candidate city to be checked
     * @return true if city is in the list, false if not
     */
    public boolean hasCity(City city){
        if (cities.contains(city)){
            return true;
        }
        else {
            return false;
        }
    }
}
