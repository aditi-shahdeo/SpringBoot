package com.target.repository;

import com.target.entity.Supplier;
import org.springframework.data.repository.CrudRepository;

public interface SupplierRepository extends CrudRepository<Supplier, Integer> {
}