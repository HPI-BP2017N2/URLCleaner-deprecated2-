package de.hpi.urlcleaner.services;

import org.junit.Before;
import org.junit.Test;

import java.net.MalformedURLException;

import static org.junit.Assert.*;

public class UrlCleanerServiceTest {

    UrlCleanerService urlCleanerService;

    @Before
    public void setup(){
       urlCleanerService = new UrlCleanerService();

    }

    @Test
    public void cleanUrl() throws MalformedURLException {

        assertEquals("Unexpected Clean URL Result","http://www.google.de/123", urlCleanerService.cleanUrl("http://www.google.de/" , 123));

    }

    @Test(expected = MalformedURLException.class)
    public void cleanURLwithExpectedException() throws MalformedURLException {
         urlCleanerService.cleanUrl("bla" , 123);

    }

}
