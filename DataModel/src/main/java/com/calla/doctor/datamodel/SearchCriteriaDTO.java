package com.calla.doctor.datamodel;

public class SearchCriteriaDTO {
	
	private String key;
	private String operator;
	private String value;
	private String conjuction;
	
	public SearchCriteriaDTO(String key, String operator, String value)
	{
		this.key = key;
		this.operator = operator;
		this.value = value;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getConjuction() {
		return conjuction;
	}
	public void setConjuction(String conjuction) {
		this.conjuction = conjuction;
	}
}
