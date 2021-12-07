package com.example.web3.models;

public class PointHandler {
    private final Point point;
    private final float x;
    private final double y;
    private final double r;

    public PointHandler(Point point) {
        this.point = point;
        this.x = point.getX();
        this.y = point.getY();
        this.r = point.getR();
    }

    public boolean isAreaHit() {
        return (x >= 0 && y <= 0 && y >= x - r / 2) ||
                (x <= 0 && y >= 0 && x * x + y * y <= r / 2 * r / 2) ||
                (x >= 0 && y >= 0 && y <= r && x <= r);
    }

    public void handle() {
        point.setHit(isAreaHit());
    }
}
