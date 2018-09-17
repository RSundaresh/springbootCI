package com.samples.jwtauth.dto;

public class MultipleCount {
	
	Integer totalCount;
	Integer idCount;
	
	public MultipleCount() {
		super();
	}
	
	public MultipleCount(Integer totalCount, Integer idCount) {
		super();
		this.totalCount = totalCount;
		this.idCount = idCount;
	}
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	public Integer getIdCount() {
		return idCount;
	}
	public void setIdCount(Integer idCount) {
		this.idCount = idCount;
	}
	
}
