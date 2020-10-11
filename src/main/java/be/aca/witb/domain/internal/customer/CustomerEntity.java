package be.aca.witb.domain.internal.customer;

import static java.time.ZonedDateTime.*;
import static java.time.temporal.ChronoUnit.*;
import static java.util.UUID.fromString;
import static java.util.UUID.randomUUID;

import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

import be.aca.witb.domain.api.customer.CreateCustomerRequest;
import be.aca.witb.domain.api.customer.CustomerIdentifier;

public class CustomerEntity {

	private String uuid;
	private int version;
	private ZonedDateTime registeredOn;

	private String name;

	public CustomerEntity(CreateCustomerRequest request) {
		uuid = randomUUID().toString();
		version = 1;
		registeredOn = now().truncatedTo(DAYS);

		name = request.getName().getValue();
	}

	public CustomerIdentifier getIdentifier() {
		return new CustomerIdentifier(fromString(uuid), version);
	}

	public void bumpVersion() {
		version++;
	}

	public String getName() {
		return name;
	}

	public ZonedDateTime getRegisteredOn() {
		return registeredOn;
	}
}
