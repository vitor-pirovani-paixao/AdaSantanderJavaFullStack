public class Product {
    private String name;
    private Integer amount;
    private Double priceUnit;

    public Product(String name, Integer amount, Double priceUnit){
        this.name = name;
        if (amount < 0){
            System.out.println(Main.RED+"Amount may not be negative!"+ Main.BLACK);
            System.out.println(Main.RED+"It was automatically set to 0"+ Main.BLACK);
            System.out.println(Main.RED+"Please, use the \"setAmount\" method to correct it.\n"+ Main.BLACK);
            this.amount = 0;
        } else if (priceUnit < 0) {
            this.amount = 0;
        } else{
            this.amount = amount;
        }
        if (priceUnit < 0){
            System.out.println(Main.RED+"Price may not be negative!"+ Main.BLACK);
            System.out.println(Main.RED+"It was automatically set to 0"+ Main.BLACK);
            System.out.println(Main.RED+"Please, use the \"setPriceUnit\" method to change it.\n"+ Main.BLACK);
            this.priceUnit = 0.;
        }else{
            this.priceUnit = priceUnit;
        }

    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAmount() {
        return this.amount;
    }

    public void setAmount(Integer amount) {
        if (amount < 0){
            System.out.println("Amount must be greater than zero!");
            System.out.println("It was automatically set to 1");
            System.out.println("Please, use the \"setAmount\" method to change it as desired.");
        }else{
            this.amount = amount;
        }
    }

    public Double getPriceUnit() {
        return this.priceUnit;
    }

    public void setPriceUnit(Double priceUnit) {
        if (priceUnit < 0){
            System.out.println(Main.RED+"Price may not be negative!"+ Main.BLACK);
            System.out.println(Main.RED+"It was automatically set to 0"+ Main.BLACK);
            System.out.println(Main.RED+"Please, use the \"setPriceUnit\" method to change it.\n"+ Main.BLACK);
            this.priceUnit = 0.;
        }else{
            this.priceUnit = priceUnit;
        }
    }

    public void printProduct(){
        System.out.printf("Name: %s \t Units: %d \t Price (R$/Unit): %.2f \n",
                this.name, this.amount, this.priceUnit);
    }

}
