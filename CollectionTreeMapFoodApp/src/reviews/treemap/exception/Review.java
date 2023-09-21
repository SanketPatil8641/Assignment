package reviews.treemap.exception;

import java.util.Objects;

public class Review implements Comparable<Review>{
	
	private String userName;
	private  int points;
	private String comment;
	
	public Review(String userName, int points, String comment) {
		super();
		this.userName = userName;
		this.points = points;
		this.comment = comment;
	}
	public Review() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	@Override
	public int hashCode() {
		return Objects.hash(comment, points, userName);
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Review)
		{
			Review review = (Review)obj;
			boolean a=review.userName.equals(this.getUserName());
			boolean b = review.points==this.points;
			boolean c=review.comment.equals(this.getComment());
			
			return a && b && c;
		}
		else
		{
			return false;
		}
	}
	@Override
	public String toString() {
		return "Review [userName=" + userName + ", points=" + points + ", comment=" + comment + "]";
	}
	@Override
	public int compareTo(Review r) {
		// TODO Auto-generated method stub
		return r.comment.compareTo(this.comment);
	}
	
	
	
}
