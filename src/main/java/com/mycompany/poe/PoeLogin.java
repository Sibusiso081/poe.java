/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poe;

import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author user
 */
public class PoeLogin {
    
    private final Map<String, UserDetails> userDetailsMap;
    private int loginAttempts;
    private final int maxLoginAttempts;
    
    public PoeLogin(Map<String, UserDetails> userDetailsMap, int maxAttempts){
        this.userDetailsMap = userDetailsMap;
        this.maxLoginAttempts = maxAttempts;
        this.loginAttempts = 0;
    }
    //boolean method for login
    public boolean login(String username, String password){
        return userDetailsMap.containsKey(username) && userDetailsMap.get(username).getPassword().equals(password);
    }
     
    public void performLogin(){
        
        try(Scanner scanner = new Scanner(System.in)){
            
            System.out.println("\n---Login---");
            
            while(loginAttempts < maxLoginAttempts){
                System.out.println("Enter your name: ");
                String loginUsername = scanner.nextLine();
                System.out.println("Enter your password: ");
                String loginPassword = scanner.nextLine();
                
                
                loginAttempts++;  
                
                if(login(loginUsername, loginPassword)){
                    UserDetails loggedInUser = userDetailsMap.get(loginUsername);
                    System.out.println("Login Successful");
                    System.out.println("Welcome " + loggedInUser.getFirstName() + " " + loggedInUser.getLastName() + "it is great see you again");
                    break; 
                }else{
                    if(loginAttempts < maxLoginAttempts){
                        System.out.println("Username or password Incorect, Please Try Again");
                        System.out.println("You have " + (maxLoginAttempts - loginAttempts) + " attempts remaining");
                        
                    }else{
                        System.out.println("Login failed. You have exeeded the maximum number of login attempts. ");
                    }
                } 
            }     
        } 
    }  
}
