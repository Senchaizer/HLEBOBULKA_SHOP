/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;

/**
 *
 * @author user
 */
public class Consumer implements Serializable{
    private String firstName;
    private String lastName;
    private Integer cash;
    
    public Consumer(){
    }

    public Consumer(String firstName, String lastName, Integer cash) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.cash = cash;
    }

    public Integer getCash() {
        return cash;
    }

    public void setCash(Integer cash) {
        this.cash = cash;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Consumer{" 
                + "firstName=" + firstName 
                + ", lastName=" + lastName 
                + ", cash=" + cash 
                + '}';
    }
    
    
}