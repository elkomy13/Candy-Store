package Toffe.Toffeestore.Dataentery;
/**

    The Authentication interface provides methods to validate user's email and password.
 */
public interface Authentication {
    /**
     Validates the given password.
     @param Password the password to validate.
     @return true if the password is valid, false otherwise.
     */
    public boolean ValidatePass(String Password);
    /**
     Validates the given email.
     @param Email the email to validate.
     @return true if the email is valid, false otherwise.
     */
    public boolean ValidateEmail(String Email);

}
