package Toffe.Toffeestore.StoreFunctionallity;
/**

 The Products class represents a product in the catalog.
 It contains information such as name, category, description, price, discount, brand, and status.
 */
public class Products {
    /**
    The name of the product.
    */
    public String ProductName;
    /**
     * The category the product belongs to.
     */
    public String Category;
    /**
     * The description of the product.
     */
    public String Description;
    /**
     * The price of the product.
     */
    public double ProductPrice;
    /**
     * The discount of the product.
     */
    public int ProductDiscount;
    /**
     * The brand of the product.
     */
    public String Brand;
    /**
     * The status of the product (in stock, out of stock, etc).
     */
    public StatusType status;
    /**
     Constructs a new product with the given parameters.
     @param productName the name of the product
     @param category the category the product belongs to
     @param description the description of the product
     @param productPrice the price of the product
     @param productDiscount the discount of the product
     @param brand the brand of the product
     @param status the status of the product
     */
    public Products(String productName, String category, String description, double productPrice, int productDiscount, String brand, StatusType status) {
        ProductName = productName;
        Category = category;
        Description = description;
        ProductPrice = productPrice;
        ProductDiscount = productDiscount;
        Brand = brand;
        this.status = status;
    }
}
