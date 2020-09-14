package ru.ulmaridae.SnakeLeader;

import lombok.Data;

import java.util.Date;

@Data
public class UserResult {

    private long id;

    private String UserName;

    private long UserScore;

    private Date date;
}
