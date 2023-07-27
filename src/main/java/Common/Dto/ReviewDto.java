package Common.Dto;

public class ReviewDto {

	private String starpoint;
	private String comment;
	private int member_id;
	private int non_member_id;
	private int order_number;
	
	
	public String getStarpoint() {
		return starpoint;
	}
	public void setStarpoint(String starpoint) {
		this.starpoint = starpoint;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
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
	public int getOrder_number() {
		return order_number;
	}
	public void setOrder_number(int order_number) {
		this.order_number = order_number;
	}
	
	
	
}
