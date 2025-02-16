package com.ankit.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.ankit.entity.Product;

public interface IProductService {
	public String registerProduct(Product prod);
	public String registerMultipleProduct(List<Product> prodList);
	public String fetchProductById(String id);
	public List<Product> showAllProductDetails();
	public String updateProductById(String id,Double newPrice);
	public List<Product> showAllProductBySorting(boolean asc,String...prop);
	public Page<Product> showAllProductBySortingAndPagging(int pageSize,int pageNo,boolean asc,String...props);
}
