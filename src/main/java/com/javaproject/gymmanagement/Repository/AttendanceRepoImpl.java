package com.javaproject.gymmanagement.Repository;

import com.javaproject.gymmanagement.Model.Attendance;
import com.javaproject.gymmanagement.config.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class AttendanceRepoImpl implements AttendanceRepo {

    private final ConnectionFactory connectionFactory;

    public AttendanceRepoImpl(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

    @Override
    public void save(Attendance attendance) {

        String sql = """
                INSERT INTO attendance
                (member_id, time_in)
                VALUES (?, ?)
                """;

        try (
                Connection connection = connectionFactory.openConnection();
                PreparedStatement statement = connection.prepareStatement(sql)
        ) {

            statement.setInt(1, attendance.getMemberId());

            statement.setTime(
                    2,
                    Time.valueOf(attendance.getTimeIn())
            );

            statement.executeUpdate();

        } catch (Exception e) {

            throw new RuntimeException(
                    "Error saving attendance.",
                    e
            );
        }
    }

    @Override
    public List<Attendance> findAll() {

        String sql = """
                SELECT attendance_id,
                       member_id,
                       time_in,
                       time_out
                FROM attendance
                ORDER BY attendance_id DESC
                """;

        List<Attendance> attendances = new ArrayList<>();

        try (
                Connection connection = connectionFactory.openConnection();
                PreparedStatement statement = connection.prepareStatement(sql);
                ResultSet resultSet = statement.executeQuery()
        ) {

            while (resultSet.next()) {

                Attendance attendance = mapRow(resultSet);

                attendances.add(attendance);
            }

            return attendances;

        } catch (Exception e) {

            throw new RuntimeException(
                    "Error finding attendance.",
                    e
            );
        }
    }

    @Override
    public List<Attendance> findByMemberId(int memberId) {

        String sql = """
                SELECT attendance_id,
                       member_id,
                       time_in,
                       time_out
                FROM attendance
                WHERE member_id = ?
                ORDER BY attendance_id DESC
                """;

        List<Attendance> attendances = new ArrayList<>();

        try (
                Connection connection = connectionFactory.openConnection();
                PreparedStatement statement = connection.prepareStatement(sql)
        ) {

            statement.setInt(1, memberId);

            try (ResultSet resultSet = statement.executeQuery()) {

                while (resultSet.next()) {

                    Attendance attendance = mapRow(resultSet);

                    attendances.add(attendance);
                }
            }

            return attendances;

        } catch (Exception e) {

            throw new RuntimeException(
                    "Error finding member attendance.",
                    e
            );
        }
    }

    @Override
    public boolean memberExists(int memberId) {

        String sql = """
                SELECT 1
                FROM members
                WHERE member_id = ?
                """;

        try (
                Connection connection = connectionFactory.openConnection();
                PreparedStatement statement = connection.prepareStatement(sql)
        ) {

            statement.setInt(1, memberId);

            try (ResultSet resultSet = statement.executeQuery()) {

                return resultSet.next();
            }

        } catch (Exception e) {

            throw new RuntimeException(
                    "Error checking member.",
                    e
            );
        }
    }

    @Override
    public boolean isCheckedIn(int memberId) {

        String sql = """
                SELECT 1
                FROM attendance
                WHERE member_id = ?
                  AND time_out IS NULL
                """;

        try (
                Connection connection = connectionFactory.openConnection();
                PreparedStatement statement = connection.prepareStatement(sql)
        ) {

            statement.setInt(1, memberId);

            try (ResultSet resultSet = statement.executeQuery()) {

                return resultSet.next();
            }

        } catch (Exception e) {

            throw new RuntimeException(
                    "Error checking attendance status.",
                    e
            );
        }
    }

    @Override
    public void checkOut(int memberId) {

        String sql = """
                UPDATE attendance
                SET time_out = ?
                WHERE member_id = ?
                  AND time_out IS NULL
                """;

        try (
                Connection connection = connectionFactory.openConnection();
                PreparedStatement statement = connection.prepareStatement(sql)
        ) {

            LocalTime timeOut = LocalTime.now();

            statement.setTime(
                    1,
                    Time.valueOf(timeOut)
            );

            statement.setInt(2, memberId);

            statement.executeUpdate();

        } catch (Exception e) {

            throw new RuntimeException(
                    "Error checking out member.",
                    e
            );
        }
    }

    private Attendance mapRow(ResultSet resultSet) throws Exception {

        Attendance attendance = new Attendance();

        attendance.setAttendanceId(
                resultSet.getInt("attendance_id")
        );

        attendance.setMemberId(
                resultSet.getInt("member_id")
        );

        Time timeIn = resultSet.getTime("time_in");

        if (timeIn != null) {
            attendance.setTimeIn(
                    timeIn.toLocalTime()
            );
        }

        Time timeOut = resultSet.getTime("time_out");

        if (timeOut != null) {
            attendance.setTimeOut(
                    timeOut.toLocalTime()
            );
        }

        return attendance;
    }
}

