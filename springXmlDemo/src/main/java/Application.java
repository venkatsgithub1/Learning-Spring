import org.springframework.context.support.ClassPathXmlApplicationContext;

import demo.spring.xml.service.CustomerService;

public class Application {
	public static void main(String[] args) {
		try (ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext(
				"applicationContext.xml");) {
			CustomerService customerService = appContext.getBean("customerService", CustomerService.class);
			System.out.println(customerService.findAll().get(0).getFirstname());
		}
	}
}
