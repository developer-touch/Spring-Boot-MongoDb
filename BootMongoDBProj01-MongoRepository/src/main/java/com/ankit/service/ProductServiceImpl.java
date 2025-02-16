package com.ankit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.ankit.entity.Product;
import com.ankit.repository.ProductRepository;

@Service("prodService")
public class ProductServiceImpl implements IProductService{

	public ProductServiceImpl() {
		System.out.println("ProductServiceImpl::0-param constructor");
	}
	
	//inject ProductRepository 
	@Autowired
	private ProductRepository prodRepo;
	
	@Override
	public String registerProduct(Product prod) {
		System.out.println("ProductServiceImpl.registerProduct()");
		String prodId  = prodRepo.save(prod).getId();
		return "product document is added with id value : "+prodId;
	}
	
	@Override
	public String registerMultipleProduct(List<Product> prodList) {
		System.out.println("ProductServiceImpl.registerMultipleProduct()");
		int productSize = prodRepo.saveAll(prodList).size();
		return "no.of product document is inserted : "+productSize;
	}
	
	@Override
	public String fetchProductById(String id) {
		System.out.println("ProductServiceImpl.fetchProductById()");
		//use repository
		Optional<Product> prodOpt = prodRepo.findById(id);
		if(prodOpt.isEmpty()) {
			return "id is not found";
		}
		return prodOpt.get().toString();
	}
	
	@Override
	public List<Product> showAllProductDetails() {
		System.out.println("ProductServiceImpl.showAllProductDetails()");
		//use repository
		return prodRepo.findAll();
	}
	
	@Override
	public String updateProductById(String id, Double newPrice) {
		System.out.println("ProductServiceImpl.updateProductById()");
		//load the object by id
		Optional<Product> prodOpt = prodRepo.findById(id);
		if (prodOpt.isPresent()) {
			Product prod = prodOpt.get();
			prod.setPrice(newPrice);
			//use repository
			prodRepo.save(prod);
			return "Product price is updated with :: "+prod.getPrice();
		}
		return "Invalid id product not found..";
	}
	
	@Override
	public List<Product> showAllProductBySorting(boolean asc, String... prop) {
		System.out.println("ProductServiceImpl.showAllProductBySorting()");
		//create sort object
		Sort sort = Sort.by(asc?Sort.Direction.ASC:Sort.Direction.DESC, prop);
		//use the repository
		return prodRepo.findAll(sort);
	}
	
	@Override
	public Page<Product> showAllProductBySortingAndPagging(int pageSize, int pageNo, boolean asc, String... props) {
		System.out.println("ProductServiceImpl.showAllProductBySortingAndPagging()");
		//create Sort object
		Sort sort = Sort.by(asc?Sort.Direction.ASC:Sort.Direction.DESC, props);
		//create Pageable object
		Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
		//use repository
		Page<Product> prodPage = prodRepo.findAll(pageable);
		return prodPage;
	}
}
