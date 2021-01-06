package org.acme.graph.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Path {
    private List<Edge> edgeList;

    public Path() {
        this.edgeList = new ArrayList<>();
    }

    public Path(List<Edge> edgeList) {
        this.edgeList = edgeList;
    }

    public void reversePath() {
        Collections.reverse(this.edgeList);
    }

    public List<Edge> getEdgeList() {
        return edgeList;
    }
}