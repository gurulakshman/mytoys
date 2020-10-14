package my.toys.dto;


import java.math.BigDecimal;

import com.opencsv.bean.CsvBindByPosition;
/**
 * This class is data transfer Object for Product. 
 * @author Guru 
 *
 */
public class ProductDto {
	
	 private Long id;
	 
	 private String name;
	 
	 private BigDecimal  price;
	 
	 private BigDecimal  oldPrice;
	 
	 private Long stock;
	 
	 private String brand;
	 
	 public ProductDto() {
		 
	 }

	public ProductDto(Long id, String name, BigDecimal price, BigDecimal oldPrice, Long stock, String brand) {
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
}
