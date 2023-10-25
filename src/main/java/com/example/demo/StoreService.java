package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreService {

    private final StoreRepository storeRepository;

    @Autowired
    public StoreService(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    public List<Store> getAllStores() {
        return storeRepository.findAll();
    }

    public Store getStoreById(int id) {
        return storeRepository.findById(id);
    }

    public void addStore(Store store) {
        storeRepository.save(store);
    }

    public void updateStore(int id, Store updatedStore) {
        Store store = storeRepository.findById(id);
        if (store != null) {
            store.setName(updatedStore.getName());
            store.setAddress(updatedStore.getAddress());
            store.setPhone(updatedStore.getPhone());
            store.setEmail(updatedStore.getEmail());
            store.setWebsite(updatedStore.getWebsite());
            store.setCategory(updatedStore.getCategory());
            store.setDescription(updatedStore.getDescription());
            storeRepository.save(store);
        }
    }

    public void deleteStore(int id) {
        storeRepository.deleteById(id);
    }

    public List<Store> searchStores(String query) {
        return storeRepository.findByNameContainingOrCategoryContainingOrAddressContaining(query, query, query);
    }
}
