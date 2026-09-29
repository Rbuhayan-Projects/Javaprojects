package com.javaproject.gymmanagement.Model;

import java.time.LocalTime;


public class Attendance {

    private int attendanceId;
    private int memberId;
    private LocalTime timeIn;
    private LocalTime timeOut;

    public Attendance() {
    }

    public Attendance(
            int attendanceId,
            int memberId,
            LocalTime timeIn,
            LocalTime timeOut) {

        this.attendanceId = attendanceId;
        this.memberId = memberId;
        this.timeIn = timeIn;
        this.timeOut = timeOut;
    }

    public int getAttendanceId() {
        return attendanceId;
    }

    public void setAttendanceId(int attendanceId) {
        this.attendanceId = attendanceId;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public LocalTime getTimeIn() {
        return timeIn;
    }

    public void setTimeIn(LocalTime timeIn) {
        this.timeIn = timeIn;
    }

    public LocalTime getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(LocalTime timeOut) {
        this.timeOut = timeOut;
    }
}