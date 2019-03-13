package com.mrhmt.dao;

import com.mrhmt.models.Book;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class BookDAO {
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Book> readAll() {
        String sql = "SELECT * FROM book";
        List<Book> list = jdbcTemplate.query(sql, new BookMapper());

        return list;
    }

    public Book read(int id) {
        String sql = "SELECT * FROM book WHERE ID = ?";
        Book book = jdbcTemplate.queryForObject(sql, new Object[]{id}, new BookMapper());

        return book;
    }

    public void create(Book book) {
        String sql = "INSERT INTO book (name, author, releasedate) values (?, ?, ?)";
        jdbcTemplate.update(sql, book.getName(), book.getAuthor(), book.getReleasedate());
    }

    public void update(Book book) {
        String sql = "UPDATE book SET name = ?, author = ?, releasedate = ? WHERE id = ?";
        jdbcTemplate.update(sql, book.getName(), book.getAuthor(), book.getReleasedate(), book.getId());
    }

    public void delete(int id) {
        String sql = "DELETE FROM book WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}
