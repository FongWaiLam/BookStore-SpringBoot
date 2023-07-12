package com.bookStore.controller;

import com.bookStore.service.MyBookListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MyBookListController {

    @Autowired
    private MyBookListService myBookService;

    @GetMapping("/deleteMyList/{id}")
    public String deleteBookById(@PathVariable int id) {
        myBookService.deleteById(id);
        return"redirect:/my_books";
    }
}

