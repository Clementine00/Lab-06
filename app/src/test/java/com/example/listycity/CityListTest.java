package com.example.listycity;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CityListTest {
    private CityList mockCityList(){
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }

    private City mockCity(){
        return new City ("Edmonton","Alberta");
    }

    @Test
    void testAdd(){
        CityList cityList = mockCityList();
        assertEquals(1,cityList.getCities().size());
        City city = new City("Regina","Saskatchewan");
        cityList.add(city);
        assertEquals(2,cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }

    @Test
    void testAddException(){
        CityList cityList = mockCityList();
        City city = new City("Yellowknife","Northwest Territories");
        cityList.add(city);
        assertThrows(IllegalArgumentException.class,()->{
            cityList.add(city);
        });
    }

    @Test
    void testGetCities(){
        CityList cityList = mockCityList();
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));
        City city = new City("Charlottetown","Prince Edward Island");
        cityList.add(city);
        assertEquals(0,city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }

    @Test
    void testDelete(){
        CityList cityList = new CityList();

        City city1 = new City("Edmonton","AB");
        City city2 = new City("Calgary","AB");
        //add cities to list
        cityList.add(city1);
        cityList.add(city2);
        //delete city1
        cityList.delete(city1);

        assertFalse(cityList.hasCity(city1)); //check if city1 is in list
        assertTrue(cityList.hasCity(city2)); //check if city2 is in list
        assertThrows(IllegalArgumentException.class, () -> cityList.delete(city1)); //check if deleting city that doesnt exist throws error
    }

    @Test
    void testHasCity(){
        CityList cityList = new CityList();

        City city1 = new City("Edmonton","AB");
        City city2 = new City("Calgary","AB");
        // list is initially empty
        assertFalse(cityList.hasCity(city1));
        //now add city1
        cityList.add(city1);
        //city1 should now exist
        assertTrue(cityList.hasCity(city1));
        //city2 was never added, should not exist
        assertFalse(cityList.hasCity(city2));

    }

    @Test
    void testCountCities(){
        CityList cityList = new CityList();

        City city1 = new City("Edmonton","AB");
        City city2 = new City("Calgary","AB");

        // initially empty
        assertEquals(0, cityList.countCities());

        // add city1
        cityList.add(city1);
        assertEquals(1, cityList.countCities());

        // add city2
        cityList.add(city2);
        assertEquals(2, cityList.countCities());

        // delete city1
        cityList.delete(city1);
        assertEquals(1, cityList.countCities());
    }
}
