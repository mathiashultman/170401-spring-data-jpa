package biz.mathias.main;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import biz.mathias.db.PersonRepository;
import biz.mathias.domain.Person;

public class Main {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				biz.mathias.config.JpaConfiguration.class);
		Person p=new Person();
		p.setName("hu");
		PersonRepository prep=context.getBean(PersonRepository.class);
		prep.save(p);
		((ConfigurableApplicationContext)context).close();
	}
}
