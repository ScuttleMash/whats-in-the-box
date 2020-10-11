package be.aca.witb.utility.modules;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class ModuleServiceProvider implements ApplicationContextAware {

	private static ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		ModuleServiceProvider.applicationContext = applicationContext;
	}

	public static <T> T provide(Class<T> clazz) {
		return applicationContext.getBean(clazz);
	}
}
