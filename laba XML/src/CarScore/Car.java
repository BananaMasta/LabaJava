package CarScore;

class Car {
   private String cartype;
   private int number;
   private String name;
   private int maxspeed;
   private Price price = new Price();

   public static class Price {
       private Double value;
       private String currency;

       Double getValue() {
           return value;
       }

       void setValue(Double value) {
           this.value = value;
       }

       String getCurrency() {
           return currency;
       }


       void setCurrency(String currency) {
           this.currency = currency;
       }
   }
    public String getCartype() {
        return cartype;
    }

    void setCartype(String cartype) {
        this.cartype = cartype;
    }

    public int getNumber() {
        return number;
    }

    void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    public int getMaxspeed() {
        return maxspeed;
    }

    void setMaxspeed(int maxspeed) {
        this.maxspeed = maxspeed;
    }

    Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    @Override
    public String toString(){
       return "Car(" +
               "cartype='" + cartype + '\'' +
               ", number=" + number +
               ", name=" + name + '\''+
               ",maxspeed=" + maxspeed +
               ", price=" + price.getValue() + " " + price.getCurrency()+
               '}';
    }
}
