package com.minimetro;

import com.google.common.collect.Lists;

import java.util.List;

public class Route {
    private List<Segment> segments = Lists.newArrayList();

    public Route() { }

    public boolean isEmpty() {
        return segments.isEmpty();
    }

    public boolean addSegment(Segment segment) {
        if(segments.contains(segment)) {
            throw new IllegalArgumentException("Segment: " + segment + " cannot already exist in route.");
        }

        return segments.add(segment);
    }

    public boolean removeSegment(Segment segment) {
        return segments.remove(segment);
    }

    public int size() {
        return segments.size();
    }

    public List<Segment> getSegments() {
        return segments;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Route{");

        StringBuilder sbLines = new StringBuilder();
        for(Segment segment : segments) {
            if(sbLines.length() > 0) {
                sbLines.append(" ");
            }

            sbLines.append("from: " + segment.getFromTerminal());
            sbLines.append(" to: " + segment.getToTerminal());
        }

        sb.append(sbLines);
        sb.append(")");
        return sb.toString();
    }
}
