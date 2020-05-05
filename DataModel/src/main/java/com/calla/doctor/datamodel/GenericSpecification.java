package com.calla.doctor.datamodel;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

public class GenericSpecification<T> implements Specification<T> {

	private static final long serialVersionUID = -105486885226411225L;
	
	private SearchCriteriaDTO searchCriteria;
	
	public GenericSpecification(SearchCriteriaDTO searchCriteria)
	{
		this.searchCriteria = searchCriteria;
	}
	@Override
	public Predicate toPredicate(Root<T> root, CriteriaQuery<?> arg1, CriteriaBuilder builder) {
		switch(searchCriteria.getOperator())
		{
			case ">":
			{
				 return builder.greaterThan(
			              root.<String> get(searchCriteria.getKey()), searchCriteria.getValue());
			}
			case ">=":
			{
				 return builder.greaterThanOrEqualTo(
			              root.<String> get(searchCriteria.getKey()), searchCriteria.getValue());
			}
			case "<":
			{
				 return builder.lessThan(
			              root.<String> get(searchCriteria.getKey()), searchCriteria.getValue());
			}
			case "<=":
			{
				 return builder.lessThanOrEqualTo(
			              root.<String> get(searchCriteria.getKey()), searchCriteria.getValue());
			}
			case "=":
			{
				 return builder.equal(
			              root.<String> get(searchCriteria.getKey()), searchCriteria.getValue());
			}
			case ":":
			{
				 return builder.like(
			              root.<String> get(searchCriteria.getKey()), "%"+searchCriteria.getValue()+"%");
			}
			default:
				break;
		
	}
	return null;
	}
	public SearchCriteriaDTO getSearchCriteria() {
		return searchCriteria;
	}
	public void setSearchCriteria(SearchCriteriaDTO searchCriteria) {
		this.searchCriteria = searchCriteria;
	}

}
