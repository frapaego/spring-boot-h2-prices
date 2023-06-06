package es.frapaego.spring.h2.model.converter;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import es.frapaego.spring.h2.model.Brand;
import es.frapaego.spring.h2.model.dao.BrandDAO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BrandConverterTest {
    
    @Autowired
    private BrandConverter brandConverter;
    
    @Test
    public void test_null() {
        assertThat(this.brandConverter.convert(null), nullValue(Brand.class));
    }
    
    @Test
    public void test_empty() {
    	assertThat(this.brandConverter.convert(new BrandDAO()), is(Brand.builder().build()));
    }
    
    @Test
    public void test_data() {
    	
    	final BrandDAO brandDAO = new BrandDAO(1, "ZARA");
    	
    	final Brand expectedResult = Brand.builder().brandId(1).name("ZARA").build();
        final Brand result = this.brandConverter.convert(brandDAO);

        assertThat(result, is(expectedResult));
        
    }

}
