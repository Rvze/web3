package com.example.web3.db;

import com.example.web3.models.Point;

import java.util.List;

public interface DAO {
    boolean addPoint(Point point);

    List<Point> getAll();

    List<Point> getHead(int i);

    void clear();
}
