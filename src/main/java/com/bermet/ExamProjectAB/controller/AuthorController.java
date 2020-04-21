package com.bermet.ExamProjectAB.controller;


import com.bermet.ExamProjectAB.entity.Author;
import com.bermet.ExamProjectAB.jdbc.AuthorJdbc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthorController {

    @Autowired
    AuthorJdbc authorJdbc;

    @GetMapping(value = "/authorGet")
    public String get(){
        return "HTTP GET was called. All authors "+authorJdbc.findAllAuthors();
    }

    @PostMapping(value = "/authorPost")
    public String post(@RequestBody Author author){
        return "HTTP POST was called. "+authorJdbc.insertAuthor(author)+" WAS INSERTED";
    }

    @PutMapping(value = "/authorPut")
    public String put(@RequestBody Author author){
        authorJdbc.updateAuthor(author);
        return "HTTP PUT was called. "+author.toString()+" WAS UPDATED";
    }

    @DeleteMapping(value = "/authorDelete")
    public String delete(@RequestBody Author author){
        authorJdbc.deleteAuthorById(author.getId());
        return  "HTTP DELETE was called. "+author.toString()+" WAS DELETED";
    }
}
