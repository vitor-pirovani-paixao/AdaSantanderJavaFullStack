import java.util.ArrayList;

public class Inventory {

    private ArrayList<Product> inventory;
    private final Product DefaultProduct = new Product("DefaultProduct",1,0.);

    public Inventory(){
        this.inventory= new ArrayList<Product>(0);
        this.inventory.add(DefaultProduct);
    }
    public Integer size(){
        return this.inventory.size();
    }

    public void addProduct(Product product){
        boolean ProductFound=false;
        for (int i = 0; i < this.inventory.size(); i++) {
            ProductFound= this.inventory.get(i).getName().trim().equalsIgnoreCase(product.getName().trim());
            if (ProductFound){
                this.inventory.get(i).setAmount(this.inventory.get(i).getAmount()+ product.getAmount());
                break;
            }
        }
        if (!ProductFound){
            this.inventory.add(product);
        }
    }

    public Product getProductByName(String name){
        boolean ProductFound;
        for (int i = 0; i < this.inventory.size(); i++) {
           ProductFound= this.inventory.get(i).getName().trim().equalsIgnoreCase(name.trim());
           if (ProductFound){
               return this.inventory.get(i);
           }
        }
        System.out.printf("We are sorry, but %s is currently out of stock\n\n", name);
        return DefaultProduct;
    }

    public void printAllProducts(){
        for (int i = 0; i < this.inventory.size(); i++) {
            if (!this.inventory.get(i).getName().equals(DefaultProduct.getName())){
                if (this.inventory.get(i).getAmount() == 0) {
                    this.inventory.remove(i);
                    i--;
                }
            }
        }
        System.out.println("-------------------- INVENTORY SUMMARY-------------------");
        for (int i = 0; i < this.inventory.size(); i++) {
            if (!this.inventory.get(i).getName().equals(DefaultProduct.getName())){
                if (this.inventory.size() > 1){
                    this.inventory.get(i).printProduct();
                }else {
                    System.out.println("\tThe inventory is empty");
                }
            } else if (!(this.inventory.size() > 1)) {
                System.out.println("\tThe inventory is empty");
            }
        }
        System.out.println("---------------------------------------------------------\n");
    }

    public void deleteProductByName(String name){
        boolean ProductFound = false;
        for (int i = 0; i < this.inventory.size(); i++) {
            ProductFound= this.inventory.get(i).getName().trim().toLowerCase().equals(name.trim().toLowerCase());
            if (ProductFound){
                this.inventory.remove(i);
                break;
            }
        }
        if (!ProductFound){
            System.out.printf("We are sorry, but %s was not found in your inventory.\n\n", name);
        }
    }
}
