package com.bluka1.rest.webservices.restfulwebservices.filtering;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {

    @GetMapping("/filtering")
    public MappingJacksonValue filtering() {
        SomeBean someBean = new SomeBean("value1", "value2", "value3");

        // dynamic filtering
        MappingJacksonValue mappingJacksonValue = getMappingJacksonValue(new MappingJacksonValue(someBean), "field1");

        return mappingJacksonValue;
    }

    @GetMapping("/filtering-list")
    public MappingJacksonValue filteringList() {
        SomeBean someBean1 = new SomeBean("value1", "value2", "value3");
        SomeBean someBean2 = new SomeBean("value4", "value5", "value6");
        SomeBean someBean3 = new SomeBean("value7", "value8", "value9");
        List<SomeBean> someBeans = Arrays.asList(someBean1, someBean2, someBean3);
        MappingJacksonValue mappingJacksonValue = getMappingJacksonValue(new MappingJacksonValue(someBeans), "field2");
        return mappingJacksonValue;
    }

    private MappingJacksonValue getMappingJacksonValue(MappingJacksonValue someBeans, String field2) {
        MappingJacksonValue mappingJacksonValue = someBeans;
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept(field2, "field3");
        FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
        mappingJacksonValue.setFilters(filters);
        return mappingJacksonValue;
    }
}
