package com.example.shrawanwable.objectbox.models;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SelectableTimeUnit {
    String title;
    TimeUnit timeUnit;

    public SelectableTimeUnit() {
    }

    public SelectableTimeUnit(String title, TimeUnit timeUnit) {
        this.title = title;
        this.timeUnit = timeUnit;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public TimeUnit getTimeUnit() {
        return timeUnit;
    }

    public void setTimeUnit(TimeUnit timeUnit) {
        this.timeUnit = timeUnit;
    }

    public static List<SelectableTimeUnit> getList() {
        List<SelectableTimeUnit> l = new ArrayList<>();
        l.add(new SelectableTimeUnit("Seconds", TimeUnit.SECONDS));
        l.add(new SelectableTimeUnit("Minutes", TimeUnit.MINUTES));
        l.add(new SelectableTimeUnit("Hours", TimeUnit.HOURS));
        l.add(new SelectableTimeUnit("Days", TimeUnit.DAYS));
        return l;
    }

    @Override
    public String toString() {
        return getTitle();
    }
}
