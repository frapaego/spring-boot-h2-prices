package es.frapaego.spring.h2.model.dto;

import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanConstructor;
import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanEqualsExcluding;
import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanHashCodeExcluding;
import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanToStringExcluding;
import static com.google.code.beanmatchers.BeanMatchers.hasValidGettersAndSettersExcluding;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.Test;

public class PriceDTOTest {

	private static final String[] IGNORE_PROPERTIES = { "startDate", "endDate" };
	
	@Test
	public void shouldHaveANoArgsConstructor() {
		assertThat(PriceDTO.class, hasValidBeanConstructor());
	}

	@Test
	public void gettersAndSettersShouldWorkForEachProperty() {
		assertThat(PriceDTO.class, hasValidGettersAndSettersExcluding(IGNORE_PROPERTIES));
	}

	@Test
	public void allPropertiesShouldInfluenceHashCode() {
		assertThat(PriceDTO.class, hasValidBeanHashCodeExcluding(IGNORE_PROPERTIES));
	}

	@Test
	public void allPropertiesShouldBeComparedDuringEquals() {
		assertThat(PriceDTO.class, hasValidBeanEqualsExcluding(IGNORE_PROPERTIES));
	}

	@Test
	public void allPropertiesShouldBeRepresentedInToStringOutput() {
		assertThat(PriceDTO.class, hasValidBeanToStringExcluding(IGNORE_PROPERTIES));
	}
}
