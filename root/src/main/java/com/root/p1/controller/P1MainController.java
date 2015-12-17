package com.root.p1.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.root.p1.common.Constants;
import com.root.p1.model.DateModel;
import com.root.p1.service.DateService;

@RestController
public class P1MainController {

    // Class name defination
    private String clazzName = this.getClass().getName();
    
    // Logger defination
    private Logger log = LoggerFactory.getLogger(this.getClass());
    
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
        log.info(Constants.LOGMSG_START_CONTROLLER + clazzName + " currentDate()");
        
        // Get current date
        DateModel date = dateService.getCurrentDateFromNamed();
        
        log.info(Constants.LOGMSG_END_CONTROLLER + clazzName + " currentDate()");
        return date;
    }
}
