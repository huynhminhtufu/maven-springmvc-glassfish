package com.mrhmt.controller;

import com.mrhmt.dao.BookDAO;
import com.mrhmt.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.sql.SQLException;

@Controller
@RequestMapping(value = "/book")
public class BookController {
    @Autowired
    @Qualifier("bookDao")
    private BookDAO bookDAO;

    public BookDAO getBookDAO() {
        return bookDAO;
    }

    public void setBookDAO(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView index() throws SQLException {
        return new ModelAndView("/book/index", "listBook", bookDAO.readAll());
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView create() {
        return new ModelAndView("/book/create", "book", new Book());
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@Valid @ModelAttribute("book")Book book, BindingResult result, ModelMap mm) throws SQLException {
        if (result.hasErrors()) {
            return "errors";
        }

        bookDAO.create(book);
        return "redirect:index";
    }

    @RequestMapping(value = "/details", method = RequestMethod.GET)
    public ModelAndView details(@RequestParam(value = "id", required = false) int id) throws SQLException {
        return new ModelAndView("/book/details", "book", bookDAO.read(id));
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView edit(@RequestParam(value = "id", required = false) int id) throws SQLException {
        return new ModelAndView("/book/edit", "book", bookDAO.read(id));
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String edit(@Valid @ModelAttribute("book")Book book, BindingResult result, ModelMap mm) throws SQLException {
        if (result.hasErrors()) {
            return "error";
        }

        bookDAO.update(book);
        return "redirect:index";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(@RequestParam(value = "id", required = false) int id) throws SQLException {
        bookDAO.delete(id);

        return "redirect:index";
    }
}
