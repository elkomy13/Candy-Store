package Toffe.Toffeestore;
import Toffe.Toffeestore.Dataentery.GEmailSender;
import Toffe.Toffeestore.Dataentery.Login;
import Toffe.Toffeestore.Dataentery.Registration;
import Toffe.Toffeestore.StoreFunctionallity.Catalog;
import Toffe.Toffeestore.StoreFunctionallity.Orders;
import Toffe.Toffeestore.StoreFunctionallity.Payment;
import Toffe.Toffeestore.StoreuUsers.Customer;

import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class ShopSystem {
    /**
     * This class is the main class of the project
     * it contains the main method
     * it contains the objects of the other classes
     * it contains the run method which is the main method of the project
     */

    private Registration reg;
    private GEmailSender emailSender;
    private Login log;
    private Catalog catalog;
    private Customer cust;
    private Orders ord;
    private Payment pay;
    //default constructor
    /**
     * This is the default constructor of the class
     * it initializes the objects of the other classes
     */
    public ShopSystem() {
        reg = new Registration();
        emailSender = new GEmailSender();
        log = new Login();
        catalog = new Catalog();
        cust = new Customer();
        ord = new Orders(cust);
        pay = new Payment();
    }

    /**
     * This method is the main method of the project
     * @throws IOException
     */
    public void run() throws IOException {
        int flag2=0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome To Our TOFFEE Store ");
        System.out.println("1-Register");
        System.out.println("2-Login");
        System.out.println("3-Exit");
        int choice=scanner.nextInt();
        switch (choice)
        {
            case 1:
                System.out.print("Enter email: ");
                String email = scanner.next();

                GEmailSender emailSender = new GEmailSender();
                String otp= GEmailSender.generateOTP() ;
                boolean b=emailSender.sendEmail(email,"ziadeliwa93@gmail.com","OTP Verification","Your OTP is "+otp);
                if(b)
                {
                    System.out.println("OTP sent successfully");
                }
                else
                {
                    System.out.println("OTP not sent");
                }

                System.out.println("Enter OTP: ");
                String otpentered=scanner.next();
                if(otpentered.equals(otp))
                {
                    System.out.println("OTP verified successfully");
                }
                else
                {
                    System.out.println("OTP not verified");
                    flag2=1;
                }

                if(flag2==0) {
                    System.out.print("Enter name: ");
                    String name = scanner.next();
                    System.out.print("Enter password: ");
                    String password = scanner.next();
                    System.out.print("Enter confirm password: ");
                    String confirmPassword = scanner.next();
                    boolean flag = true;
                    while (flag) {
                        if (Objects.equals(confirmPassword, password)) {
                            flag = false;

                        } else {
                            System.out.print("Doesn't match please Enter confirm password again: ");
                            confirmPassword = scanner.next();
                        }
                    }
                    System.out.print("Enter mobile number: ");
                    String mobileNum = scanner.next();
                    System.out.print("Enter address: ");
                    String address = scanner.next();
                    Registration reg = new Registration(email, name, password, confirmPassword, mobileNum, address);

                    if (reg.Emailregex(email) && reg.Passregex(password) && reg.Passregex(confirmPassword) && reg.MobileNumregex(mobileNum)) {
                        if (reg.checkEmailDuplicate(email)) {
                            System.out.println("Registration Successfully!");
                            reg.saveToFile("elkomy.txt");
                        } else
                            System.out.println("This email is already exist,please try again");


                    } else
                        System.out.println("Check the regex of the email or pass or mobile number,please");

                    scanner.close();
                }
                break;
            case 2:
                Login log=new Login();
                System.out.println("Enter your Email :");
                String Email=scanner.next();
                log.setEmail(Email);
                System.out.println("Enter your Password :");
                String pass=scanner.next();
                log.setPassword(pass);
                if(log.ValidatePass(pass) && log.ValidateEmail(Email)){
                    System.out.println("Login successfully!");
                    System.out.println("1-Display Catalog");
                    System.out.println("2-Make Shopping and Add to cart");
                    System.out.println("3-Logout");
                    int choice2=scanner.nextInt();
                    switch (choice2)
                    {
                        case 1:
                            System.out.println("1-Display Catalog");
                            Catalog cat=new Catalog();
                            cat.DisplayCatalog();
                            break;
                        case 2:
                            Customer cust=new Customer();
                            cust.ViewCatalog();
                            cust.AddToCart();
                            System.out.println("Press 1 to View Your Cart");
                            System.out.println("Press 2 place order");
                            int choice3=scanner.nextInt();
                            if(choice3==1)
                            {
                                cust.ViewCart();
                                System.out.println("Do you want to place your order?");
                                System.out.println("1-Yes");
                                System.out.println("2-No");
                                int c=scanner.nextInt();
                                if(c == 1)
                                {
                                    System.out.println("1- Cash on delivery");
                                    System.out.println("2- Credit Card / loyalty points");
                                    System.out.println("3-Gift vouchers");
                                    int choice4=scanner.nextInt();
                                    switch (choice4)
                                    {
                                        case 1:
                                            Orders ord=new Orders(cust);
                                            Payment pay=new Payment();
                                            ord.Pay_Method(pay);
                                            break;
                                        case 2:
                                            System.out.println("Loyalty points / Credit Card method is now inactive.");
                                            break;
                                        case 3:
                                            System.out.println("Gift Voucher method in unavailable right now.");
                                            break;
                                        case 4:
                                            break;
                                    }
                                }
                                else if(c == 2)
                                    System.out.println("Thank you for visiting our store.");


                                else
                                    System.out.println("Invalid choice");
                                break;
                            }

                            else if (choice3==2)
                            {
                                System.out.println("1- Cash on delivery");
                                System.out.println("2- Credit Card / loyalty points");
                                System.out.println("3-Gift vouchers");
                                int choice4=scanner.nextInt();
                                switch (choice4)
                                {
                                    case 1:
                                        Orders ord=new Orders(cust);
                                        Payment pay=new Payment();
                                        ord.Pay_Method(pay);
                                        break;
                                    case 2:
                                        System.out.println("Loyalty points / Credit Card method is now inactive.");
                                        break;
                                    case 3:
                                        System.out.println("Gift Voucher method in unavailable right now.");
                                        break;

                                }
                            }
                        case 3:
                            System.out.println("Logging-out successfully ");
                            break;
                    }

                }
                else
                    System.out.println("Incorrect email or password.");
                scanner.nextLine();//This method reads the entire line of input
                break;
            case 3:
                System.out.println("Thank you for visiting our store.");
                break;
        }
    }

}