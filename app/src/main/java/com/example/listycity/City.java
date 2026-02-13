package com.example.listycity;

/**
 * This is a class that defines a city
 */
public class City implements Comparable<City> {
    /**
     * the name of the city
     */
    private String city;
    /**
     * the province where the city is located
     */
    private String province;

    /**
     * Constructs a city given its name and the province its in
     * @param city the name of the city
     * @param province the province of the city
     */
    City(String city, String province){
        this.city = city;
        this.province = province;
    }

    /**
     * returns the name of the city
     * @return the city name
     */
    String getCityName(){
        return this.city;
    }

    /**
     * returns the province where the city is located in
     * @return the name of the province
     */
    String getProvinceName(){
        return this.province;
    }

    /**
     * compares this city with another alphabetically based on the name
     * @param o the other city to compare with
     * @return
     */
    @Override
    public int compareTo(City o){
        City city = (City) o;
        return this.city.compareTo(city.getCityName());
    }

    /**
     * indicates whether some other object (in this case cities)  is equal to this city.
     * Two cities are equal if both the name and the province are the same
     * @param o   the reference object with which to compare.
     * @return  true of the city equals the other city
     */
    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (!(o instanceof City)) return false;

        City other = (City) o;
        return city.equals(other.city) && province.equals(other.province);
    }

    /**
     * returns a hash code value for this city
     * @return the hash code for this city
     */
    @Override
    public int hashCode(){
        return city.hashCode() + province.hashCode();
    }
}
