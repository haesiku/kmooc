package com.sk.kmooc.purchase.domain.proxy;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.cloud.netflix.feign.FeignClientProperties.FeignClientConfiguration;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.sk.kmooc.purchase.domain.proxy.dto.product.ProductDTO;

@Service
public class ProductProxy {
 
	@Autowired
	ProductDTOClient productDTOClient;
	
	public ProductDTO findProductDTO(Long id) {
		return productDTOClient.findProduct(id).getContent();
	}

	public Collection<ProductDTO> findAllProductDTOs() {
		return productDTOClient.findAllProducts().getContent();
	}
	
	public Collection<ProductDTO> findAllProductDTOs(int size) {
		return productDTOClient.findAllProducts(size).getContent();
	}
	
	public ProductDTO findProductByName(String name) {
		return productDTOClient.findProduct(name);
	}

	@FeignClient(name="products", url="${service-urls.shop-product}", configuration=FeignClientConfiguration.class)
	interface ProductDTOClient {
		
		@GetMapping("products/{id}")
		Resource<ProductDTO> findProduct(@PathVariable("id") Long id);
		
		@GetMapping("products")
		Resources<ProductDTO> findAllProducts();
		
		@GetMapping("products")
		Resources<ProductDTO> findAllProducts(@RequestParam("size") int size);
		
		@GetMapping("products/search/findByName")
		ProductDTO findProduct(@RequestParam(value="name", required=true) String name);
	}
}

