package com.javaproject.gymmanagement.Repository;

import com.javaproject.gymmanagement.Model.Attendance;

import java.util.List;

public interface AttendanceRepo {

    void save(Attendance attendance);

    boolean memberExists(int memberId);

    boolean isCheckedIn(int memberId);

    void checkOut(int memberId);

    List<Attendance> findAll();

    List<Attendance> findByMemberId(int memberId);
}