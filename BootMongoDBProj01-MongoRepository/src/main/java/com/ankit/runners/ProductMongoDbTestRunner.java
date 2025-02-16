package com.ankit.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.ankit.entity.Product;
import com.ankit.service.IProductService;

@Component
public class ProductMongoDbTestRunner implements CommandLineRunner{

	public ProductMongoDbTestRunner() {
		System.out.println("ProductMongoDbTestRunner::0-param constructor");
	}
	
	//inject ProductService
	@Autowired
	private IProductService prodService;
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("ProductMongoDbTestRunner.run()");
		
		/*try {
			//create to set product details 
			Product prod = new Product();
			prod.setName("Mouse");
			prod.setPrice(645.0);prod.setRating("3 Star");
			prod.setWarranty("3 Months");prod.setProps(new String[] {"low price","good quality"});
			//invoke the method
			String msg = prodService.registerProduct(prod);
			System.out.println(msg);
		}
		catch (Exception e) {
			e.printStackTrace();
		}*/
		
		/*try {
			//create to set product details 
			Product prod = new Product();
			prod.setName("Table");prod.setType("Plastic");
			prod.setPrice(1200.0);prod.setRating("4 Star");
			prod.setWarranty("Not Avaialble");prod.setProps(new String[] {"low price","good in quality"});
			
			Product prod2 = new Product();
			prod.setName("Chair");prod.setType("Steal");
			prod.setPrice(2100.0);prod.setRating("5 Star");
			prod.setWarranty("Not Avaialble");prod.setProps(new String[] {"in range","good quality","long time working"});
			//invoke the method
			String msg = prodService.registerMultipleProduct(List.of(prod,prod2));
			System.out.println(msg);
		}
		catch (Exception e) {
			e.printStackTrace();
		}*/
		
		/*try {
			//invoke the method
			String msg = prodService.fetchProductById("6765acde98a289409aa1928f");
			System.out.println(msg);
		}
		catch (Exception e) {
			e.printStackTrace();
		}*/
		
		/*try {
			//invoke the method
			prodService.showAllProductDetails().forEach(System.out::println);
		}
		catch (Exception e) {
			e.printStackTrace();
		}*/
		
		/*try {
			//invoke the method
			String msg = prodService.updateProductById("6765acde98a289409aa1928f", 1359.0);
			System.out.println(msg);
		}
		catch (Exception e) {
			e.printStackTrace();
		}*/
		
		/*try {
			//create to set product details 
			Product prod = new Product();
			prod.setId(UUID.randomUUID().toString());
			prod.setName("Charger");
			prod.setPrice(399.0);prod.setRating("4 Star"); prod.setQnty(1);
			prod.setWarranty("2 Months");prod.setProps(new String[] {"low price","good quality"});
			//invoke the method
			String msg = prodService.registerProduct(prod);
			System.out.println(msg);
		}
		catch (Exception e) {
			e.printStackTrace();
		}*/

		/*try {
			//invoke the method
			prodService.showAllProductBySorting(true, "name","price").forEach(System.out::println);
		}
		catch (Exception e) {
			e.printStackTrace();
		}*/
		
		try {
			//invoke the method
			//prodService.showAllProductBySortingAndPagging(2, 0, true, "name").forEach(System.out::println);
			Page<Product> prodPage = prodService.showAllProductBySortingAndPagging(2, 0, true, "name");
			prodPage.stream().map(Product::getName).distinct().forEach(System.out::println);
			System.out.println("------------------------------------");
			System.out.println("no.of element in current page : "+prodPage.getNumberOfElements());
			System.out.println("no.of element in a page : "+prodPage.getTotalPages());
			System.out.println("no.of total element in a page : "+prodPage.getTotalElements());
			System.out.println("no.of current page "+prodPage.getNumber());
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
