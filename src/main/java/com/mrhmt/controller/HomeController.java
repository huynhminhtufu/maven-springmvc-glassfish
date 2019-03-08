package com.mrhmt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/home")
public class HomeController {
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        return "/home/index";
    }

    @RequestMapping(value = "/pushdata", method = RequestMethod.GET)
    public String pushDataToView(ModelMap mm) {
        mm.put("info", "Huynh Nam");
        mm.put("number", 123456);

        return "/home/show";
    }


    @RequestMapping(value = "/getFromGET", method = RequestMethod.GET)
    public String getDataFromRequestGET(
        @RequestParam(value = "id", required = false) int code,
        @RequestParam(value = "name", required = false) String fullname,
        ModelMap mm) {

        mm.put("code", code);
        mm.put("fullname", fullname);

        return "home/fromget";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register() {
        return "/home/register";
    }

    @RequestMapping(value = "/getFromPOST", method = RequestMethod.POST)
    public String getDataFromRequestPOST (@RequestParam(value = "id", required = false) int code, @RequestParam(value = "name", required = false) String fullname, ModelMap mm) {
        mm.put("code", code);
        mm.put("fullname", fullname);

        return "/home/result";
    }
}
