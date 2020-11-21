package io.tenanh.model;

import java.util.Map;

public class Playbook {
    private Variables vars;
    private Role role;

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Variables getVars() {
        return vars;
    }

    public void setVars(Variables vars) {
        this.vars = vars;
    }
}
