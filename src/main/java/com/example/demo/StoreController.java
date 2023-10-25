package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class StoreController {
    private final StoreService storeService;

    @Autowired
    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    @GetMapping("/stores")
    public String showStores(Model model) {
        List<Store> stores = storeService.getAllStores();
        model.addAttribute("stores", stores);
        return "stores";
    }

    @GetMapping("/store/{id}")
    public String showStore(@PathVariable int id, Model model) {
        Store store = storeService.getStoreById(id);
        model.addAttribute("store", store);
        return "store";
    }

    @PostMapping("/addStore")
    public String addStore(@ModelAttribute Store store) {
        storeService.addStore(store);
        return "redirect:/stores";
    }

    @PostMapping("/store/{id}/update")
    public String updateStore(@PathVariable int id, @ModelAttribute("store") Store updatedStore) {
        storeService.updateStore(id, updatedStore);
        return "redirect:/stores";
    }

    @GetMapping("/store/{id}/edit")
    public String editStore(@PathVariable int id, Model model) {
        Store store = storeService.getStoreById(id);
        model.addAttribute("store", store);
        return "editStore";
    }

    @GetMapping("/store/{id}/delete")
    public String deleteStore(@PathVariable int id) {
        storeService.deleteStore(id);
        return "redirect:/stores";
    }

    @GetMapping("/search")
    public String searchStores(@RequestParam(name = "query") String query, Model model) {
        List<Store> stores = storeService.searchStores(query);
        model.addAttribute("stores", stores);
        return "stores";
    }
}

