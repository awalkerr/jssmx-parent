package com.jssmx.manage.service.base;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PropertiesService {
    @Value("${JSSMX_SSO_URL}")
    public String JSSMX_SSO_URL;

    @Value("${USER_PHOTO_URL}")
    public String USER_PHOTO_URL;

    @Value("${SYS_ADMIN_NAME}")
    public String SYS_ADMIN_NAME;

    @Value("${SYS_NAME}")
    public String SYS_NAME;

    @Value("${WEBSOCKET}")
    public String WEBSOCKET;
}
