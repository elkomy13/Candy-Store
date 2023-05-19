package Toffe.Toffeestore.StoreFunctionallity;

import Toffe.Toffeestore.StoreuUsers.Customer;
/**

 The Orders class represents a customer order in the Toffee Store.
 It includes information about the customer, shipping address, payment method, loyalty points, gift voucher,
 total order price and a checkout function.
 */

public class Orders {
    /**
    An integer representing the order number.
    */
    public int Ordernumber;
    /**
    A Customer object representing the customer who placed the order.
     */
    public Customer customer;

    /**
     * Constructor for the Orders class.
     * @param customer
     */
    public Orders( Customer customer) {
        this.customer = customer;
    }
    /**
     A string representing the shipping address of the customer.
     */
    public String ShippingAddress;
    /**
     A Payment object representing the payment method of the customer.
     */
    public Payment Pay=new Payment();
    /**
     An integer representing the loyalty points used for the order.
     */
    public int loyaltyPoints;
    /**
     A GiftVoucher object representing the gift voucher used for the order.
     */
    public GiftVoucher giftvoucher;
    /**
     A double representing the total order price of the order.
     */
    public double TotalOrderPrice=0;
    /**
     An integer representing the loyalty points used for the order.
     */
    public boolean CheckOut(){
        return true;
    };
    /**
     A function that sets the payment method for the order and calculates the total order price.

     @param p a Payment object representing the payment method.
     */

    public void Pay_Method(Payment p){
        Pay = p;
        TotalOrderPrice = 0;

        for ( Products product : customer.cart){
             TotalOrderPrice += product.ProductPrice;
        }
        Pay.TotalPrice(TotalOrderPrice);
        }

    };



