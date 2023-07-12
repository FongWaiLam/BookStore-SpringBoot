package com.bookStore.service;

import com.bookStore.entity.MyBookList;
import com.bookStore.repository.MyBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyBookListService {

    @Autowired
    private MyBookRepository myBookRepo;

    public void saveMyBook(MyBookList book){
        myBookRepo.save(book);
    }

    public List<MyBookList> getAllMyBook() {
        return myBookRepo.findAll();
    }

    public void deleteById(int id) {
        myBookRepo.deleteById(id);
    }
}
