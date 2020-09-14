package ru.ulmaridae.SnakeLeader.data;

import ru.ulmaridae.SnakeLeader.UserResult;

import java.util.List;

public class JdbcResultRepository implements ResultRepository {
    @Override
    public double getPercent(long score) {
        return 0;
    }

    @Override
    public UserResult save(UserResult userResult) {
        return null;
    }

    @Override
    public List<UserResult> getTopTen() {
        return null;
    }
}
