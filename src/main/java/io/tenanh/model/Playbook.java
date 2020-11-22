package io.tenanh.model;

import java.util.List;

public class Playbook {
    private Variables vars;

    private List<Role> roles;

    public Variables getVars() {
        return vars;
    }

    public void setVars(Variables vars) {
        this.vars = vars;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
