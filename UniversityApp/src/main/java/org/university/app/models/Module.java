package org.university.app.models;

public class Module {
    private int moduleID; // Primary key, auto incremnted
    private String moduleName; // Module name, cannnot be null
    private int level; // Level, should not be null

    // Constructor
    public Module() {}

    public Module(String moduleName, int level) {
        this.moduleName = moduleName;
        this.level = level;
    }

    // Getters and Setters
    public int getModuleID() {
        return moduleID;
    }

    public void setModuleID(int moduleID) {
        this.moduleID = moduleID;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    // toString methid to print info
    @Override
    public String toString() {
        return "Module{" +
                "moduleID=" + moduleID +
                ", moduleName='" + moduleName + '\'' +
                ", level=" + level +
                '}';
    }
}
