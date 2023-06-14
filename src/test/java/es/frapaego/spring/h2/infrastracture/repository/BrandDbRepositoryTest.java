package es.frapaego.spring.h2.infrastracture.repository;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;


@SpringJUnitConfig
@SpringBootTest
public class BrandDbRepositoryTest {
    
    @Autowired
    private BrandDbRepository brandRepository;
    
    @Test
    public void test() {
    	
    	final BrandDAO result = this.brandRepository.findByBrandId(1);

        assertThat(result, notNullValue());
        
    }

}
