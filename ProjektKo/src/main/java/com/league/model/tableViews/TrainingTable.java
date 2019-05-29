package com.league.model.tableViews;

import java.sql.Date;

public class TrainingTable {
    private Date date;

    public TrainingTable(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
