package com.wasp.db.model;

import java.util.ArrayList;
import java.util.List;

public class Row {
    private List<Object> cells;

    public Row() {
        this.cells = new ArrayList<>();
    }

    public List<Object> getCells() {
        return cells;
    }

    public void setCells(List<Object> cells) {
        this.cells = cells;
    }
}