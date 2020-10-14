package my.toys.entity;

import java.math.BigDecimal;

import com.opencsv.bean.CsvBindByPosition;

import my.toys.dto.ProductDto;
/**
 * This is class represent each product in the csv file.
 * @author Guru
 *
 */
public class Product {
	 @CsvBindByPosition(position = 0)
	 private Long id;
	 
	 @CsvBindByPosition(position = 1)
	 private String name;
	 
	 @CsvBindByPosition(position = 2)
	 private BigDecimal  price;
	 
	 @CsvBindByPosition(position = 3)
	 private BigDecimal  oldPrice;
	 
	 @CsvBindByPosition(position = 4)	 
	 private Long stock;
	 
	 @CsvBindByPosition(position = 5)
	 private String brand;
	 
	 public Product() {
		 
	 }

	public Product(Long id, String name, BigDecimal price, BigDecimal oldPrice, Long stock, String brand) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.oldPrice = oldPrice;
		this.stock = stock;
		this.brand = brand;
	}

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public BigDecimal getPrice() {
		return price;
	}


	public void setPrice(BigDecimal price) {
		this.price = price;
	}


	public BigDecimal getOldPrice() {
		return oldPrice;
	}


	public void setOldPrice(BigDecimal oldPrice) {
		this.oldPrice = oldPrice;
	}


	public Long getStock() {
		return stock;
	}


	public void setStock(Long stock) {
		this.stock = stock;
	}


	public String getBrand() {
		return brand;
	}


	public void setBrand(String brand) {
		this.brand = brand;
	}


	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", oldPrice=" + oldPrice + ", stock="
				+ stock + ", brand=" + brand + "]";
	}
	public ProductDto convertToProductDto() {
		return new ProductDto(id, name,  price,  oldPrice,  stock,  brand);
		
	}
}
