package de.hpi.urlcleaner.api;

import de.hpi.urlcleaner.services.UrlCleanerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor


public class UrlCleanerController {

    private final UrlCleanerService urlCleanerService;

    @RequestMapping(value = "/cleanURL", method = RequestMethod.GET, produces = "application/json")
    public String cleanURL(@RequestParam(value="shopID") long shopID, @RequestParam(value="url") String url) {
        return urlCleanerService.cleanUrl(url, shopID);
    }

}
