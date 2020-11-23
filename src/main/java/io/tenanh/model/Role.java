package io.tenanh.model;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Role {
    private String name;
    private Variables vars;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Variables getVars() {
        return vars;
    }

    public void setVars(Variables vars) {
        this.vars = vars;
    }
}
