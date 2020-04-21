package com.bermet.ExamProjectAB.jdbc;

import com.bermet.ExamProjectAB.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public class BookJdbc {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Book>findAllBook(){
        return jdbcTemplate.query("SELECT*FROM Book",new BeanPropertyRowMapper<>(Book.class));
    }
    public Book findBookById(int id) {
        return jdbcTemplate.queryForObject("SELECT*FROM Book WHERE id=?", new Object[]{id},
                new BeanPropertyRowMapper<>(Book.class));


    }
    public int deleteBookById(int id){
        return jdbcTemplate.update("DELETE FROM Book WHERE id=?",new Object[]{id});
    }
    public int insertBook(Book newBook){
        return jdbcTemplate.update("insert into book(id, title, publish_date, quantity) "
                + "values(?, ?, ?, ?)", new Object[]{newBook.getId(), newBook.getTitle(),
                new Timestamp(newBook.getPublish_date().getTime()),newBook.getQuantity()});
    }

    public int updateBook(Book book){
        return jdbcTemplate.update("update book set title=?, publish_date=?, quantity=? where id=?",
                new Object[]{book.getTitle(), new Timestamp(book.getPublish_date().getTime()),book.getQuantity(),
                        book.getId()});
    }

}
