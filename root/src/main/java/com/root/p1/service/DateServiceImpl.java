package com.root.p1.service;

import java.util.Arrays;
import java.util.Calendar;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.root.p1.model.DateModel;

@Service
public class DateServiceImpl implements DateService {
    // Format patern
    private final int YYYYMMDD = 1;
    private final int YYYYMMDD_HHMISS = 2;

    /**
     * Create DateModel of current date
     */
    @Override
    public DateModel createCurrentDate() {
        // Get instance of calendar
        Calendar calendar = Calendar.getInstance();
        // Create date model
        DateModel date = setDateByFormat(calendar, YYYYMMDD_HHMISS);

        return date;
    }

    /**
     * Setting date by format
     * 
     * @param calendar
     * @param format
     * @return DateModel
     */
    private DateModel setDateByFormat(Calendar calendar, int format) {
        // Setting date by format
        DateModel date = new DateModel();
        date.setYyyy(String.valueOf(calendar.get(Calendar.YEAR)));
        date.setMm(String.valueOf(calendar.get(Calendar.MONTH)));
        date.setDd(String.valueOf(calendar.get(Calendar.DAY_OF_MONTH)));
        if (format == YYYYMMDD) {

        } else if (format == YYYYMMDD_HHMISS) {
            date.setHh(String.valueOf(calendar.get(Calendar.HOUR_OF_DAY)));
            date.setMi(String.valueOf(calendar.get(Calendar.MINUTE)));
            date.setSs(String.valueOf(calendar.get(Calendar.SECOND)));
        }

        return date;
    }

    /**
     * Get current date from named.com
     * @return: DateModel
     */
    @Override
    public DateModel getCurrentDateFromNamed() {
        String url = "http://named.com/game/ladder/ajax/timer.php";
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.ALL));
        headers.set(HttpHeaders.USER_AGENT, "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.106 Safari/537.36");
        HttpEntity<String> requestEntity = new HttpEntity<String>(headers);  
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> result = restTemplate.exchange(url, HttpMethod.GET, requestEntity, String.class);

        DateModel date = new Gson().fromJson(result.getBody(), DateModel.class);
        
        return date;
    }

}
