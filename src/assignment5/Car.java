package assignment5;


    public class Car {
    String carID, color, frameID, engineID;
    Brand brand = new Brand();
    public Car() {
    }
    public Car(String carID, Brand brand, String color, String frameID, String engineID) {
        this.carID = carID;
        this.brand = brand;
        this.color = color;
        this.frameID = frameID;
        this.engineID = engineID;
    }
    public String getCarID() {
        return carID;
    }
    public void setCarID(String carID) {
        this.carID = carID;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public String getFrameID() {
        return frameID;
    }
    public void setFrameID(String frameID) {
        this.frameID = frameID;
    }
    public String getEngineID() {
        return engineID;
    }
    public void setEngineID(String engineID) {
        this.engineID = engineID;
    }
    public Brand getBrand() {
        return brand;
    }
    public void setBrand(Brand brand) {
        this.brand = brand;
    }
    public String toString() {
        return carID + ", " + brand.getBrandID() + ", " + color + ", " + frameID + ", " + engineID;
    }
    public String stString() {
        return brand + "\n" + carID + ", " + color + ", " + frameID + ", " + engineID;
    }
    public String sString(){
        return carID + ", " + color + ", " + frameID + ", " + engineID;
    }
    public String stf7String(){
        return "- " + brand + "\n" + carID + ", " + brand.getBrandID() + ", " + color + ", " + frameID + ", " + engineID;
    }
    }