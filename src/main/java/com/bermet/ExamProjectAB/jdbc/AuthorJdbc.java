package com.bermet.ExamProjectAB.jdbc;

import com.bermet.ExamProjectAB.entity.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AuthorJdbc {

    @Autowired
    JdbcTemplate jdbcTemplate;

public List<Author>findAllAuthors() {
    return jdbcTemplate.query("SELECT * FROM Author",new BeanPropertyRowMapper<>(Author.class));

}
public Author findAuthorById(int id){
return jdbcTemplate.queryForObject("SELECT*FROM Author WHERE id=?",new Object[]{id},new BeanPropertyRowMapper<>(Author.class) );
}
    public int deleteAuthorById(int id) {
        return  jdbcTemplate.update("DELETE FROM Author WHERE id=?",
                new Object[]{id});


    }


    public int insertAuthor(Author newAuthor) {
        return jdbcTemplate.update("insert into author " +
                        "(id, name, surname, email, password) " + "values(?, ?, ?, ?, ?)"
                , newAuthor.getId()
                , newAuthor.getName()
                , newAuthor.getSurname()
                , newAuthor.getEmail()
                , newAuthor.getPassword());
    }


    public int updateAuthor(Author author){
        return jdbcTemplate.update("update author set name=?, surname=?, email=?,password=? where id=?",
                new Object[]{author.getName(), author.getSurname(),author.getEmail(),author.getPassword(),
                        author.getId()});
    }


}
