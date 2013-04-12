package org.exadel.bsu.lectures.second.spring.web.controllers;

import org.exadel.bsu.lectures.second.spring.web.model.SampleJson;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/resource")
public class ResourceController {

    @RequestMapping(value = "/text", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
    @ResponseBody
    public String getText() {
        return "some text";
    }

    @RequestMapping(value = "/json", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public SampleJson getJson() {
        return new SampleJson("some name", "some value");
    }

    @RequestMapping(value = "/json/name/{name}/value/{value}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public SampleJson getJsonWithUserData(@PathVariable String name, @PathVariable String value) {
        return new SampleJson(name, value);
    }
}
