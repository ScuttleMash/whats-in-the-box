package be.aca.witb.domain.internal.product;

import static java.util.UUID.fromString;
import static java.util.UUID.randomUUID;

import be.aca.witb.domain.api.product.CreateProductRequest;
import be.aca.witb.domain.api.product.Product;
import be.aca.witb.domain.api.product.ProductIdentifier;
import be.aca.witb.domain.api.product.UpdateProductNameRequest;
import be.aca.witb.domain.api.product.UpdateProductStockRequest;

public class ProductEntity implements Product {

	private String uuid;
	private int version;

	private String name;
	private double price;
	private int stock;

	public ProductEntity(CreateProductRequest request) {
		uuid = randomUUID().toString();
		version = 1;

		name = request.getName().getValue();
		price = request.getPrice().getValue();
		stock = 0;
	}

	@Override
	public ProductIdentifier getIdentifier() {
		return new ProductIdentifier(fromString(uuid), version);
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public double getPrice() {
		return price;
	}

	@Override
	public int getStock() {
		return stock;
	}

	public void bumpVersion() {
		version++;
	}

	public void updateName(UpdateProductNameRequest request) {
		name = request.getProductName().getValue();
	}

	public boolean hasAmountInStock(int amountRequested) {
		return stock >= amountRequested;
	}

	public void updateStock(UpdateProductStockRequest request) {
		stock = request.getProductStock().getValue();
	}
}
