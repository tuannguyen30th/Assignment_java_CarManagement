/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment5;

import java.util.Comparator;

/**
 *
 * @author ADMIN
 */
public class BrandNameComparator implements Comparator<Car> {
    public int compare(Car c1, Car c2) {
        return c1.getBrand().getBrandName().compareToIgnoreCase(c2.getBrand().getBrandName());
    }
}