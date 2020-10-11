package be.aca.witb.domain.internal.product;

import static be.aca.witb.utility.modules.ModuleServiceProvider.provide;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import be.aca.witb.domain.api.product.ProductIdentifier;
import be.aca.witb.domain.api.product.ProductRepository;
import be.aca.witb.domain.internal.product.exceptions.ProductNotFoundException;

@Repository
public class DefaultProductRepository implements ProductRepository {

	private static List<ProductEntity> saved = new ArrayList<>();

	@Override
	public ProductEntity get(ProductIdentifier identifier) {
		return saved.stream()
				.filter(product -> product.getIdentifier().equals(identifier))
				.findFirst()
				.orElseThrow(ProductNotFoundException::new);
	}

	@Override
	public ProductEntity get(UUID uuid) {
		return saved.stream()
				.filter(product -> product.getIdentifier().hasUuid(uuid))
				.findFirst()
				.orElseThrow(ProductNotFoundException::new);
	}

	public ProductEntity save(ProductEntity product) {
		saved.removeIf(entry -> entry.getIdentifier().equals(product.getIdentifier()));
		saved.add(product);
		product.bumpVersion();
		return product;
	}

	public static ProductRepository provider() {
		return provide(ProductRepository.class);
	}
}
