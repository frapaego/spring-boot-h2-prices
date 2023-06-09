package es.frapaego.spring.h2.domain;

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
public class PriceTest {

	private static final String[] IGNORE_PROPERTIES = { "startDate", "endDate" };
	
	@Test
	public void shouldHaveANoArgsConstructor() {
		assertThat(Price.class, hasValidBeanConstructor());
	}

	@Test
	public void gettersAndSettersShouldWorkForEachProperty() {
		assertThat(Price.class, hasValidGettersAndSettersExcluding(IGNORE_PROPERTIES));
	}

	@Test
	public void allPropertiesShouldInfluenceHashCode() {
		assertThat(Price.class, hasValidBeanHashCodeExcluding(IGNORE_PROPERTIES));
	}

	@Test
	public void allPropertiesShouldBeComparedDuringEquals() {
		assertThat(Price.class, hasValidBeanEqualsExcluding(IGNORE_PROPERTIES));
	}

	@Test
	public void allPropertiesShouldBeRepresentedInToStringOutput() {
		assertThat(Price.class, hasValidBeanToStringExcluding(IGNORE_PROPERTIES));
	}
}
