package com.example.web3.models;

import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.time.LocalDateTime;

@Named
@ViewScoped
@Getter
@Setter
public class ClockView implements Serializable {
    private LocalDateTime dateTime;

    @PostConstruct
    public void init() {
        dateTime = LocalDateTime.now().plusYears(37).plusMonths(3).plusHours(4);
    }
}
