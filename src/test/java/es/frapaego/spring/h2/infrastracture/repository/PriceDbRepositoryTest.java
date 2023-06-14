package es.frapaego.spring.h2.infrastracture.repository;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig
@SpringBootTest
public class PriceDbRepositoryTest {
    
    @Autowired
    private PriceDbRepository priceRepository;
    
    @Test
    public void test1() {
    	
    	final LocalDateTime date = LocalDateTime.of(2020, 6, 14, 10, 0, 0);
    	
    	final BrandDAO brandDAO = new BrandDAO();
    	brandDAO.setBrandId(1);
    	
        final PriceDAO result = this.priceRepository.findByStartDateAndProductIdAndBrandId(date, 35455, brandDAO);

        assertThat(result, notNullValue());
        assertThat(result.getStartDate().isBefore(date), is(true));
        assertThat(result.getEndDate().isAfter(date), is(true));
        
    }
    
    @Test
    public void test2() {
    	
    	final LocalDateTime date = LocalDateTime.of(2020, 6, 14, 16, 0, 0);
    	
    	final BrandDAO brandDAO = new BrandDAO();
    	brandDAO.setBrandId(1);
    	
        final PriceDAO result = this.priceRepository.findByStartDateAndProductIdAndBrandId(date, 35455, brandDAO);

        assertThat(result, notNullValue());
        assertThat(result.getStartDate().isBefore(date), is(true));
        assertThat(result.getEndDate().isAfter(date), is(true));
    }
    
    @Test
    public void test3() {
    	
    	final LocalDateTime date = LocalDateTime.of(2020, 6, 14, 21, 0, 0);
    	
    	final BrandDAO brandDAO = new BrandDAO();
    	brandDAO.setBrandId(1);
    	
        final PriceDAO result = this.priceRepository.findByStartDateAndProductIdAndBrandId(date, 35455, brandDAO);
        
        assertThat(result, notNullValue());
        assertThat(result.getStartDate().isBefore(date), is(true));
        assertThat(result.getEndDate().isAfter(date), is(true));
    }
    
    @Test
    public void test4() {
    	
    	final LocalDateTime date = LocalDateTime.of(2020, 6, 15, 10, 0, 0);
    	
    	final BrandDAO brandDAO = new BrandDAO();
    	brandDAO.setBrandId(1);
    	
        final PriceDAO result = this.priceRepository.findByStartDateAndProductIdAndBrandId(date, 35455, brandDAO);

        assertThat(result, notNullValue());
        assertThat(result.getStartDate().isBefore(date), is(true));
        assertThat(result.getEndDate().isAfter(date), is(true));
    }
    
    @Test
    public void test5() {
    	
    	final LocalDateTime date = LocalDateTime.of(2020, 6, 16, 21, 0, 0);
    	
    	final BrandDAO brandDAO = new BrandDAO();
    	brandDAO.setBrandId(1);
    	
        final PriceDAO result = this.priceRepository.findByStartDateAndProductIdAndBrandId(date, 35455, brandDAO);

        assertThat(result, notNullValue());
        assertThat(result.getStartDate().isBefore(date), is(true));
        assertThat(result.getEndDate().isAfter(date), is(true));
    }
}
