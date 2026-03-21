package com.example.demo.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;
@Service
public class ProductService {
@Autowired //dependecy injection
ProductRepository repository;
public List<Product> getProducts(){
	//todo auto generated method sub
	return repository.findAll();
}
public Product getProduct(int id) {
	return repository.findById(id).orElse(null);
}
public Product getProductByName(String name) {
	return repository.findByName(name).orElse(null);
}
public Product getProductByCost(double cost) {
	Product product=repository.findByCost(cost).orElse(null);
	System.out.println(product);
	return product;
}
public void addData(Product product) {
	repository.save(product);
}
}
