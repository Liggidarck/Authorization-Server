package com.george.server.cotroller;

import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @PreAuthorize("hasAnyAuthority('GET_OWN_DATA')")
    @GetMapping(value = "/test", produces = MediaType.APPLICATION_JSON_VALUE)
    public Object test() {
        return SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

}
