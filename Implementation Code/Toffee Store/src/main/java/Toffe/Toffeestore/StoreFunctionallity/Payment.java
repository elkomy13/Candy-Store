package Toffe.Toffeestore.StoreFunctionallity;

import java.util.Scanner;

/**

 The Payment class represents a payment method for an order.
 It contains information such as shipping address and card number for payment.
 */
public class Payment {
    /**
    The shipping address for the order.
    */
    public String ShippingAddress;
    /**
    The card number for payment.
    */
    public int CardNumber;
    /**
    Scanner object used for input from user.
    */
    Scanner scanner = new Scanner(System.in);
    /**
     Method to perform payment for an order.
     @param o the order to be paid for.
     */
    public void Pay(Orders o){};
    /**
     Method to redeem loyalty points.
     */
    public void RedeemLoyaltyPoints(){};
    /**
     Method to redeem gift voucher.
     */
    public void RedeemGiftVoucher(){};
    /**
     Method to calculate total price of an order and prompt for shipping address.
     @param total the total order price.
     */
    public void TotalPrice(double total){
        if(total==0)
        {
            System.out.println("Your cart is empty");
            return;
        }
        else {
            System.out.println("Total Price is : " + total);
            System.out.println("Enter the Shipping Address");
            ShippingAddress = scanner.next();
            System.out.println("Your order will be shipped to " + ShippingAddress + " You will be charged 5$ for shipping" + " so the Total order price is " + (total + 5) + "$");
            System.out.println("You must pay on cash on delivery.");
            System.out.println("Thank you for shopping with us.");
        }
    };
    /**
     Method to confirm the shipping address entered.
     @param Shipadd the shipping address to be confirmed.
     @return true if the shipping address is confirmed, false otherwise.
     */
    public boolean confirmAddress(String Shipadd)
    {
        Shipadd = ShippingAddress;
        return true;
    };
    /**
     Method to verify the card number entered.
     @param Cardnum the card number to be verified.
     @return true if the card number is valid, false otherwise.
     */
    public boolean VerifyCardNum(int Cardnum)
    {
        Cardnum = CardNumber;
        return true;
    };


}
