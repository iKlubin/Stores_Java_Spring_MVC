package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoreRepository extends JpaRepository<Store, Integer> {
    Store findById(int id);

    List<Store> findByNameContainingOrCategoryContainingOrAddressContaining(String name, String category, String address);
}
