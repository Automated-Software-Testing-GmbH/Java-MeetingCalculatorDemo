package main;

import java.util.Calendar;

public class MeetingAppointment {

    private Calendar startTime;
    private Calendar endTime;
    private String appointmentText;
    private MeetingType typeOfMeeting;

    public Calendar getStartTime() {
        return startTime;
    }

    public void setStartTime(Calendar startTime) {
        this.startTime = startTime;
    }

    public Calendar getEndTime() {
        return endTime;
    }

    public void setEndTime(Calendar endTime) {
        this.endTime = endTime;
    }

    public String getAppointmentText() {
        return appointmentText;
    }

    public void setAppointmentText(String appointmentText) {
        this.appointmentText = appointmentText;
    }

    public MeetingType getTypeOfMeeting() {
        return typeOfMeeting;
    }

    public void setTypeOfMeeting(MeetingType typeOfMeeting) {
        this.typeOfMeeting = typeOfMeeting;
    }

    public MeetingAppointment(){
        startTime = Calendar.getInstance();
        endTime = Calendar.getInstance();
        endTime.set(Calendar.HOUR, endTime.get(Calendar.HOUR)+1);
        appointmentText = "new Meeting reserved";
    }

    public MeetingAppointment(Calendar start, Calendar end){
        startTime = start;
        endTime = end;
    }

    public MeetingAppointment(Calendar start, Calendar end, String appointmentText){
        startTime = start;
        endTime = end;
        this.appointmentText = appointmentText;
    }

    public MeetingAppointment(Calendar start, Calendar end, String appointmentText, MeetingType type){
        startTime = start;
        endTime = end;
        this.appointmentText = appointmentText;
        typeOfMeeting = type;
    }

    @Override
    public boolean equals(Object obj){
        try{
            MeetingAppointment meeting = (MeetingAppointment) obj;
            if(meeting.startTime == this.startTime && meeting.endTime == this.endTime && meeting.appointmentText == this.appointmentText && meeting.typeOfMeeting == this.typeOfMeeting){
                return true;
            }
        }catch (Exception e){}
        return this==obj;
    }

    public boolean isValid(){
        if(this.startTime.before(this.endTime))
            return true;
        return false;
    }
}
