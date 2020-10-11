package be.aca.witb.domain.api.order;

import be.aca.witb.domain.api.product.Product;

public interface OrderLine {

	Product getProduct();

	int getAmount();

}
