package com.patel.helpifymp.Models;

public class ProfessionalHelp {

    public String DMobile;
    String DName, DSpecilize , DExperience;

    public ProfessionalHelp(String DMobile) {
        this.DMobile = DMobile;
    }

    public ProfessionalHelp(){};

    public String getDName() {
        return DName;
    }

    public void setDName(String DName) {
        this.DName = DName;
    }

    public String getDSpecilize() {
        return DSpecilize;
    }

    public void setDSpecilize(String DSpecilize) {
        this.DSpecilize = DSpecilize;
    }

    public String getDExperience() {
        return DExperience;
    }

    public void setDExperience(String DExperience) {
        this.DExperience = DExperience;
    }

    public String getDMobile() {
        return DMobile;
    }

    public void setDMobile(String DMobile) {
        this.DMobile = DMobile;
    }
}
