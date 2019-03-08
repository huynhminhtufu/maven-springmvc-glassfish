package com.mrhmt.controller;

import com.mrhmt.dao.HocSinhDAO;
import com.mrhmt.models.HocSinh;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;
import java.sql.SQLException;

@Controller
@RequestMapping(value = "/hocsinh")
public class HocSinhController {
    private final HocSinhDAO hocSinhDAO = new HocSinhDAO();

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public RedirectView none() {
        return new RedirectView("/hocsinh/index");
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView index() throws SQLException {
        return new ModelAndView("/hocsinh/index", "listHocSinh", hocSinhDAO.readAll());
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView create() {
        return new ModelAndView("/hocsinh/create", "hocsinh", new HocSinh());
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@Valid @ModelAttribute("hocsinh")HocSinh hocSinh, BindingResult result, ModelMap model) throws SQLException {
        if (result.hasErrors()) {
            return "errors";
        }

        hocSinhDAO.create(hocSinh);
        return "redirect:index";
    }

    @RequestMapping(value = "/details", method = RequestMethod.GET)
    public ModelAndView details(@RequestParam(value = "id", required = false) int id) throws SQLException {
        return new ModelAndView("/hocsinh/details", "hocsinh", hocSinhDAO.read(id));
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView edit(@RequestParam(value = "id", required = false) int id) throws SQLException {
        return new ModelAndView("/hocsinh/edit", "hocsinh", hocSinhDAO.read(id));
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String edit(@Valid @ModelAttribute("hocsinh")HocSinh hocSinh, BindingResult result, ModelMap mm) throws SQLException {
        if (result.hasErrors()) {
            return "error";
        }

        hocSinhDAO.update(hocSinh);

        return "redirect:index";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(@RequestParam(value = "id", required = false) int id) throws SQLException {
        hocSinhDAO.delete(id);

        return "redirect:index";
    }
}
