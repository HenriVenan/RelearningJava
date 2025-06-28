package entities;

import entities.enums.OrderStatus;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Order {
    private LocalDateTime moment;
    private OrderStatus status;
    private final Client client;
    private final ArrayList<OrderItem> orderItems = new ArrayList<>();

    public Order(LocalDateTime moment, OrderStatus status, Client client) {
        this.moment = moment;
        this.status = status;
        this.client = client;
    }

    public void addItem(OrderItem item) {
        orderItems.add(item);
    }

    public void removeItem(OrderItem item) {
        orderItems.remove(item);
    }

    public double totalValue(){
        double calc = 0;

        for (OrderItem item : orderItems){
            calc += item.subTotal();
        }

        return calc;
    }

    public String toString() {
        StringBuilder strB = new StringBuilder();
        DateTimeFormatter dtfMoment = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss");
        DateTimeFormatter dtfBirth = DateTimeFormatter.ofPattern("(dd/MM/yyyy)");

        strB.append("\nOrder Summary: ");
        strB.append("\nOrder moment: ").append(dtfMoment.format(moment));
        strB.append("\nOrder status: ").append(status);
        strB.append(" \nClient: ")
                .append(client.getName())
                .append(" ")
                .append(dtfBirth.format(client.getBirthDate()))
                .append(" - ")
                .append(client.getEmail())
        .append("\nOrder Items: \n");

        for(OrderItem item: orderItems) {
            strB.append(item.getProduct().getName())
                    .append(", $")
                    .append(item.getProduct().getPrice())
                    .append(", Quantity: ")
                    .append(item.getQuantity())
                    .append(", Subtotal: $")
                    .append(item.subTotal())
            .append("\n");
        }

        strB.append("Total price: ")
                .append(totalValue());

        return strB.toString();
    }

    public LocalDateTime getMoment() {
        return moment;
    }

    public void setMoment(LocalDateTime moment) {
        this.moment = moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Client getClient() {
        return client;
    }

    public ArrayList<OrderItem> getOrderItem() {
        return orderItems;
    }
}
