package com.javaproject.gymmanagement.Controller;

import com.javaproject.gymmanagement.Model.Attendance;
import com.javaproject.gymmanagement.Service.AttendanceService;

import java.util.List;

public class AttendanceController {

    private final AttendanceService attendanceService;

    public AttendanceController(AttendanceService attendanceService) {
        this.attendanceService = attendanceService;
    }

    public void checkIn(int memberId) {

        attendanceService.checkIn(memberId);
    }

    public void checkOut(int memberId) {

        attendanceService.checkOut(memberId);
    }

    public List<Attendance> findAll() {

        return attendanceService.findAll();
    }

    public List<Attendance> findByMemberId(int memberId) {

        return attendanceService.findByMemberId(memberId);
    }
}