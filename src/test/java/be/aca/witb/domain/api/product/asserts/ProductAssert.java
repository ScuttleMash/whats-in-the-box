package be.aca.witb.domain.api.product.asserts;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.data.Offset.offset;

import org.assertj.core.api.AbstractAssert;

import be.aca.witb.domain.api.product.Product;
import be.aca.witb.domain.api.product.ProductName;
import be.aca.witb.domain.api.product.ProductPrice;
import be.aca.witb.domain.api.product.ProductStock;

public final class ProductAssert extends AbstractAssert<ProductAssert, Product> {

	public ProductAssert(Product product) {
		super(product, ProductAssert.class);
	}

	public ProductAssert hasName(ProductName expected) {
		assertThat(actual.getName()).isEqualTo(expected.getValue());
		return this;
	}

	public ProductAssert hasPrice(ProductPrice expected) {
		assertThat(actual.getPrice()).isEqualTo(expected.getValue(), offset(0.01));
		return this;
	}

	public ProductAssert hasStock(ProductStock expected) {
		assertThat(actual.getStock()).isEqualTo(expected.getValue());
		return this;
	}

	public static ProductAssert assertThatProduct(Product product) {
		assertThat(product).isNotNull();
		return new ProductAssert(product);
	}
}

