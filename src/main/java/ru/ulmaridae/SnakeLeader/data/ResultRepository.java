package ru.ulmaridae.SnakeLeader.data;

import ru.ulmaridae.SnakeLeader.UserResult;

import java.util.List;

public interface ResultRepository {
    double getPercent(long score);
    UserResult save(UserResult userResult);
    List<UserResult> getTopTen();
}
