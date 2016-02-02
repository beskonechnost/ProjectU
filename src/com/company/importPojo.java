package com.company;

import java.util.Date;

/**
 * Created by DanNetoff on 30.01.2016.
 */
public class importPojo {
    private Integer numberFilial;
    private Integer codeFilial;
    private Date loadDate;

    public Date getLoadDate() {
        return loadDate;
    }
    public void setLoadDate(Date loadDate) {
        this.loadDate = loadDate;
    }
    public Integer getNumberFilial() {
        return numberFilial;
    }
    public Integer getCodeFilial() {
        return codeFilial;
    }

    public importPojo() {
    }
    public importPojo(Integer numberFilial, Integer codeFilial, Date loadDate) {
        this.numberFilial = numberFilial;
        this.codeFilial = codeFilial;
        this.loadDate = loadDate;
    }

    public void setCodeFilial(Integer codeFilial) {
        this.codeFilial = codeFilial;
    }
    public void setNumberFilial(Integer numberFilial) {
        this.numberFilial = numberFilial;
    }

    @Override
    public boolean equals(Object o) {
            return false;
    }

    @Override
    public int hashCode() {
        int result = numberFilial != null ? numberFilial.hashCode() : 0;
        result = 31 * result + (codeFilial != null ? codeFilial.hashCode() : 0);
        return result;
    }







}
