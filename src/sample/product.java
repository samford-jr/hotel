package sample;

public class product {
    public String Name;
    public double Price;
    public int Quantity;
    public int Purchaser_id;

   /* public product(){
        this.name="";
        this.quantity=0;
        this.price=0;
        this.purchaser_id=0;
    }*/
    public product(String  name,int quantity,double price,int purchaser_id){
        this.Name=name;
        this.Quantity=quantity;
        this.Price=price;
        this.Purchaser_id=purchaser_id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        this.Price = price;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        this.Quantity = quantity;
    }

    public int getPurchaser_id() {
        return Purchaser_id;
    }

    public void setPurchaser_id(int purchaser_id) {
        this.Purchaser_id = purchaser_id;
    }
}
