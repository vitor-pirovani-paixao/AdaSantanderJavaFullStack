import java.util.ArrayList;
import java.util.Scanner;

public class Cart {
    ArrayList<Product> cart;
    private final Product DefaultProduct = new Product("DefaultProduct",1,0.);
    private Scanner sc = new Scanner(System.in);
    public Cart(){
        this.cart = new ArrayList<>(0);
        this.cart.add(DefaultProduct);
    }
    public Integer size(){
        return this.cart.size();
    }
    public void addProduct(Product product, Integer amountToAdd){
        if (!product.getName().equals(DefaultProduct.getName())&& amountToAdd>0){
            if (product.getAmount()>=amountToAdd){
                boolean ProductFound=false;
                for (int i = 0; i < this.cart.size(); i++) {
                    ProductFound= this.cart.get(i).getName().equalsIgnoreCase(product.getName());
                    if (ProductFound){
                        this.cart.get(i).setAmount(this.cart.get(i).getAmount()+amountToAdd);
                        product.setAmount(product.getAmount()-amountToAdd);
                        break;
                    }
                }
                if (!ProductFound){
                    Product productToCart = new Product(product.getName(),amountToAdd, product.getPriceUnit());
                    product.setAmount(product.getAmount()-amountToAdd);
                    this.cart.add(productToCart);
                }
            }else if (product.getAmount()>0){
                System.out.printf("We are sorry, but we only have %d %s(s) available\n",product.getAmount(),product.getName());
                System.out.println("Would you like to add them? Yes or No\n");
                String choice;
                choice = sc.nextLine().trim().toLowerCase();
                if (choice.equals("yes")){
                    Product productToCart = new Product(product.getName(),product.getAmount(), product.getPriceUnit());
                    product.setAmount(0);
                    this.cart.add(productToCart);
                }else {
                    System.out.printf("%s was not added into your cart\n",product.getName());
                }
            }else {
                System.out.printf("We are sorry, but %s is currently out of stock\n", product.getName());
            }
        }else {
            System.out.println("Number of units to be added must be greater than 0!");
            System.out.printf("%s was not added into your Cart\n", product.getName());
        }
    }

    public Product deleteProductByName(String name){
        boolean ProductFound = false;
        Product productToInventory=DefaultProduct;
        for (int i = 0; i < this.cart.size(); i++) {
            ProductFound= this.cart.get(i).getName().trim().toLowerCase().equals(name.trim().toLowerCase());
            if (ProductFound){
                System.out.printf("%s was successfully removed from your cart\n",this.cart.get(i).getName());
                productToInventory=this.cart.get(i);
                this.cart.remove(i);
                return productToInventory;
            }
        }
        if (!ProductFound){
            System.out.printf("We are sorry, but %s was not found in your cart.\n\n", name);
            return productToInventory;
        }
        return productToInventory;
    }

    public Product getProductByName(String name){
        boolean ProductFound;
        for (int i = 0; i < this.cart.size(); i++) {
            ProductFound= this.cart.get(i).getName().trim().toLowerCase().equals(name.trim().toLowerCase());
            if (ProductFound){
                return this.cart.get(i);
            }
        }
        System.out.printf("We are sorry, but %s was not found in your cart.\n\n", name);
        return DefaultProduct;
    }

    public void printCartSummary(){
        for (int i = 0; i < this.cart.size(); i++) {
            if (!this.cart.get(i).getName().equals(DefaultProduct.getName())){
                if (this.cart.get(i).getAmount() == 0) {
                    this.cart.remove(i);
                    i--;
                }
            }
        }
        Double Total = 0.;
        System.out.println("---------------------- CART SUMMARY----------------------");
        for (int i = 0; i < this.cart.size(); i++) {
            if (!this.cart.get(i).getName().equals(DefaultProduct.getName())){
                if (this.cart.size() > 1){
                    this.cart.get(i).printProduct();
                    Total+=this.cart.get(i).getPriceUnit()*this.cart.get(i).getAmount();
                }else {
                    System.out.println("\tThe cart is empty");
                }
            } else if (!(this.cart.size() > 1)) {
                System.out.println("\tThe cart is empty");
            }
        }
        if (this.cart.size() > 1){
            System.out.println("---------------------------------------------------------");
            System.out.printf("Total: R$ %.2f\n", Total);
        }
        System.out.println("---------------------------------------------------------\n");
    }
}
