package com.root.p1.service;

import com.root.p1.model.DateModel;

public interface DateService {

    DateModel createCurrentDate();
    DateModel getCurrentDateFromNamed();
}
