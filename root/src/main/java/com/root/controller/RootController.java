package com.root.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RootController implements ErrorController{

    // Error path
    private static final String PATH = "/error";

    @RequestMapping(value = "/")
    public String index() {
        return "/th/index";
    }
    
    @RequestMapping(PATH)
    public String error(HttpServletResponse response) {
        int status = response.getStatus();
        switch (status) {
            case 403:
                return "/error/403";
            case 404:
                return "/error/404";
            case 500:
                return "/error/500";
        }
        return "/error/error";
    }

    @Override
    public String getErrorPath() {
        return PATH;
    }
}
