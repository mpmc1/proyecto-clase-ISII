package com.mipresupuesto.personalbudget.application.specification;

import org.springframework.stereotype.Component;

public class OrNotSpecification<T> extends CompositeSpecification<T> {
	
	ISpecification<T> left;
    ISpecification<T> right;

    public OrNotSpecification(ISpecification<T> left, ISpecification<T> right)
    {
        this.left = left;
        this.right = right;
    }
	@Override
	public boolean isSatisfyBy(T candidate) {
		return left.isSatisfyBy(candidate) || !right.isSatisfyBy(candidate);
	}

}
