import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    protected static final String BLACK = "\u001B[30m";
    protected static final String RED = "\u001B[31m";

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        /*
        Some features...

        Inventory estoque = new Inventory();
        // It sets the amount to 0 if the user add a product with a negative price.
        // It also throws a warning message.
        estoque.addProduct(new Product("Smartphone",3,-999.99));
        // It sets both the amount and the price to 0 if the user add a product with a negative amount/unit availability.
        // It also throws a warning message.
        estoque.addProduct(new Product("Microwave\"",-1,399.99));

        Cart carrinho = new Cart();
        // It is able to handle spaces and lowercase letters
        // It also decreases the total amount available in stock as soon as the user add the product to his/her cart
        carrinho.addProduct(estoque.getProductByName("  laptop"),5);
        // It throws a message if any desired product is out of stock
        carrinho.addProduct(estoque.getProductByName("Refrigerator"),6);
        // It suggests the user to add all units if the desired amount is greater that the one in stock
        carrinho.addProduct(estoque.getProductByName("TV 80\""),35);
        // It throws an "out of stock" message for a product whose amount is 0.
        carrinho.addProduct(estoque.getProductByName("microwave"),5);

        */
        Inventory estoque = new Inventory();
        estoque.addProduct(new Product("Smartphone",3,999.99));
        estoque.addProduct(new Product("Microwave",1,399.99));
        estoque.addProduct(new Product("Laptop",5,3859.99));

        Cart carrinho = new Cart();

        Integer option = 0;
        while (option != 3){
             try {
                System.out.println("What do you like to do?");
                System.out.println(""" 
                        1 - Press "1" if you want to add a product to the Cart
                        2 - Press "2" if you want to remove a product from the Cart
                        3 - Press "3" to check out. 
                        """.indent(2));
                option= sc.nextInt();
                sc.nextLine();
                if (option==1){
                    estoque.printAllProducts();
                    if (estoque.size()<=1){
                        System.out.println("We are sorry, but all products are sold out.\n");
                    }else {
                        System.out.println("Choose one of the products in our inventory by typing its name:");
                        String productName = sc.nextLine();
                        Integer productUnits;
                        System.out.printf("How many %s would you like to add? Type the number bellow\n",productName);
                        while (true){
                            try {
                                productUnits=sc.nextInt();
                                break;
                            }catch (Exception e){
                                System.out.println("You have to type a number to proceed. Try again, please.");
                                sc.next();
                            }
                        }
                        carrinho.addProduct(estoque.getProductByName(productName),productUnits);
                    }
                } else if (option==2) {
                    if (carrinho.size()<=1){
                        System.out.println("Cart is empty.");
                    }else {
                        carrinho.printCartSummary();
                        System.out.println("Type the name of the product that you want to remove from the Cart:");
                        String productName = sc.nextLine();
                        estoque.addProduct(carrinho.deleteProductByName(productName));
                    }
                } else if (option == 3) {
                    carrinho.printCartSummary();
                    System.out.println("Thank you!");
                }
            }catch (InputMismatchException e){
                System.out.println("Invalid option. Please, try again.");
                sc.next();
            }catch (Exception e){
                 System.out.println(RED+"FATAL ERROR"+BLACK);
                 break;
             }
        }
        sc.close();

    }
}
