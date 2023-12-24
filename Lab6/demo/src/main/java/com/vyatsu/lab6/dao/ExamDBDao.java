package com.vyatsu.lab6.dao;

import com.vyatsu.lab6.entity.EnrolleeEntity;
import com.vyatsu.lab6.entity.ExamEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ExamDBDao implements Dao<ExamEntity> {
    private final H2Connection h2Connection;

    public ExamDBDao() {
        h2Connection = H2Connection.getH2Connection();
        try (Statement statement = h2Connection.getConnection().createStatement()) {
            statement.execute(
                    """
                            CREATE TABLE IF NOT EXISTS EXAM (
                                enrolleeId NUMBER NOT NULL,
                                subject VARCHAR(30) NOT NULL,
                                score NUMBER NOT NULL,
                                PRIMARY KEY (enrolleeId, subject)
                            );

                            INSERT INTO EXAM (enrolleeId, subject, score)
                            VALUES
                                (1, 'Русский язык', 60),
                                (1, 'Математика', 60),
                                (1, 'Информатика', 60),
                                (2, 'Русский язык', 60),
                                (2, 'Математика', 60),
                                (2, 'Информатика', 60),
                                (3, 'Русский язык', 60),
                                (3, 'Математика', 60),
                                (3, 'Информатика', 60);
                                                        """);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public int size() {
        try (Statement statement = h2Connection.getConnection().createStatement()) {
            String s = "SELECT COUNT * FROM EXAM";
            return statement.executeQuery(s).getInt(1);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return -1; // TODO: TEST SIZE
    }

    @Override
    public Optional<ExamEntity> get(int id) {
        try (Statement statement = h2Connection.getConnection().createStatement()) {
            String s = """
                    SELECT * FROM EXAM WHERE ENROLLEID = %d
                    """.formatted(id);
            statement.execute(s);

            ResultSet queryResult = statement.executeQuery(s);
            return Optional.of(
                    ExamEntity.builder()
                            .subject(queryResult.getString("SUBJECT"))
                            .score(queryResult.getInt("SCORE"))
                            .enrolleeId(queryResult.getInt("ENROLLEEID"))
                            .build());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<ExamEntity> getAll() {
        try (Statement statement = h2Connection.getConnection().createStatement()) {
            List<ExamEntity> examEntities = new ArrayList<>();
            ResultSet resultSet = statement.executeQuery("select * from EXAM");

            while (resultSet.next()) {
                examEntities.add(
                        ExamEntity.builder()
                                .subject(resultSet.getString("SUBJECT"))
                                .score(resultSet.getInt("SCORE"))
                                .enrolleeId(resultSet.getInt("ENROLLEEID"))
                                .build());
            }
            return examEntities;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    @Override
    public void save(ExamEntity examEntity) {
        try (Statement statement = h2Connection.getConnection().createStatement()) {
            statement.execute(
                    """
                            INSERT INTO EXAM (SUBJECT, SCORE, ENROLLEEID)
                            VALUES(%s, %d, %d)
                            """.formatted(examEntity.getSubject(), examEntity.getScore(), examEntity.getEnrolleeId()));

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(ExamEntity examEntity) {
        try (Statement statement = h2Connection.getConnection().createStatement()) {
            String s = """
                    DELETE FROM ENROLLEE WHERE ENROLLEEID=%d AND SUBJECT=%s
                    """.formatted(examEntity.getEnrolleeId(), examEntity.getSubject());
            statement.execute(s);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<ExamEntity> getEnrolleeExams(int enrolleeId) {
        List<ExamEntity> exams = new ArrayList<>();
        ResultSet queryResult;
        try (Statement statement = h2Connection.getConnection().createStatement()) {
            queryResult = statement.executeQuery(
                    """
                            SELECT * FROM EXAM WHERE enrolleeId=%d
                            """.formatted(enrolleeId));

            while (queryResult.next()) {
                exams.add(ExamEntity.builder()
                        .subject(queryResult.getString("SUBJECT"))
                        .score(queryResult.getInt("SCORE"))
                        .enrolleeId(queryResult.getInt("enrolleeId"))
                        .build());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exams;
    }
}
