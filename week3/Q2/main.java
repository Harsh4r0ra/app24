import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        
        // Adding initial products to the cart
        cart.addProduct(new Product("Product 1", 10.99, 2));
        cart.addProduct(new Product("Product 2", 5.99, 3));
        cart.addProduct(new Product("Product 3", 7.99, 1));

        // Removing a product from the cart
        cart.removeProduct(new Product("Product 2", 5.99, 3));

        // Display total price before user input
        System.out.println("Total Price: $" + cart.calculateTotal());

        // Take user input to add a new product
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter product name: ");
        String name = scanner.nextLine();

        System.out.print("Enter product price: ");
        double price = scanner.nextDouble();

        System.out.print("Enter product quantity: ");
        int quantity = scanner.nextInt();

        cart.addProduct(new Product(name, price, quantity));

        // Display updated total price
        System.out.println("Updated Total Price: $" + cart.calculateTotal());
    }
}

class Product {
    private String name;
    private double price;
    private int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Product product = (Product) obj;
        return Double.compare(product.price, price) == 0 &&
               quantity == product.quantity &&
               name.equals(product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, quantity);
    }
}

class ShoppingCart {
    private ArrayList<Product> items = new ArrayList<>();

    public void addProduct(Product product) { items.add(product); }
    public void removeProduct(Product product) { items.remove(product); }
    public double calculateTotal() {
        return items.stream()
                    .mapToDouble(p -> p.getPrice() * p.getQuantity())
                    .sum();
    }
}
