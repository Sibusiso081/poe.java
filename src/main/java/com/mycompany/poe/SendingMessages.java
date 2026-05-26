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



public class SendingMessages {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        
        System.out.println("Welcome to Quickchat");
        
        System.out.print("Enter number of messages you want to send:");
        int numMessages = input.nextInt();
        input.nextLine();
        
        int choice = 0;
        
        while (choice != 3) {
            
            System.out.print("\nChoose an option");
            System.out.println("1. Send Messages");
            System.out.println("2. Show recently sent messages");
            System.out.println("3. Quit");
            
            System.out.print("Enter option: ");
            choice = input.nextInt();
            input.nextLine();
            
            if (choice == 1) {
                
                for (int i = 0; i < numMessages; i++) {
                    
                    System.out.println("\nMessage " + (i + 1));
                    
                    System.out.print("Enter recipient number: ");
                    String recipient = input.nextLine();
                    
                    if (checkRecipientCell(recipient)) {
                        System.out.println("Cell phone number capturedsuccessfully.");
                    } else {
                        System.out.println("Cell phone number is incorrectly formatted.");
                        continue;
                    }
                    
                    System.out.print("Enter your message: ");
                    String message = input.nextLine();
                    
                    if (message.length() > 250) {
                        System.out.println("Please enter a message of less than 250 characters.");
                    } else {
                        
                        String messageID = createMessageID();
                        
                        String hash = createMessageHash(messageID, i, message);
                        
                        System.out.println("Message sent");
                        System.out.println("Message ID: " + messageID);
                        System.out.println("Message Hash: " + hash);
                        
                       int totalMessages = 0;
                    }
                }
            } else if (choice == 2) {
                
                System.out.println("Coming Soon.");
                
            } else if (choice == 3) {
                
                System.out.println("Goodbye.");
            
            } else {
                
                System.out.println("Invalid option.");
            }
            
        }
        String totalMessages;
        
        System.out.println("Total messages sent: " + totalMessages);
    }
    
    
    public static boolean checkRecipientCell(String number) {
        
        if (number.startsWith("+27") && number.length() <=12) {
            return true;
        } else {
            return false;
        }
    }
    
    
    public static String createMessageID() {
        
        long number = (long)(Math.random() * 10000000000L);
        
        String id = String.valueOf(number);
        
        while (id.length() < 10) {
            id = "0" + id;
        }
        
        return id;
        
    }
    
    
    public static String createMessageHash(String id, int messageNum, String message) {
        
        String[] words = message.split(" ");
        
        String firstWord = words[0].toUpperCase();
        
        String lastWord = words[words.length - 1].toUpperCase();
        
        String hash = id.substring(0, 2) + ":" + messageNum + ":" + firstWord + lastWord;
        
        return hash;
    }
}

