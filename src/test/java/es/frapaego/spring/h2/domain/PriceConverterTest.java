package es.frapaego.spring.h2.domain;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import es.frapaego.spring.h2.domain.BrandConverter;
import es.frapaego.spring.h2.domain.Price;
import es.frapaego.spring.h2.domain.PriceConverter;
import es.frapaego.spring.h2.infrastracture.repository.BrandDAO;
import es.frapaego.spring.h2.infrastracture.repository.PriceDAO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PriceConverterTest {
    
    @Autowired
    private PriceConverter priceConverter;
    @Autowired
    private BrandConverter brandConverter;
    
    @Test
    public void test_null() {
        assertThat(this.priceConverter.convert(null), nullValue(Price.class));
    }
    
    @Test
    public void test_empty() {
    	assertThat(this.priceConverter.convert(new PriceDAO()), is(Price.builder().build()));
    }
    
    @Test
    public void test_data() {
    	
    	final LocalDateTime startDate = LocalDateTime.of(2020, 6, 14, 10, 0, 0);
    	final Integer brandId = 1;
    	final Integer productId = 35455;
    	
    	final BrandDAO brandDAO = new BrandDAO(brandId, "ZARA");
    	final PriceDAO priceDAO = new PriceDAO();
    	priceDAO.setStartDate(startDate);
    	priceDAO.setBrand(brandDAO);
    	priceDAO.setProductId(productId);
    	
    	final Price expectedResult = Price.builder().startDate(startDate).brand(this.brandConverter.convert(brandDAO)).productId(productId).build();
        final Price result = this.priceConverter.convert(priceDAO);

        assertThat(result, is(expectedResult));
        
    }

}
