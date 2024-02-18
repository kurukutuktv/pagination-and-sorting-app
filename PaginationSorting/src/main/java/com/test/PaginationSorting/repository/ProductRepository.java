package com.test.PaginationSorting.repository;

import com.test.PaginationSorting.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
