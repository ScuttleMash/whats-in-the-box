package be.aca.witb.domain.api.product;

public interface Product {

	ProductIdentifier getIdentifier();

	String getName();

	double getPrice();

	boolean hasStock();

	int getStock();
}
