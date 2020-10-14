package my.toys.bean;

import java.io.File;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import my.toys.entity.Product;
import my.toys.pojos.CsvTransfer;
/**
 * This is csv parser class to read all the products 
 * @author Guru
 *
 */
@Component
public class ProductComponent {
	

	@PostConstruct
    private void setupData() {
        
    }
	/**
	 * This method will parse the csv file and returns list of products
	 * @return list of products
	 * @throws Exception
	 */
	public List<Product> beanBuilderExample() throws Exception {
		CsvTransfer csvTransfer = new CsvTransfer();
	     ColumnPositionMappingStrategy ms = new ColumnPositionMappingStrategy();
	     ms.setType(Product.class);
	     Path path = Paths.get(
	   	      ClassLoader.getSystemResource("product_data.csv").toURI()); 
	     Reader reader = Files.newBufferedReader(path);
	     CsvToBean cb = new CsvToBeanBuilder(reader)
	       .withType(Product.class)
	       .withSkipLines(1)
	       .withMappingStrategy(ms)
	       .build();
	    csvTransfer.setCsvList(cb.parse());
	    reader.close();
	    return csvTransfer.getCsvList();
	}

}
