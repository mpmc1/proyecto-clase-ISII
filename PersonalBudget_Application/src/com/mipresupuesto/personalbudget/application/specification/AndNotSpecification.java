package com.mipresupuesto.personalbudget.application.specification;

public class AndNotSpecification<T> extends CompositeSpecification<T> {
	
	 ISpecification<T> left;
     ISpecification<T> right;

     public AndNotSpecification(ISpecification<T> left, ISpecification<T> right)
     {
         this.left = left;
         this.right = right;
     }
     @Override
    public boolean isSatisfyBy(T candidate) {
    	return left.isSatisfyBy(candidate) && !right.isSatisfyBy(candidate);
    }

}
