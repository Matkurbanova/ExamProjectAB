package com.bermet.ExamProjectAB.controller;


import com.bermet.ExamProjectAB.entity.Book;
import com.bermet.ExamProjectAB.jdbc.BookJdbc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookController {

    @Autowired
    BookJdbc bookJdbc;

    @GetMapping(value = "/bookGet")
    public String get(){
        return "HTTP GET was called. All books "+bookJdbc.findAllBook();
    }

    @PostMapping(value = "/bookPost")
    public String post(@RequestBody Book book){
        return "HTTP POST was called. "+bookJdbc.insertBook(book)+" WAS INSERTED";
    }

    @PutMapping(value = "/bookPut")
    public String put(@RequestBody Book book){
        bookJdbc.updateBook(book);
        return "HTTP PUT was called. "+book.toString()+" WAS UPDATED";
    }

    @DeleteMapping(value = "/bookDelete")
    public String deleteBook(@RequestBody Book book){
        bookJdbc.deleteBookById(book.getId());
        return  "HTTP DELETE was called. "+book.toString()+" WAS DELETED";
    }
}
