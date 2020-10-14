package my.toys;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.net.URI;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;


import my.toys.entity.Product;


/**
 * This class is Spring BOOT test  to test all the rest APIs.
 * @author Guru
 *
 */
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class MytoysTest {
	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;
	
	HttpHeaders headers = new HttpHeaders();
	ObjectMapper mapper = new ObjectMapper();
	/**
	 * This method will test get all items 
	 * @throws Exception
	 */
	@Test
	public void testGetAllItems() throws Exception {
		String url = "http://localhost:" + port + "/product";
		Product product = new Product(43664L, "LEGO #14362905", new BigDecimal("24.99"), new BigDecimal("29.99"), 0L, "LEGO");
		ResponseEntity<Product[]> responseEntity = restTemplate.getForEntity(url, Product[].class);
		Product[] productArray =responseEntity.getBody();
		assertThat(product).isEqualToComparingFieldByField(productArray[0]);
	}
	/**
	 * This method will test get Product by id.
	 * @throws Exception
	 */
	@Test
	public void testfindById() throws Exception {
		String url = "http://localhost:" + port + "/product"+"/467";
		Product testProduct = new Product(467L, "s.Oliver #5687", new BigDecimal("22.99"), new BigDecimal("22.99"), 0L, "s.Oliver");
		ResponseEntity<Product> responseEntity = restTemplate.getForEntity(url, Product.class);
		Product product =responseEntity.getBody();
		assertThat(testProduct).isEqualToComparingFieldByField(product);
	}
	/**
	 * This method will test get Product brand.
	 * @throws Exception
	 */
	@Test
	public void testfindByBrand() throws Exception {
		String url = "http://localhost:" + port + "/product/brand"+"/LEGO";
		Product product = new Product(43664L, "LEGO #14362905", new BigDecimal("24.99"), new BigDecimal("29.99"), 0L, "LEGO");
		ResponseEntity<Product[]> responseEntity = restTemplate.getForEntity(url, Product[].class);
		Product[] productArray =responseEntity.getBody();
		assertThat(product).isEqualToComparingFieldByField(productArray[0]);
	}
	/**
	 * This method will test get Product name.
	 * @throws Exception
	 */
	@Test
	public void testfindByProductName() throws Exception {
		StringBuilder builder = new StringBuilder("http://localhost:" + port + "/product/name/LEGO%20%2314362905");
		URI url = URI.create(builder.toString());
		Product product = new Product(43664L, "LEGO #14362905", new BigDecimal("24.99"), new BigDecimal("29.99"), 0L, "LEGO");
		ResponseEntity<Product[]> responseEntity = restTemplate.getForEntity(url, Product[].class);
		Product[] productArray =responseEntity.getBody();
		assertThat(product).isEqualToComparingFieldByField(productArray[0]);
	}
}
