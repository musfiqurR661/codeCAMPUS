package com.example.project;

public class Announcement {
    String CFNAME;
    String CFDATE;
    String CCNAME;
    String CCDATE;
    String VJNAME;
    String VJDATE;

    public Announcement(String CFNAME, String CFDATE, String CCNAME, String CCDATE, String VJNAME, String VJDATE) {
        this.CFNAME = CFNAME;
        this.CFDATE = CFDATE;
        this.CCNAME = CCNAME;
        this.CCDATE = CCDATE;
        this.VJNAME = VJNAME;
        this.VJDATE = VJDATE;
    }

    public void setCFNAME(String CFNAME) {

        this.CFNAME = CFNAME;
    }

    public void setCFDATE(String CFDATE) {

        this.CFDATE = CFDATE;
    }

    public void setCCNAME(String CCNAME) {

        this.CCNAME = CCNAME;
    }

    public void setCCDATE(String CodeCDATE) {

        this.CCDATE = CodeCDATE;
    }

    public void setVJNAME(String VJNAME) {
        this.VJNAME = VJNAME;
    }

    public void setVJDATE(String VJDATE) {
        this.VJDATE = VJDATE;
    }

    public String getCFNAME() {

        return CFNAME;
    }

    public String getCFDATE() {

        return CFDATE;
    }

    public String getCCNAME() {
        return CCNAME;
    }

    public String getCCDATE() {
        return CCDATE;
    }

    public String getVJNAME() {
        return VJNAME;
    }

    public String getVJDATE() {
        return VJDATE;
    }
}
