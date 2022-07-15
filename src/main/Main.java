package main;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        AppointmentChecker a = new AppointmentChecker(new ArrayList<>(List.of(new MeetingAppointment())));
        Gson gson = new Gson();
        gson.toJson(a);
        System.out.println(gson);
    }
}
