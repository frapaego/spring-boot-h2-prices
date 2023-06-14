package es.frapaego.spring.h2.infrastracture.repository;

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
public class BrandDAOTest {

	@Test
	public void shouldHaveANoArgsConstructor() {
		assertThat(BrandDAO.class, hasValidBeanConstructor());
	}

	@Test
	public void gettersAndSettersShouldWorkForEachProperty() {
		assertThat(BrandDAO.class, hasValidGettersAndSetters());
	}

	@Test
	public void allPropertiesShouldInfluenceHashCode() {
		assertThat(BrandDAO.class, hasValidBeanHashCode());
	}

	@Test
	public void allPropertiesShouldBeComparedDuringEquals() {
		assertThat(BrandDAO.class, hasValidBeanEquals());
	}

	@Test
	public void allPropertiesShouldBeRepresentedInToStringOutput() {
		assertThat(BrandDAO.class, hasValidBeanToString());
	}
}
