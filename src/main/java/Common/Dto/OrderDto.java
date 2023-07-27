package Common.Dto;

import java.util.Date;

public class OrderDto {

	private Date order_date;
	private String payment;
	private String order_amount;
	private int member_id;
	private int non_member_id;
	private int product_code;
	private String order_id;
	
	
	public Date getOrder_date() {
		return order_date;
	}
	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}
	public String getPayment() {
		return payment;
	}
	public void setPayment(String payment) {
		this.payment = payment;
	}
	public String getOrder_amount() {
		return order_amount;
	}
	public void setOrder_amount(String order_amount) {
		this.order_amount = order_amount;
	}
	public int getMember_id() {
		return member_id;
	}
	public void setMember_id(int member_id) {
		this.member_id = member_id;
	}
	public int getNon_member_id() {
		return non_member_id;
	}
	public void setNon_member_id(int non_member_id) {
		this.non_member_id = non_member_id;
	}
	public int getProduct_code() {
		return product_code;
	}
	public void setProduct_code(int product_code) {
		this.product_code = product_code;
	}
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	
	

	
	
}
