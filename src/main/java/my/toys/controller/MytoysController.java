package my.toys.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import my.toys.dto.ProductDto;
import my.toys.entity.Product;

import my.toys.service.MytoysService;
/**
 * This is controller class for the product service
 * @author Guru
 *
 */
@RestController
@RequestMapping("/product")
public class MytoysController {
	@Autowired
	MytoysService mytoysService;
	/**
	 * This method return all the products. 
	 * @return list of all Products
	 */
	@GetMapping
	public List<ProductDto> getAllData() throws Exception{
		return mytoysService.getAlldata();
		
	}
	/**
	 * This method will returns product by id
	 * @param id
	 * @return product detail
	 * @throws Exception
	 */
	@GetMapping("/{id}")
	public ResponseEntity<ProductDto> getById(@PathVariable Long id) throws Exception{
		return ResponseEntity.ok().body(mytoysService.getById(id));
	}
	/**
	 * This method will returns products by brand 
	 * @param brand
	 * @return list of products
	 * @throws Exception
	 */
	@GetMapping("/brand/{brand}")
	public ResponseEntity<List<ProductDto>> getByBrand(@PathVariable String brand) throws Exception{
		return ResponseEntity.ok().body(mytoysService.getByBrand(brand));
	}
	/**
	 * This method will returns products by name
	 * @param name
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/name/{name}")
	public ResponseEntity<List<ProductDto>> getByName(@PathVariable String name) throws Exception{
		return ResponseEntity.ok().body(mytoysService.getByName(name));
	}
}
