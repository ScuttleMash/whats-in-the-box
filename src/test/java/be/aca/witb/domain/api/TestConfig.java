package be.aca.witb.domain.api;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;

import be.aca.witb.domain.internal.DomainConfiguration;

@Configuration
@ContextConfiguration(classes = { DomainConfiguration.class })
@ComponentScan
public class TestConfig {

}
