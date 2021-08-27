package com.hoangkhanh.personnelmanager.model.exception;

import java.text.MessageFormat;

public class PersonnelNotFoundException extends RuntimeException {
    
    public PersonnelNotFoundException(Long id) {
        super(MessageFormat.format("Could not find personnel with id: {0}", id));
    }
}
