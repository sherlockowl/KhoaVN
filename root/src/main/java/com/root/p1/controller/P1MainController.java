package com.root.p1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.root.p1.model.DateModel;
import com.root.p1.service.DateService;

@RestController
public class P1MainController {

    // The services
    @Autowired
    private DateService dateService;

    /**
     * Get current date time
     * @return DateModel
     * @throws Exception 
     */
    @RequestMapping(value="/p1/date")
    public DateModel currentDate() throws Exception {
        // Get current date
        DateModel date = dateService.getCurrentDateFromNamed();
        
        return date;
    }
}
