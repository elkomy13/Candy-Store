package Toffe.Toffeestore.StoreuUsers;

import Toffe.Toffeestore.StoreFunctionallity.Catalog;
import Toffe.Toffeestore.StoreFunctionallity.Products;
import Toffe.Toffeestore.StoreFunctionallity.StatusType;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**

 The Customer class represents a customer who can search, view, add products to their cart, and check out.

 It extends the Catalog class to access the list of available products.
 */
public class Customer extends Catalog {
    /**
     The name of the customer.
     */
    public String Name;
    /**
     The address of the customer.
     */
    public String Address;
    /**
     The phone number of the customer.
     */
    public int PhoneNum;
    /**
     Scanner object used for input from user.
     */
    Scanner scanner = new Scanner(System.in);
    /**
     The list of products in the customer's cart.
     */
    public List<Products>  cart= new ArrayList<Products>();
    /**

     Searches for a product by name in the list of available products.
     @param ProdName the name of the product to search for.
     @return true if the product is found, false otherwise.
     */
    public boolean searchProducts(String ProdName){
        for (Products product : Product){
            if(product.ProductName.equals(ProdName)){
                return true;
            }
        }
        return false;
    }
    /**

     Checks if a product is in stock or out of stock.
     @param productName the name of the product to check.
     @return true if the product is in stock, false if it is out of stock.
     */
    public boolean checkStatus(String productName) {
        for (Products product : Product) {
            if (product.ProductName.equals(productName)){
                return product.status.equals(StatusType.INstock);
            }
        }
        return false;
    }
    /**

     Displays the list of available products in the catalog.
     */

    public void ViewCatalog(){

        DisplayCatalog();
    }
    /**

     Adds products to the customer's cart.
     */
public void AddToCart(){
    Scanner scanner = new Scanner(System.in);
    boolean keepAdding = true;
    while (keepAdding) {
        System.out.println("Enter the product name you want to add to cart.");
        String ProdName = scanner.next();
        if (searchProducts(ProdName)) {
            for (Products product : Product) {
                if(product.ProductName.equals(ProdName)){
                    if (checkStatus(ProdName))
                    {
                        cart.add(product);
                        System.out.println("Product added to cart successfully");
                    }
                    else
                        System.out.println("Sorry , Product is out of stock");

                }
            }
        }
        else
            System.out.println("Product not found");
        // Ask the user if they want to add more products to the cart
        System.out.println("Do you want to add more products to the cart? (Y/N)");
        String answer = scanner.next();
        if(answer.equals("Y"))
            keepAdding = true;
         else if (answer.equals("N"))
            keepAdding = false;
         else
         {
            System.out.println("Invalid input. Please enter Y or N.");
            keepAdding = false;
        }
    }
}

    /**

     Displays the products in the customer's cart.
     */
    public void ViewCart(){
        if (cart.isEmpty()) {
            System.out.println("Your cart is empty.");
        }
        else
        {
            System.out.println("Your cart contains the following products:");
            String header = String.format("%-30s%-20s%-40s%-20s%-20s%-20s%s",
                    "Product Name", "Category", "Description", "Price", "Discount", "Brand", "Status");
            System.out.println(header);
            System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            for (Products product : cart) {
                String productInfo = String.format("%-30s%-20s%-40s%-20s%-20s%-20s%s",
                        product.ProductName, product.Category, product.Description, product.ProductPrice, product.ProductDiscount, product.Brand, product.status);
                System.out.println(productInfo);

            }
            System.out.println("");
        }
    }
    /**

     Checkout functions that Pay the price of the products in the cart.
     */
    public void CheckOut(){};
    /**

     Verifies the customer's email address.
     @param Email the email address to verify.
     */
    public void EmailVerify(char Email){};
}
