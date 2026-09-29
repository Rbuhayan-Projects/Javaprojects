package com.javaproject.gymmanagement.Service;

import com.javaproject.gymmanagement.Model.Attendance;
import com.javaproject.gymmanagement.Repository.AttendanceRepo;

import java.time.LocalTime;
import java.util.List;

public class AttendanceService {

    private final AttendanceRepo attendanceRepo;

    public AttendanceService(AttendanceRepo attendanceRepo) {
        this.attendanceRepo = attendanceRepo;
    }

    public List<Attendance> findAll() {
        return attendanceRepo.findAll();
    }

    public List<Attendance> findByMemberId(int memberId) {

        if (memberId <= 0) {
            throw new IllegalArgumentException(
                    "Invalid member ID."
            );
        }

        if (!attendanceRepo.memberExists(memberId)) {
            throw new IllegalArgumentException(
                    "Member not found."
            );
        }

        return attendanceRepo.findByMemberId(memberId);
    }

    public void checkIn(int memberId) {

        if (memberId <= 0) {
            throw new IllegalArgumentException(
                    "Invalid member ID."
            );
        }

        if (!attendanceRepo.memberExists(memberId)) {
            throw new IllegalArgumentException(
                    "Member not found."
            );
        }

        if (attendanceRepo.isCheckedIn(memberId)) {
            throw new IllegalArgumentException(
                    "Member is already checked in."
            );
        }

        Attendance attendance = new Attendance();

        attendance.setMemberId(memberId);
        attendance.setTimeIn(LocalTime.now());

        attendanceRepo.save(attendance);
    }

    public void checkOut(int memberId) {

        if (memberId <= 0) {
            throw new IllegalArgumentException(
                    "Invalid member ID."
            );
        }

        if (!attendanceRepo.memberExists(memberId)) {
            throw new IllegalArgumentException(
                    "Member not found."
            );
        }

        if (!attendanceRepo.isCheckedIn(memberId)) {
            throw new IllegalArgumentException(
                    "Member is not currently checked in."
            );
        }

        attendanceRepo.checkOut(memberId);
    }
}

