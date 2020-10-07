package be.aca.witb.domain.internal.customer;

import static java.util.UUID.fromString;
import static java.util.UUID.randomUUID;

import be.aca.witb.domain.api.customer.CustomerIdentifier;

public class CustomerEntity {

	private String uuid;
	private int version;

	private String name;
	private String phoneNumber;

	public CustomerEntity() {
		uuid = randomUUID().toString();
		version = 1;

		name = "";
		phoneNumber = "";
	}

	public CustomerIdentifier getIdentifier() {
		return new CustomerIdentifier(fromString(uuid), version);
	}

	public void bumpVersion() {
		version++;
	}
}
