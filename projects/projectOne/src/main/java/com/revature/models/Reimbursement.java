package com.revature.models;

public class Reimbursement {

	private int id;
	private String category;
	private String status;
	private double amount;
	private String dateSubmitted;
	private int approvingManagerId;
	private String dateApproved;
	private int employeeId;
	
	public Reimbursement() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Reimbursement(int id, String category, String status, double amount, String dateSubmitted,
			int approvingManagerId, String dateApproved, int employeeId) {
		super();
		this.id = id;
		this.category = category;
		this.status = status;
		this.amount = amount;
		this.dateSubmitted = dateSubmitted;
		this.approvingManagerId = approvingManagerId;
		this.dateApproved = dateApproved;
		this.employeeId = employeeId;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getCategory() {
		return category;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public double getAmount() {
		return amount;
	}
	
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public String getDateSubmitted() {
		return dateSubmitted;
	}
	
	public void setDateSubmitted(String dateSubmitted) {
		this.dateSubmitted = dateSubmitted;
	}
	
	public int getApprovingManagerId() {
		return approvingManagerId;
	}
	
	public void setApprovingManagerId(int approvingManagerId) {
		this.approvingManagerId = approvingManagerId;
	}
	
	public String getDateApproved() {
		return dateApproved;
	}
	
	public void setDateApproved(String dateApproved) {
		this.dateApproved = dateApproved;
	}
	
	public int getEmployeeId() {
		return employeeId;
	}
	
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	
}
