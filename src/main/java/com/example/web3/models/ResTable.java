package com.example.web3.models;


import com.example.web3.db.DAO;
import com.example.web3.db.PointDAO;
import lombok.Getter;
import lombok.Setter;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Set;

@Named
@Getter
@Setter
@ApplicationScoped
public class ResTable {
    private ArrayList<Point> points;
    @Inject
    private Point point;
    private Validator validator;
    private DAO pointDAO;

    public ResTable() {
        pointDAO = new PointDAO();
//        points = (ArrayList<Point>) pointDAO.getAll();
        getValidate();
    }

    public void add() {
        if (check()) {
            Point handlePoint = handlePoint();
            Set<ConstraintViolation<Point>> violations = validator.validate(point);
            if (violations.size() == 0) {
                if (pointDAO.addPoint(handlePoint)) {
                    points.add(handlePoint);
                }
            }

        }
    }

    public void clear() {
        points.clear();
        points = new ArrayList<>();
    }

    public Point handlePoint() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss dd.MM.yyyy");
        Point curPoint = Point.builder()
                .x(point.getX())
                .y(point.getY())
                .r(point.getR())
                .time(simpleDateFormat.format(new Date(System.currentTimeMillis())))
                .build();
        PointHandler handler = new PointHandler(curPoint);
        handler.handle();
        return curPoint;
    }

    public Double aDouble(Point point) {
        return Double.parseDouble(String.valueOf(point.getX()));
    }

    private boolean check() {
        return point != null && point.getY() != null && point.getR() != null;
    }

    private void getValidate() {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
    }


}
