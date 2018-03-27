package de.hpi.urlcleaner.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.net.URL;

@Service
@Slf4j
public class UrlCleanerService {


    public String cleanUrl(String url, long shopID) throws MalformedURLException {
        URL url1 = new URL(url);
        log.debug(url1.toString());
        return url + String.valueOf(shopID);
    }
}
