package es.frapaego.spring.h2.model.converter;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import es.frapaego.spring.h2.model.Price;
import es.frapaego.spring.h2.model.dao.PriceDAO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PriceConverterTest {
    
    @Autowired
    private PriceConverter priceConverter;
    
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
    	
    	final PriceDAO dao = new PriceDAO();
    	dao.setStartDate(startDate);
    	dao.setBrandId(brandId);
    	dao.setProductId(productId);
    	
    	final Price expectedResult = Price.builder().startDate(startDate).brandId(brandId).productId(productId).build();
        final Price result = this.priceConverter.convert(dao);

        assertThat(result, is(expectedResult));
        
    }

}
