package com.vyatsu.lab6.dao;

import com.vyatsu.lab6.entity.EnrolleeEntity;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EnrolleeDBDao implements Dao<EnrolleeEntity> {
    private final H2Connection h2Connection;

    public EnrolleeDBDao() {
        h2Connection = H2Connection.getH2Connection();
        try (Statement statement = h2Connection.getConnection().createStatement()) {
            String s = """
                    CREATE TABLE IF NOT EXISTS ENROLLEE (
                        id INT PRIMARY KEY NOT NULL,
                        birthday DATE NOT NULL,
                        fullName VARCHAR(50) NOT NULL
                    );

                    INSERT INTO ENROLLEE (id, birthday, fullName)
                    VALUES
                        (1, '2003-07-21', 'Панкратов Юрий Алексеевич'),
                        (2, '2004-08-22', 'Вангер Варвава Олеговна'),
                        (3, '2001-01-01', 'Крондштат Брайер Алукардовна');
                        """;
            statement.execute(s);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public int size() {
        try (Statement statement = h2Connection.getConnection().createStatement()) {
            String s = "SELECT COUNT * FROM ENROLLEE";
            return statement.executeQuery(s).getInt(1);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return -1; // TODO: TEST SIZE
    }

    @Override
    public Optional<EnrolleeEntity> get(int id) {
        String query = "SELECT * FROM ENROLLEE WHERE ID = ?";
        try (PreparedStatement statement = h2Connection.getConnection().prepareStatement(query)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return Optional.of(
                        EnrolleeEntity.builder()
                                .id(resultSet.getInt("ID"))
                                .fullName(resultSet.getString("FULLNAME"))
                                .birthday(resultSet.getDate("BIRTHDAY"))
                                .build());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<EnrolleeEntity> getAll() {
        try (Statement statement = h2Connection.getConnection().createStatement()) {
            List<EnrolleeEntity> enrolleeEntities = new ArrayList<>();
            ResultSet resultSet = statement.executeQuery("select * from ENROLLEE");

            while (resultSet.next()) {
                enrolleeEntities.add(
                        EnrolleeEntity.builder()
                                .id(resultSet.getInt("id"))
                                .fullName(resultSet.getString("fullName"))
                                .birthday(resultSet.getDate("birthday"))
                                .build());
            }
            return enrolleeEntities;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    @Override
    public void save(EnrolleeEntity enrollee) {
        try (Statement statement = h2Connection.getConnection().createStatement()) {
            String s = """
                    INSERT INTO ENROLLEE (ID, FULLNAME, BIRTHDAY)
                    VALUES(%d, %s, %s)
                    """.formatted(enrollee.getId(), enrollee.getFullName(), enrollee.getBirthday());
            statement.execute(s);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(EnrolleeEntity enrollee) {
        try (Statement statement = h2Connection.getConnection().createStatement()) {
            String s = """
                    DELETE FROM ENROLLEE WHERE ID=%d
                    """.formatted(enrollee.getId());
            statement.execute(s);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
