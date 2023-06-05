package es.frapaego.spring.h2.repository;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import es.frapaego.spring.h2.model.dto.PriceDTO;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PriceRepositoryTest {
    
    @Autowired
    private PriceRepository priceRepository;
    
    @Test
    public void test1() {
    	
    	final LocalDateTime date = LocalDateTime.of(2020, 6, 14, 10, 0, 0);
    	
        final PriceDTO prices = this.priceRepository.findByStartDateAndProductIdAndBrandId(date, 35455, 1);

        assertThat(prices, notNullValue());
        assertThat(prices.getStartDate().isBefore(date), is(true));
        assertThat(prices.getEndDate().isAfter(date), is(true));
        
    }
    
    @Test
    public void test2() {
    	
    	final LocalDateTime date = LocalDateTime.of(2020, 6, 14, 16, 0, 0);
    	
        final PriceDTO prices = this.priceRepository.findByStartDateAndProductIdAndBrandId(date, 35455, 1);

        assertThat(prices, notNullValue());
        assertThat(prices.getStartDate().isBefore(date), is(true));
        assertThat(prices.getEndDate().isAfter(date), is(true));
    }
    
    @Test
    public void test3() {
    	
    	final LocalDateTime date = LocalDateTime.of(2020, 6, 14, 21, 0, 0);
    	
        final PriceDTO prices = this.priceRepository.findByStartDateAndProductIdAndBrandId(date, 35455, 1);
        
        assertThat(prices, notNullValue());
        assertThat(prices.getStartDate().isBefore(date), is(true));
        assertThat(prices.getEndDate().isAfter(date), is(true));
    }
    
    @Test
    public void test4() {
    	
    	final LocalDateTime date = LocalDateTime.of(2020, 6, 15, 10, 0, 0);
    	
        final PriceDTO prices = this.priceRepository.findByStartDateAndProductIdAndBrandId(date, 35455, 1);

        assertThat(prices, notNullValue());
        assertThat(prices.getStartDate().isBefore(date), is(true));
        assertThat(prices.getEndDate().isAfter(date), is(true));
    }
    
    @Test
    public void test5() {
    	
    	final LocalDateTime date = LocalDateTime.of(2020, 6, 16, 21, 0, 0);
    	
        final PriceDTO prices = this.priceRepository.findByStartDateAndProductIdAndBrandId(date, 35455, 1);

        assertThat(prices, notNullValue());
        assertThat(prices.getStartDate().isBefore(date), is(true));
        assertThat(prices.getEndDate().isAfter(date), is(true));
    }
}
