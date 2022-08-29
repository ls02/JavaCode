package model;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 86176
 * Date: 2022-08-28
 * Time: 14:27
 */

//通过这个 Order 来表示一个完整的订单
//    包括订单中都有那些菜
public class Order {
    private int orderId;
    private int userId;
    private Timestamp time;
    private int isDone;
    private List<Dish> dishes;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public int getIsDone() {
        return isDone;
    }

    public void setIsDone(int isDone) {
        this.isDone = isDone;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }
}
