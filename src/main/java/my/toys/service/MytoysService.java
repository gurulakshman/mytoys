package my.toys.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import my.toys.bean.ProductComponent;
import my.toys.dto.ProductDto;
import my.toys.entity.Product;
import my.toys.exception.ResourceNotFoundException;
/**
 * This is service class for the product controller.
 * All the business logic for the product controller is written here
 * @author Guru
 *
 */
@Service
public class MytoysService {
	@Autowired
	ProductComponent productComponent;
	/**
	 * This method will returns all the products from file. 
	 * @return List of Products
	 */
	public List<ProductDto> getAlldata() throws Exception{
		List <Product> productsList = productComponent.beanBuilderExample();
		
		List<ProductDto> productDtoList = productsList.stream()
											.map(Product::convertToProductDto)
											.collect(Collectors.toList());
		return productDtoList;
	}
	/**
	 * This method will returns the Products details by id.
	 * @param id
	 * @return Product Details
	 */
	public ProductDto getById(Long id) throws Exception{
		List <Product> productsList = productComponent.beanBuilderExample();
		Product product ;
		try {
			product =   productsList.stream()
							.filter(p -> p.getId()
							.equals(id)).collect(Collectors.toList()).get(0);			
		} catch(Exception e) {
			throw new ResourceNotFoundException("Product with id :"+id+" Not Found!");

		}
		
		return product.convertToProductDto();
	}
	/**
	 * This method will returns the Products details by brand.
	 * @param brand
	 * @return list of products
	 * @throws Exception
	 */
	public List<ProductDto> getByBrand(String brand ) throws Exception{
		List <Product> productsList = productComponent.beanBuilderExample();
		
		List<ProductDto> filteredProductList =   productsList.stream()
													.filter(p -> p.getBrand().equals(brand))
													.map(Product::convertToProductDto)
													.collect(Collectors.toList());
		return filteredProductList;
	}
	/**
	 * This method will returns the Products details by name.
	 * @param name
	 * @return list of products by name
	 * @throws Exception
	 */
	public List<ProductDto> getByName(String name ) throws Exception{
		List <Product> productsList = productComponent.beanBuilderExample();
		List<ProductDto> filteredProductList =   productsList.stream()
											.filter(p -> p.getName().equals(name))
											.map(Product::convertToProductDto)
											.collect(Collectors.toList());
		return filteredProductList;
	}

}
