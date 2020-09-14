package ru.ulmaridae.SnakeLeader.data;

import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import ru.ulmaridae.SnakeLeader.UserResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Repository
public class JdbcResultRepository implements ResultRepository {

    private JdbcTemplate jdbc;

    @Autowired
    public JdbcResultRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public double getPercent(long score) {
        return 0;
    }

    @Override
    public UserResult save(UserResult userResult) {
        userResult.setDate(new Date());
        jdbc.update(
                "insert into Results_Table (id, name, score, playedAt) values (?, ?, ?, ?)",
                userResult.getId(),
                userResult.getUserName(),
                userResult.getUserScore(),
                new Timestamp(userResult.getDate().getTime()));
        return userResult;
    }

    @Override
    public List<UserResult> getTopTen() {
        return null;
    }

    private UserResult mapRowToUserResult(ResultSet rs, int rowNum) throws SQLException {
        return new UserResult() {{
            setId(rs.getLong("id"));
            setUserName(rs.getString("name"));
            setUserScore(rs.getLong("score"));
            setDate(rs.getDate("playedAt"));
        }};
    }
}
