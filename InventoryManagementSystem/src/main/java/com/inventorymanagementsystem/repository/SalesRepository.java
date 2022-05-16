package com.inventorymanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inventorymanagementsystem.model.Sales;

@Repository
public interface SalesRepository extends JpaRepository<Sales, Long> {

}
