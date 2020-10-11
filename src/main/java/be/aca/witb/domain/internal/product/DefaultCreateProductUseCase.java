package be.aca.witb.domain.internal.product;

import static be.aca.witb.utility.validation.Validator.isNotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import be.aca.witb.utility.modules.ModuleServiceProvider;
import be.aca.witb.domain.api.product.CreateProductRequest;
import be.aca.witb.domain.api.product.CreateProductUseCase;
import be.aca.witb.domain.api.product.ProductIdentifier;

@Service
public class DefaultCreateProductUseCase implements CreateProductUseCase {

	private final DefaultProductRepository productRepository;

	@Autowired
	public DefaultCreateProductUseCase(DefaultProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Override
	public ProductIdentifier execute(CreateProductRequest request) {
		isNotNull(request);

		ProductEntity product = productRepository.save(new ProductEntity(request));

		return product.getIdentifier();
	}

	public static CreateProductUseCase provider() {
		return ModuleServiceProvider.provide(CreateProductUseCase.class);
	}
}
