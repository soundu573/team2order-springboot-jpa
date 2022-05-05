package entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="orders")
public class OrderModel {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int orderId;
@Column(name="orderName",nullable = false)
private String orderName;
@Column(name="orderDescription",nullable = false)
private String orderDescription;
//Object ThemeModel;
//Object GiftModel;
@Column(name="orderDate",nullable = false)
private Date orderDate;
@Column(name="orderPrice",nullable = false)
private int orderPrice;
@Column(name="orderAddress",nullable = false)
private String orderAddress;
@Column(name="orderPhone",nullable = false)
private String orderPhone;
@Column(name="orderEmail",nullable = false)
private String orderEmail;



public OrderModel(String orderName, String orderDescription,  Date orderDate,
		int orderPrice, String orderAddress, String orderPhone, String orderEmail) {
	
	this.orderName = orderName;
	this.orderDescription = orderDescription;
	//ThemeModel = themeModel;
	//GiftModel = giftModel;
	this.orderDate = orderDate;
	this.orderPrice = orderPrice;
	this.orderAddress = orderAddress;
	this.orderPhone = orderPhone;
	this.orderEmail = orderEmail;
}


public OrderModel() {
	
}


public int getOrderId() {
	return orderId;
}


public void setOrderId(int orderId) {
	this.orderId = orderId;
}


public String getOrderName() {
	return orderName;
}


public void setOrderName(String orderName) {
	this.orderName = orderName;
}


public String getOrderDescription() {
	return orderDescription;
}


public void setOrderDescription(String orderDescription) {
	this.orderDescription = orderDescription;
}


/*public Object getThemeModel() {
	return ThemeModel;
}


public void setThemeModel(Object themeModel) {
	ThemeModel = themeModel;
}


public Object getGiftModel() {
	return GiftModel;
}


public void setGiftModel(Object giftModel) {
	GiftModel = giftModel;
}*/


public Date getOrderDate() {
	return orderDate;
}


public void setOrderDate(Date orderDate) {
	this.orderDate = orderDate;
}


public int getOrderPrice() {
	return orderPrice;
}


public void setOrderPrice(int orderPrice) {
	this.orderPrice = orderPrice;
}


public String getOrderAddress() {
	return orderAddress;
}


public void setOrderAddress(String orderAddress) {
	this.orderAddress = orderAddress;
}


public String getOrderPhone() {
	return orderPhone;
}


public void setOrderPhone(String orderPhone) {
	this.orderPhone = orderPhone;
}


public String getOrderEmail() {
	return orderEmail;
}


public void setOrderEmail(String orderEmail) {
	this.orderEmail = orderEmail;
}

}

