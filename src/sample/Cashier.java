package sample;

//import sun.util.calendar.LocalGregorianCalendar;

import java.sql.Date;

public class Cashier {
    public int Order_id;
    public Date Date = new Date(new java.util.Date().getTime());
    public double Price;

    public Cashier(int Order_id, java.sql.Date Date, double Price){
        this.Order_id=Order_id;
        this.Date=Date;
        this.Price=Price;
    }

    public int getOrder_id() {
        return Order_id;
    }

    public void setOrder_id(int order_id) {
        Order_id = order_id;
    }

    public Date getDate() {
        return Date;
    }

    public void setDate(Date date) {
        Date = date;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }
}
