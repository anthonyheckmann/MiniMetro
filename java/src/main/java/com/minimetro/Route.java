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

    private String toGraph() {
        Terminal to = null;

        StringBuilder sb = new StringBuilder();
        for(Segment segment : segments) {
            if(sb.length() > 0) {
                sb.append("--->");
            }

            if(!segment.getFromTerminal().equals(to)) {
                sb.append(segment.getFromTerminal());
                sb.append("--->");
            }

            sb.append(segment.getToTerminal());

            to = segment.getToTerminal();
        }

        return sb.toString();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Route{");
        sb.append(toGraph());
        sb.append(")");

        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Route route = (Route) o;

        if (segments != null ? !segments.equals(route.segments) : route.segments != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        return segments != null ? segments.hashCode() : 0;
    }
}
