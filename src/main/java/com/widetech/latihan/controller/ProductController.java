package com.widetech.latihan.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.widetech.latihan.model.Product;
import com.widetech.latihan.model.User;
import com.widetech.latihan.service.ProductService;
import com.widetech.latihan.service.UserService;



@Controller
public class ProductController {

	@Autowired
	private ProductService productService;

	@RequestMapping("/products")
	public String listProducts(Map<String, Object> map) {
		map.put("product", new Product());
		map.put("productList", productService.getAllProduct());
		return "product";
	}

	@RequestMapping(value = "/product/add", method = RequestMethod.POST)
	public String addProduct(@ModelAttribute("product") Product product, BindingResult result) {
		if (null != product) {
			productService.addProduct(product);
		}
		return "redirect:/products";
	}

	@RequestMapping("/delete-product/{itemCode}")
	public String deleteItemCode(@PathVariable("itemCode") String itemCode) {
		productService.deleteProduct(itemCode);
		return "redirect:/products";
	}

	@RequestMapping("/product/{itemCode}")
	public String showProduct(@PathVariable("itemCode") String itemCode, Map<String, Object> map) {
		Product product = productService.getProductByItemCode(itemCode);
//		 Providing new value for Edit
		map.put("product", product);
		return "product-edit";
	}
	
	@RequestMapping(value = "/product/{itemCode}", method = RequestMethod.POST)
	public String updateProduct(@PathVariable("itemCode") String itemCode, @ModelAttribute("product") Product product, Map<String, Object> map) {
		Product old = productService.getProductByItemCode(itemCode);
//		 Providing new value for Edit
		old.setPrice(product.getPrice());
		old.setDescription(product.getDescription());
		old.setType(product.getType());
		old.setTax(product.getTax());
		productService.updateProduct(old);
		map.put("productList", productService.getAllProduct());
		return "redirect:/products";
	}

	public ProductService getProductService() {
		return productService;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

}