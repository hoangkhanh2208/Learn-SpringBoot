package com.hoangkhanh.personnelmanager.model.exception;

import java.text.MessageFormat;

public class JobNotFoundException extends RuntimeException {
    
    public JobNotFoundException(Long id) {
        super(MessageFormat.format("Could not find job with id: {0}", id));
    }
}
