package com.bookStore.controller;

import com.bookStore.entity.Book;
import com.bookStore.entity.MyBookList;
import com.bookStore.service.BookService;
import com.bookStore.service.MyBookListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookService bService;

    @Autowired
    private MyBookListService myBService;
    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/book_register")
    public String bookRegister() {
        return"bookRegister";
    }

    @GetMapping("/available_books")
    public ModelAndView availableBook() {
        List<Book> bookList = bService.getAllBook();
        // Method 1: Create with Getter and Setter
//        ModelAndView mv = new ModelAndView();
//        mv.setViewName("bookList");
//        mv.addObject("book", bookList);
        // Method 2: Create with only constructor
        return new ModelAndView("bookList", "bookList", bookList);
    }

    @PostMapping("/save")
    public String addBook(@ModelAttribute Book b) {
        bService.save(b);
        return"redirect:/available_books";
    }

    // Method 1 ModelAndView
//    @GetMapping("/my_books")
//    public ModelAndView getMyBooks() {
//        List<MyBookList> myBooks = myBService.getAllMyBook();
//        return new ModelAndView("myBooks", "myBooks", myBooks);
//    }

    // Method 2: Model
    @GetMapping("/my_books")
    public String getMyBooks(Model model) {
        List<MyBookList> myBooks = myBService.getAllMyBook();
        model.addAttribute("myBooks", myBooks);
        return "myBooks";
    }

    @RequestMapping("/my_list/{id}")
    public String getMyList(@PathVariable("id") int id) {
        Book book = bService.getBookById(id);
        MyBookList myBookList = new MyBookList(book.getId(), book.getName(), book.getAuthor(), book.getPrice());
        myBService.saveMyBook(myBookList);
        return "redirect:/my_books";
    }

    @GetMapping("/deleteBook/{id}")
    public String deleteBookById(@PathVariable int id) {
        bService.deleteById(id);
        return "redirect:/available_books";
    }

    @RequestMapping("/editBook/{id}")
    public String editBookById(@PathVariable int id, Model model) {
        Book book = bService.getBookById(id);
        model.addAttribute("book", book);
        return"bookEdit";
    }
}