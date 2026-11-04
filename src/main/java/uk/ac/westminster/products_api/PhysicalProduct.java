package uk.ac.westminster.products_api;
// "A physicalProduct IS-A Product" because it is a Product and
// Product is the whole, without product, physicalProduct wont stay
// shoppingCart is not Is a Product



public class PhysicalProduct extends Product implements Discountable {


    private double discountedPrice;

    private double weightKg;
    private String dimensions;

    //no args constructor for json
    public PhysicalProduct(){

    }

    // full args constructor
    public PhysicalProduct(Long id, String name, double price, double weightKg,  String dimensions){
        super(id,name,price); // for super class

        this.weightKg=weightKg;
        this.dimensions=dimensions;

    }

    public double getWeightKg(){
        return weightKg;
    }

    public String getDimensions(){
        return dimensions;

    }


    @Override
    public String getSummary(){
        return getName()+" Rs." +getPrice()+ " WEIGHT: " + weightKg;
    }


    @Override
    public void applyDiscount(double rate) {
        double capped=Math.min(rate,0.20);
        this.discountedPrice=getPrice()*(1-capped);
    }

    @Override
    public double getDiscountedPrice() {
        return discountedPrice;
    }
}