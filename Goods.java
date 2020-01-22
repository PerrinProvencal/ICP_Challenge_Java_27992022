
/**
 * @author Perrin Nii Obodai Provencal
 *
 */
public class Goods {
    String name;
    float price;
    int quantity;


    /**
     *
     * @param name
     * @param price
     * @param quantity
     */

    public Goods(String name, float price, int quantity){

        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
    // Creation of getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
