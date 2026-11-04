package uk.ac.westminster.products_api;

public class DigitalProduct extends Product implements Discountable {
    private String downloadUrl; // private can access within same class
    private double fileSizeMB;


    // no args constructor for JACSON
    public DigitalProduct(){}



    public DigitalProduct(Long id, String name, double price,String downloadUrl, double fileSizeMB
    ){
        super(id,name,price);
        this.downloadUrl=downloadUrl;
        this.fileSizeMB=fileSizeMB;

    }

    public String getDownloadUrl(){
        return downloadUrl;
    }
    public double getFileSizeMB(){
        return fileSizeMB;
    }

    @Override
    public String getSummary(){
        return getName() + " Rs." + getPrice() + " Download: " + downloadUrl;

    }

    private double discountedPrice;

    @Override
    public void applyDiscount(double rate) {
        discountedPrice=getPrice() *(1-rate);

    }

    @Override
    public double getDiscountedPrice() {
        return discountedPrice;
    }

    // summary eke download url eka awena override ain kraama plus s simple kalama

}
