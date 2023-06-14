package es.frapaego.spring.h2.domain;

import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanConstructor;
import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanEquals;
import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanHashCode;
import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanToString;
import static com.google.code.beanmatchers.BeanMatchers.hasValidGettersAndSetters;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BrandTest {

	@Test
	public void shouldHaveANoArgsConstructor() {
		assertThat(Brand.class, hasValidBeanConstructor());
	}

	@Test
	public void gettersAndSettersShouldWorkForEachProperty() {
		assertThat(Brand.class, hasValidGettersAndSetters());
	}

	@Test
	public void allPropertiesShouldInfluenceHashCode() {
		assertThat(Brand.class, hasValidBeanHashCode());
	}

	@Test
	public void allPropertiesShouldBeComparedDuringEquals() {
		assertThat(Brand.class, hasValidBeanEquals());
	}

	@Test
	public void allPropertiesShouldBeRepresentedInToStringOutput() {
		assertThat(Brand.class, hasValidBeanToString());
	}
}
