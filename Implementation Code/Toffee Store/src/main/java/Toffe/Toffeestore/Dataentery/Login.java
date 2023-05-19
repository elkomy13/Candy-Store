package Toffe.Toffeestore.Dataentery;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
/**

 This class represents a Login object that implements the Authentication interface and extends the User class.
 It provides methods to set and get the email and password of a user, as well as validate the email and password.
 The class reads a text file containing user information and compares the input email and password with the ones in the file.
 */

public class Login extends User implements Authentication {

    /**
     * Sets the password of the user.
     * @param password the password to set.
     */
    public void setPassword(String password) {
        Password = password;
    }

    /**
     * Sets the email of the user.
     * @param email the email to set.
     */
    public void setEmail(String email) {
        Email = email;
    }

    /**
     * Gets the password of the user.
     * @return the password of the user.
     */
    public String getPassword() {
        return Password;
    }

    /**
     * Gets the email of the user.
     * @return the email of the user.
     */
    public String getEmail() {
        return Email;
    }

    /**
     * Validates the input password by comparing it with the passwords in the file.
     * @param inputPassword the password to validate.
     * @return true if the password is valid, false otherwise.
     */
    @Override
    public boolean ValidatePass(String inputPassword) {
        try {
            FileReader reader = new FileReader("elkomy.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);

            String line = bufferedReader.readLine();
            while (line != null) {
                String[] fields = line.split(",");
                if (fields[2].equals(inputPassword) ) {
                    bufferedReader.close();
                    return true;
                }
                line = bufferedReader.readLine();
            }

            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }

        return false;
    }

    /**
     * Validates the input email by comparing it with the emails in the file.
     * @param inputEmail the email to validate.
     * @return true if the email is valid, false otherwise.
     */
    @Override
    public boolean ValidateEmail(String inputEmail) {
        try {
            FileReader reader = new FileReader("elkomy.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);

            String line = bufferedReader.readLine();
            while (line != null) {
                String[] fields = line.split(",");
                if (fields[0].equals(inputEmail)) {
                    bufferedReader.close();
                    return true;
                }
                line = bufferedReader.readLine();
            }
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }

        return false;
    }


}
