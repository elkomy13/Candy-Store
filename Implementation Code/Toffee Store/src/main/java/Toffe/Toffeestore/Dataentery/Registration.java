package Toffe.Toffeestore.Dataentery;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**

 The Registration class extends the User class and represents a user registration object.
 */
public class Registration extends User {
    /** The name of the user */
    public String Name;

    /** The confirmation password of the user */
    public String ConfirmPassword;

    /** The mobile number of the user */
    public String MobileNum;

    /** The address of the user */
    public String Address;
    /**
     Default constructor for the Registration class.
     */

    public Registration() {};

    /**

     Constructor for the Registration class.
     @param email The email of the user.
     @param name The name of the user.
     @param password The password of the user.
     @param confirmPassword The confirmation password of the user.
     @param mobileNum The mobile number of the user.
     @param address The address of the user.
     */

    public Registration(String email, String name, String password, String confirmPassword, String mobileNum, String address) {
        Email = email;
        Name = name;
        Password = password;
        ConfirmPassword = confirmPassword;
        MobileNum = mobileNum;
        Address = address;
    }
    /**
     Validates the input email based on a regular expression.
     @param inputEmail The email to be validated.
     @return True if the email is valid, false otherwise.
     */
    public boolean Emailregex(String inputEmail) {
        String regex = "^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(inputEmail);
        return matcher.matches();
    }
    /**
     Validates the input password based on a regular expression.
     @param inputPass The password to be validated.
     @return True if the password is valid, false otherwise.
     */
    public boolean Passregex(String inputPass) {
        String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(inputPass);
        return matcher.matches();
    }

    /**

        Saves user registration data to a file.
        @param filename The name of the file to save to.
    */
    public void saveToFile(String filename) {
        try {
            FileWriter writer = new FileWriter(filename, true); // true flag to append data to file
            writer.write(Email + "," + Name + "," + Password + "," + ConfirmPassword + "," + MobileNum + "," + Address + "\n");
            writer.close();
            System.out.println("Data written to file " + filename + " successfully!");
        }
        catch (IOException e)
        {
            System.out.println("An error occurred while writing to file " + filename);
            e.printStackTrace();
        }
    }
    /**

     Checks if a given email already exists in the user database file.

     @param inputEmail The email to check for duplicates.

     @return True if the email is unique, false otherwise.

     @throws IOException If there was an error reading the user database file.
     */
    public Boolean checkEmailDuplicate(String inputEmail) throws IOException
    {
        try (FileReader reader = new FileReader("elkomy.txt");
             BufferedReader bufferedReader = new BufferedReader(reader)) {

            String line = bufferedReader.readLine();
            while (line != null) {
                String[] fields = line.split(",");
                if (fields[0].equals(inputEmail)) {
                    return false;
                }
                line = bufferedReader.readLine();
            }
            return true;
        }

    }

    /**
     *
     * @param inputMobileNum
     * @return
     */

    public boolean MobileNumregex(String inputMobileNum)
    {
        String regex = "^01[0-9]{9}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(inputMobileNum);
        return matcher.matches();
    }
}
