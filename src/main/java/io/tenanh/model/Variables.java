package io.tenanh.model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Variables {

    private Map<String,Object> properties;

    public Variables(){
        this.properties = new HashMap<>();
    }

    @JsonAnyGetter
    public Map<String,Object> getVariables(){
        return this.properties;
    }

    @JsonAnySetter
    public void setVariables(String name, Object value){
        this.properties.put(name, value);
    }
}
