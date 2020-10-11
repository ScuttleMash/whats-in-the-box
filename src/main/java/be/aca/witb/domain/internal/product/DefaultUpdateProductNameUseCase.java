package be.aca.witb.domain.internal.product;

import static be.aca.witb.utility.modules.ModuleServiceProvider.provide;
import static be.aca.witb.utility.validation.Validator.isNotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import be.aca.witb.domain.api.product.ProductIdentifier;
import be.aca.witb.domain.api.product.UpdateProductNameRequest;
import be.aca.witb.domain.api.product.UpdateProductNameUseCase;

@Service
public class DefaultUpdateProductNameUseCase implements UpdateProductNameUseCase {

	private final DefaultProductRepository productRepository;

	@Autowired
	public DefaultUpdateProductNameUseCase(DefaultProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Override
	public ProductIdentifier execute(ProductIdentifier identifier, UpdateProductNameRequest request) {
		isNotNull(identifier);
		isNotNull(request);

		ProductEntity product = productRepository.get(identifier);
		product.updateName(request);
		productRepository.save(product);
		return product.getIdentifier();
	}

	public static UpdateProductNameUseCase provider() {
		return provide(UpdateProductNameUseCase.class);
	}
}
