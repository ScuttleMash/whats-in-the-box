package be.aca.witb.domain.api.product.mothers;

import static be.aca.witb.domain.api.product.builders.CreateProductRequestTestBuilder.aCreateProductRequestTestBuilder;

import java.util.UUID;

import be.aca.witb.domain.api.product.CreateProductUseCase;
import be.aca.witb.domain.api.product.Product;
import be.aca.witb.domain.api.product.ProductRepository;
import be.aca.witb.domain.internal.product.DefaultCreateProductUseCase;
import be.aca.witb.domain.internal.product.DefaultProductRepository;

public class ProductMother {

	private final CreateProductUseCase createProductUseCase;
	private final ProductRepository productRepository;

	private UUID uuid;

	public ProductMother() {
		createProductUseCase = new DefaultCreateProductUseCase();
		productRepository = new DefaultProductRepository();
	}

	public void setup() {
		uuid = createProductUseCase.execute(aCreateProductRequestTestBuilder().build()).getUuid();
	}

	public Product getProduct() {
		return productRepository.get(uuid);
	}
}
