package com.wasp.db.model;

import java.util.ArrayList;
import java.util.List;

public class Row {
    private List<String> cells;

    public Row() {
        this.cells = new ArrayList<>();
    }

    public List<String> getCells() {
        return cells;
    }
}