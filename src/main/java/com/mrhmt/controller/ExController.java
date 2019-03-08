package com.mrhmt.controller;

import com.mrhmt.models.Ex;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/ex")
public class ExController {
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView ex() {
        return new ModelAndView("/ex/create", "student", new Ex(1, "demo"));
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ModelAndView ex(@RequestParam(value = "id")int id, @RequestParam(value = "name")String name) {
        Ex ex = new Ex(id, name);
        return new ModelAndView("/ex/show", "student", ex);
    }
}
