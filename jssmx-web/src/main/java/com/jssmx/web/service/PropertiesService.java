package com.jssmx.web.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PropertiesService {
    @Value("${JSSMX_SSO_URL}")
    public String JSSMX_SSO_URL;
}
