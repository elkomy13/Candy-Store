package Toffe.Toffeestore.StoreuUsers;

import Toffe.Toffeestore.StoreFunctionallity.Catalog;

/**

 The Admin class represents an administrator of the product catalog.

 It extends the Catalog class.
 */
public class Admin extends Catalog {
    /**

     The ID of the admin.
     */
    public int ID;
    /**

     The password of the admin.
     */
    public char PASSWORD;
    /**

     Attempts to log in the admin.
     @param id The ID to be checked.
     @param password The password to be checked.
     */
    public void Admlogin(int id, char password){
        if(id == ID && password == PASSWORD)
        {
            System.out.println("Login Successful");
        }
        else
        {
            System.out.println("Login Failed");
        }

    };
    /**

     Allows the admin to edit products.
     */

    public void EditProducts()
    {
        System.out.println("Edit Products");
    };
    /**

     Allows the admin to add products.
     */
    public void AddProduct(){
        System.out.println("Add Products");
    };
    /**

     Allows the admin to delete products.
     */
    public void DeleteProduct(){
        System.out.println("Delete Products");
    };

}
