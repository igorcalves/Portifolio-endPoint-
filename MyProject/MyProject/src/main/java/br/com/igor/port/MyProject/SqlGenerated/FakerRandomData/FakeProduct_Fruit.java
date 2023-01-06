package br.com.igor.port.MyProject.SqlGenerated.FakerRandomData;

import java.text.DecimalFormat;
import java.util.Random;

import net.datafaker.Faker;

public class FakeProduct_Fruit {

    private String name;

    private Double price;

    private  Long category_id ;
    
    
    private static Faker faker = new Faker();
    private static Random random = new Random();
    private static DecimalFormat df = new DecimalFormat("####0.00");   
    
    

    private  void fruitName(){
        name = faker.food().fruit();
    }

    private void  priceFruit(){
       // price = random.nextDouble(1,5);
//       df.setMinimumFractionDigits(2);
        price = Double.parseDouble(df.format(random.nextDouble(1,5)).replace(",", "."));
    }

    public String atomicCreateFoodTable(){
        String t;
        fruitName();
        priceFruit();
        this.category_id = 3L;

        t = "INSERT INTO TB_PRODUCT (NAME, PRICE, CATEGORY_ID) VALUES ('"+name + "', " + price
        + ", " + category_id + ");";
        return t ;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getCategory_id() {
        return category_id;
    }

    
}
