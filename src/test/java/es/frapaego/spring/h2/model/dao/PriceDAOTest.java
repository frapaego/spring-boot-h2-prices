package es.frapaego.spring.h2.model.dao;

import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanConstructor;
import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanEqualsExcluding;
import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanHashCodeExcluding;
import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanToStringExcluding;
import static com.google.code.beanmatchers.BeanMatchers.hasValidGettersAndSettersExcluding;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PriceDAOTest {

	private static final String[] IGNORE_PROPERTIES = { "startDate", "endDate", "brand" };
	
	@Test
	public void shouldHaveANoArgsConstructor() {
		assertThat(PriceDAO.class, hasValidBeanConstructor());
	}

	@Test
	public void gettersAndSettersShouldWorkForEachProperty() {
		assertThat(PriceDAO.class, hasValidGettersAndSettersExcluding(IGNORE_PROPERTIES));
	}

	@Test
	public void allPropertiesShouldInfluenceHashCode() {
		assertThat(PriceDAO.class, hasValidBeanHashCodeExcluding(IGNORE_PROPERTIES));
	}

	@Test
	public void allPropertiesShouldBeComparedDuringEquals() {
		assertThat(PriceDAO.class, hasValidBeanEqualsExcluding(IGNORE_PROPERTIES));
	}

	@Test
	public void allPropertiesShouldBeRepresentedInToStringOutput() {
		assertThat(PriceDAO.class, hasValidBeanToStringExcluding(IGNORE_PROPERTIES));
	}
}
