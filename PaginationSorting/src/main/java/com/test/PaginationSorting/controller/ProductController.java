package com.test.PaginationSorting.controller;

import com.test.PaginationSorting.dto.APIResponse;
import com.test.PaginationSorting.entity.Product;
import com.test.PaginationSorting.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService service;

    @GetMapping
    private APIResponse<List<Product>> getProducts() {
        List<Product> allProducts = service.findAllProducts();
        return new APIResponse<>(allProducts.size(), allProducts);
    }

    @GetMapping("/filter/{field}")
    private APIResponse<List<Product>> getProductsWithSort(@PathVariable String field) {
        List<Product> allProducts = service.findProductsWithSorting(field);
        return new APIResponse<>(allProducts.size(), allProducts);
    }
    @GetMapping("/pagination/{offSet}/{pageSize}")
    private APIResponse<Page<Product>> getProductsWithSort(@PathVariable int offSet, @PathVariable int pageSize) {
        Page<Product> productsWithPagination = service.findProductsWithPagination(offSet, pageSize);
        return new APIResponse<>(productsWithPagination.getSize(), productsWithPagination);
    }
    @GetMapping("/pagination/{offSet}/{pageSize}/filter/{field}")
    private APIResponse<Page<Product>> getProductsWithSort(@PathVariable int offSet, @PathVariable int pageSize, @PathVariable String field) {
        Page<Product> productsWithPaginationAndSorting = service.findProductsWithPaginationAndSorting(offSet, pageSize, field);
        return new APIResponse<>(productsWithPaginationAndSorting.getSize(), productsWithPaginationAndSorting);
    }
}