package com.generate.invoice.entity.constants;

/**
 * 
 */


import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Manish
 *
 */
@Getter
@AllArgsConstructor
public enum OrderStatus {

	DELIVERED("Delivered", 100),
	CANCELLED_BY_USER("Cancelled", 100),
	CANCELLED_BY_SELLER("Cancelled By Seller", 100),
	CANCELLED_BY_DELIVERY_PARTNER("Cancelled By Delivery Partner", 100),
	EXCHANGE_DELIVERED("Exchange Delivered", 100),
	EXCHANGE_CANCELLED("Exchange Cancelled", 100),
	RETURN_RECEIVED("Return Recevied", 100),
	RETURN_CANCELLED("Return Cancelled", 100),

	EXCHANGE_PICKEDUP_FROM_SELLER("Exchange Picked Up From Seller", 200),
	EXCHANGE_ASSIGNED_TO_DELIVERY_PARTNER_FROM_SELLER("Exchange Assigned To Delivery Partner From Seller", 200),
	EXCHANGE_READY_FOR_PICKUP("Exchange Ready For Pickup", 200), EXCHANGE_RECEIVED("Exchange Recevied", 200),
	EXCHANGE_PICKEDUP_FROM_USER("Exchange Picked Up From User", 200),
	EXCHANGE_ASSIGNED_TO_DELIVERY_PARTNER_FROM_USER("Exchange Assigned To Delivery Partner From User", 200),

	RETURN_EXCHANGE("Return Exchange", 200), RETURN_PICKEDUP("Return Picked Up", 200),
	RETURN_ASSIGNED_TO_DELIVERY_PARTNER("Return Assigned To Delivery Partner", 200),
	RETURN_REFUND("Return Refund", 200), PENDING("Pending", 200), OUT_FOR_DELIVERY("Out For Delivery", 200),
	SHIPPED("Shipped", 200), ASSIGNED_TO_DELIVERY_PARTNER("Assigned To Delivery Partner", 200),
	READY_FOR_PICKUP("Ready For Pickup", 200), CONFIRMED("Confirmed", 200), ORDERED("Ordered", 200),
	NOT_YET_SHIPPED("Not yet Shipped", 100)
	,CANCELLED_ORDERS("Cancelled_Order",100)
	,ORDERED_SUCCESSFUL("Ordered Successful",100);
	

	String displayName;
	Integer orderStatusWeight;
}