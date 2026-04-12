/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.poe;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author user
 */
public class Poe {
    
    //boolean method to validate checkcellphone 
    public static boolean checkCellPhone(String number){
        String pattern ="^\\+27\\d(9)$";
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(number);
        
        return matcher.matches();
    }
    
    //boolean method validate username
    public static boolean isValidUsername(String username){
        return username.length() <= 5 && username.contains("_");
    }
    
    //boolean method to validate password
    public static boolean isValidPassword(String password){
        return password.length() <= 8 && password.matches(".*[A-Z].*") && password.matches(".*[a-z].*") && password.matches(".*[!@#$%^&*].*") && password.matches(".*[0-9].*");
    }
    
    public static void main(String[]args)
    {
        //user registration
        try (Scanner scanner = new Scanner(System.in)){
            System.out.println("--- User Registration ---");
            String regUsername;
            String regPassword;
            String regCellPhoneNumber;
            String regFirstName;
            String regLastName;
            
            System.out.println("Please enter your first name:");
            regFirstName = scanner.nextLine();
            
            
            System.out.println("Please enter last name: ");
            regLastName = scanner.nextLine();
            
            System.out.println("Please enter username (Max of 5 characters, must contain an underscore): ");
            regUsername = scanner.nextLine();
            while(!isValidUsername(regUsername)){
                System.out.println("Username is not correctly formatted, please ensure that your username contains an underscore and is no more than five characters in length");
                regUsername = scanner.nextLine();
            }
            System.out.println("Username successfully captured.");
            
            System.out.println("Please enter password (Password must contain at least 8 characters, a capital letter, a number, and a special character: ");
            regPassword = scanner.nextLine();
            while(!isValidPassword(regPassword)){
                System.out.println("Passwors not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number,and a special character: ");
                regPassword = scanner.nextLine();
            }
            System.out.println("Please enter a South African phone number (Beginning with the code +27 followed by 9 digits):");
            regCellPhoneNumber = scanner.nextLine();
            
            System.out.println("Cell phone number successfully added. ");
        
            Map<String, UserDetails> userDetailsMap = new HashMap<>(); 
            userDetailsMap.put(regUsername, new UserDetails(regFirstName, regLastName, regPassword));
            
            PoeLogin loginSystem = new PoeLogin(userDetailsMap, 3);
            loginSystem.performLogin();    
        }

          
        
    }  
    
}
