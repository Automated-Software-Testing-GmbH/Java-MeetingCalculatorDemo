package main;

import main.exception.ArgumentException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class AppointmentChecker {
    private List<MeetingAppointment> calenderMeetings;

    public AppointmentChecker(List<MeetingAppointment> calender) {
        if (calender == null) {
            this.calenderMeetings = null;
            return;
        }
        for (MeetingAppointment m : calender) {
            if (!m.isValid()) {
                calenderMeetings = new ArrayList<>();
                return;
            }
        }
        calenderMeetings = calender;
    }

    /**
     * checks if any given MeetingAppointment fits the current calendar
     *
     * @param meetingToCheck the meeting to check
     * @return true in case of a fit and false if not
     */
    public boolean checkAppointment(MeetingAppointment meetingToCheck) throws RuntimeException {
        if (calenderMeetings == null)
            throw new RuntimeException();
        if (meetingToCheck == null)
            throw new RuntimeException();
        /**if (!meetingToCheck.isValid())
            throw new RuntimeException();**/
        if (calenderMeetings.isEmpty()) {
            return true;
        }
        for (MeetingAppointment m : calenderMeetings) {
            if (m.getStartTime().before(meetingToCheck.getStartTime()) && meetingToCheck.getStartTime().before(m.getEndTime())) {
                return false;
            }
            if (m.getStartTime().before(meetingToCheck.getEndTime()) && meetingToCheck.getEndTime().before(m.getEndTime())) {
                return false;
            }
            if (meetingToCheck.getStartTime().before(m.getStartTime()) && m.getEndTime().before(meetingToCheck.getEndTime())) {
                return false;
            }
        }
        return true;
    }

    /**
     * removes any given meeting from current calendar
     *
     * @param meeting the meeting to remove
     * @return true in case of a success and false in case of failure
     */
    public boolean removeMeeting(MeetingAppointment meeting) {
        if (calenderMeetings == null)
            return false;
        if (meeting == null)
            return false;
        if (!meeting.isValid())
            return false;
        if (calenderMeetings.contains(meeting)) {
            calenderMeetings.remove(meeting);
            return true;
        }
        return false;
    }

    /**
     * changes start and end time of any given meeting that is also part of the current calendar
     *
     * @param meeting the meeting to change
     * @param start   the new start date
     * @param end     the new end date
     * @return true in case of a success and false in case of failure
     */
    public boolean changeMeeting(MeetingAppointment meeting, Calendar start, Calendar end) {
        if (end.before(start))
            return false;
        if (calenderMeetings.contains(meeting)) {
            meeting.setStartTime(start);
            meeting.setEndTime(end);
            return true;
        }
        return false;
    }

    /**
     * adds any given meeting to the calendar
     *
     * @param meetingToCheck the meeting to add
     * @return true in case of a success and false in case of failure
     */
    public boolean addMeeting(MeetingAppointment meetingToCheck) throws NoSuchFieldException {
        if (this.checkAppointment(meetingToCheck)) {
            calenderMeetings.add(meetingToCheck);
            return true;
        }
        return false;
    }
}
