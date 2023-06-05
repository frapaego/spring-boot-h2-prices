package es.frapaego.spring.h2.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import es.frapaego.spring.h2.controller.impl.PriceControllerImpl;
import es.frapaego.spring.h2.model.Price;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PriceControllerTest2 {
	@Autowired
	private PriceControllerImpl priceController;

	@Test
    public void test1() {
    	
    	final LocalDateTime date = LocalDateTime.of(2020, 6, 14, 10, 0, 0);    	
    	
        final ResponseEntity<Price> result = this.priceController.obtenerPrecio(1, 35455, date);

        assertThat(result, notNullValue());
		assertThat(result.getStatusCode(), is(HttpStatus.OK));
		assertThat(result.getBody(), notNullValue());
        assertThat(result.getBody().getStartDate().isBefore(date), is(true));
        assertThat(result.getBody().getEndDate().isAfter(date), is(true));
        
    }
	
	@Test
    public void test2() {
    	
    	final LocalDateTime date = LocalDateTime.of(2020, 6, 14, 16, 0, 0);
    	
    	final ResponseEntity<Price> result = this.priceController.obtenerPrecio(1, 35455, date);

        assertThat(result, notNullValue());
		assertThat(result.getStatusCode(), is(HttpStatus.OK));
		assertThat(result.getBody(), notNullValue());
        assertThat(result.getBody().getStartDate().isBefore(date), is(true));
        assertThat(result.getBody().getEndDate().isAfter(date), is(true));
    }
    
    @Test
    public void test3() {
    	
    	final LocalDateTime date = LocalDateTime.of(2020, 6, 14, 21, 0, 0);
    	
    	final ResponseEntity<Price> result = this.priceController.obtenerPrecio(1, 35455, date);

        assertThat(result, notNullValue());
		assertThat(result.getStatusCode(), is(HttpStatus.OK));
		assertThat(result.getBody(), notNullValue());
        assertThat(result.getBody().getStartDate().isBefore(date), is(true));
        assertThat(result.getBody().getEndDate().isAfter(date), is(true));
    }
    
    @Test
    public void test4() {
    	
    	final LocalDateTime date = LocalDateTime.of(2020, 6, 15, 10, 0, 0);
    	
    	final ResponseEntity<Price> result = this.priceController.obtenerPrecio(1, 35455, date);

        assertThat(result, notNullValue());
		assertThat(result.getStatusCode(), is(HttpStatus.OK));
		assertThat(result.getBody(), notNullValue());
        assertThat(result.getBody().getStartDate().isBefore(date), is(true));
        assertThat(result.getBody().getEndDate().isAfter(date), is(true));
    }
    
    @Test
    public void test5() {
    	
    	final LocalDateTime date = LocalDateTime.of(2020, 6, 16, 21, 0, 0);
    	
    	final ResponseEntity<Price> result = this.priceController.obtenerPrecio(1, 35455, date);

        assertThat(result, notNullValue());
		assertThat(result.getStatusCode(), is(HttpStatus.OK));
		assertThat(result.getBody(), notNullValue());
        assertThat(result.getBody().getStartDate().isBefore(date), is(true));
        assertThat(result.getBody().getEndDate().isAfter(date), is(true));
    }
}