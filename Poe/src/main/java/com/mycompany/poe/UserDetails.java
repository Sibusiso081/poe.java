/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poe;

/**
 *
 * @author user
 */
public class UserDetails {
    public final String firstName;
    public final String lastName;
    public final String password;
    
    //method for userdetails
    public UserDetails(String firstName, String lastName, String password){
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
    }
    
    //method to get first name
    public String getFirstName(){
        return firstName;
    }
    //method to get last name
    public String getLastName(){
        return lastName;
    }
    //method to get password
    public String getPassword(){
        return password;
    }
    
    
    
}
