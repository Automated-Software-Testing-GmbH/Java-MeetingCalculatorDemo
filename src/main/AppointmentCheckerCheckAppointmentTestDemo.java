/*
* DO NOT MODIFY THIS COMMENT
* Generated by devmate
* Test model: f66c2971-3a3c-46f9-bc5c-a3786999ab26
*/

package main;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.lang.UnsupportedOperationException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("Testing Method checkAppointment")
@SuppressWarnings("unused")
public class AppointmentCheckerCheckAppointmentTestDemo {

//region Factories
private static Calendar createDateNow(int hour, int minute) {
	LocalDate now = LocalDate.now();
	Calendar calendar = Calendar.getInstance();
	calendar.set(now.getYear(), now.getMonth().getValue(), now.getDayOfMonth(), hour, minute, 0);
	return calendar;
}
//endregion

//region Test methods
	@DisplayName("checkAppointment")
	@ParameterizedTest(name = "{0} [{index}] expected: ''{3}'' input: ''{1}'', ''{2}''")
	@MethodSource({"ExpectedReturnValueTests"})
	public void checkAppointmentTest(String testDescription, AppointmentChecker instance, MeetingAppointment meetingToCheck, boolean expected) {
		boolean actual = instance.checkAppointment(meetingToCheck);
		assertEquals(expected, actual);
	}
	
	@DisplayName("checkAppointment exception tests")
	@ParameterizedTest(name = "{0} [{index}] expected: throw ''{3}'' input: ''{1}'', ''{2}''")
	@MethodSource({"TestsThrowingException"})
	public void checkAppointmentTestThrowingException(String testDescription, AppointmentChecker instance, MeetingAppointment meetingToCheck, Class<Throwable> expectedException) {
		assertThrows(expectedException, () -> instance.checkAppointment(meetingToCheck));
	}
//endregion

//region Test data
	private static Stream<Arguments> ExpectedReturnValueTests() {
		return Stream.of(
			Arguments.of(
				/* String testDescription = */ "p1:",
				/* AppointmentChecker instance = */ new AppointmentChecker(new ArrayList<>(List.of(new MeetingAppointment(createDateNow(12, 0), createDateNow(13, 0), "Devmate", MeetingType.jobMeeting), new MeetingAppointment(createDateNow(13, 20), createDateNow(13, 40), "break", MeetingType.privatMeeting), new MeetingAppointment(createDateNow(14, 0), createDateNow(16, 0), "Devmate", MeetingType.jobMeeting)))),
				/* MeetingAppointment meetingToCheck = */ new MeetingAppointment(createDateNow(10, 0), createDateNow(11, 0)),
				/* boolean expectedValue = */ true
			),
			Arguments.of(
				/* String testDescription = */ "p2:",
				/* AppointmentChecker instance = */ new AppointmentChecker(new ArrayList<>(List.of(new MeetingAppointment(createDateNow(12, 0), createDateNow(13, 0), "Devmate", MeetingType.jobMeeting), new MeetingAppointment(createDateNow(13, 20), createDateNow(13, 40), "break", MeetingType.privatMeeting), new MeetingAppointment(createDateNow(14, 0), createDateNow(16, 0), "Devmate", MeetingType.jobMeeting)))),
				/* MeetingAppointment meetingToCheck = */ new MeetingAppointment(createDateNow(13, 0), createDateNow(13, 20)),
				/* boolean expectedValue = */ true
			),
			Arguments.of(
				/* String testDescription = */ "p3:",
				/* AppointmentChecker instance = */ new AppointmentChecker(new ArrayList<>(List.of(new MeetingAppointment(createDateNow(12, 0), createDateNow(13, 0), "Devmate", MeetingType.jobMeeting), new MeetingAppointment(createDateNow(13, 20), createDateNow(13, 40), "break", MeetingType.privatMeeting), new MeetingAppointment(createDateNow(14, 0), createDateNow(16, 0), "Devmate", MeetingType.jobMeeting)))),
				/* MeetingAppointment meetingToCheck = */ new MeetingAppointment(createDateNow(16, 0), createDateNow(16, 30)),
				/* boolean expectedValue = */ true
			),
			Arguments.of(
				/* String testDescription = */ "n2: meetingToCheck: does not fit:",
				/* AppointmentChecker instance = */ new AppointmentChecker(new ArrayList<>(List.of(new MeetingAppointment(createDateNow(12, 0), createDateNow(13, 0), "Devmate", MeetingType.jobMeeting), new MeetingAppointment(createDateNow(13, 20), createDateNow(13, 40), "break", MeetingType.privatMeeting), new MeetingAppointment(createDateNow(14, 0), createDateNow(16, 0), "Devmate", MeetingType.jobMeeting)))),
				/* MeetingAppointment meetingToCheck = */ new MeetingAppointment(createDateNow(12, 30), createDateNow(12, 45)),
				/* boolean expectedValue = */ false
			),
			Arguments.of(
				/* String testDescription = */ "n3: meetingToCheck: does not fit:",
				/* AppointmentChecker instance = */ new AppointmentChecker(new ArrayList<>(List.of(new MeetingAppointment(createDateNow(12, 0), createDateNow(13, 0), "Devmate", MeetingType.jobMeeting), new MeetingAppointment(createDateNow(13, 20), createDateNow(13, 40), "break", MeetingType.privatMeeting), new MeetingAppointment(createDateNow(14, 0), createDateNow(16, 0), "Devmate", MeetingType.jobMeeting)))),
				/* MeetingAppointment meetingToCheck = */ new MeetingAppointment(createDateNow(13, 0), createDateNow(13, 30)),
				/* boolean expectedValue = */ false
			),
			Arguments.of(
				/* String testDescription = */ "n4: meetingToCheck: does not fit:",
				/* AppointmentChecker instance = */ new AppointmentChecker(new ArrayList<>(List.of(new MeetingAppointment(createDateNow(12, 0), createDateNow(13, 0), "Devmate", MeetingType.jobMeeting), new MeetingAppointment(createDateNow(13, 20), createDateNow(13, 40), "break", MeetingType.privatMeeting), new MeetingAppointment(createDateNow(14, 0), createDateNow(16, 0), "Devmate", MeetingType.jobMeeting)))),
				/* MeetingAppointment meetingToCheck = */ new MeetingAppointment(createDateNow(13, 30), createDateNow(14, 0)),
				/* boolean expectedValue = */ false
			),
			Arguments.of(
				/* String testDescription = */ "n5: meetingToCheck: does not fit:",
				/* AppointmentChecker instance = */ new AppointmentChecker(new ArrayList<>(List.of(new MeetingAppointment(createDateNow(12, 0), createDateNow(13, 0), "Devmate", MeetingType.jobMeeting), new MeetingAppointment(createDateNow(13, 20), createDateNow(13, 40), "break", MeetingType.privatMeeting), new MeetingAppointment(createDateNow(14, 0), createDateNow(16, 0), "Devmate", MeetingType.jobMeeting)))),
				/* MeetingAppointment meetingToCheck = */ new MeetingAppointment(createDateNow(11, 0), createDateNow(15, 0)),
				/* boolean expectedValue = */ false
			)
		);
	}
	
	private static Stream<Arguments> TestsThrowingException() {
		return Stream.of(
			Arguments.of(
				/* String testDescription = */ "n1: instance: invalid:",
				/* AppointmentChecker instance = */ new AppointmentChecker(null),
				/* MeetingAppointment meetingToCheck = */ new MeetingAppointment(createDateNow(10, 0), createDateNow(11, 0)),
				/* Class<Throwable> expectedException = */ RuntimeException.class
			),
			Arguments.of(
				/* String testDescription = */ "n6: meetingToCheck: invalid:",
				/* AppointmentChecker instance = */ new AppointmentChecker(new ArrayList<>(List.of(new MeetingAppointment(createDateNow(12, 0), createDateNow(13, 0), "Devmate", MeetingType.jobMeeting), new MeetingAppointment(createDateNow(13, 20), createDateNow(13, 40), "break", MeetingType.privatMeeting), new MeetingAppointment(createDateNow(14, 0), createDateNow(16, 0), "Devmate", MeetingType.jobMeeting)))),
				/* MeetingAppointment meetingToCheck = */ null,
				/* Class<Throwable> expectedException = */ RuntimeException.class
			),
			Arguments.of(
				/* String testDescription = */ "n7: meetingToCheck: invalid:",
				/* AppointmentChecker instance = */ new AppointmentChecker(new ArrayList<>(List.of(new MeetingAppointment(createDateNow(12, 0), createDateNow(13, 0), "Devmate", MeetingType.jobMeeting), new MeetingAppointment(createDateNow(13, 20), createDateNow(13, 40), "break", MeetingType.privatMeeting), new MeetingAppointment(createDateNow(14, 0), createDateNow(16, 0), "Devmate", MeetingType.jobMeeting)))),
				/* MeetingAppointment meetingToCheck = */ new MeetingAppointment(createDateNow(12, 0), createDateNow(11, 0)),
				/* Class<Throwable> expectedException = */ RuntimeException.class
			)
		);
	}
//endregion

}

/*
WARNING: Modification of this comment will make it impossible to merge user-defined changes

BEGIN_CODEGEN_DATA
H4sIAAAAAAAAAO1ZW0/jRhR+DhL/YeQXHBQcciGUQNEiwrYrFbJa0lZV1YeJfQgD9tidGQdSxH/vmbHjdeJAspDdrYq
RiMfH5/59Po4n9e3NjW3S65OL/oCc93sf3v9BBj9/uCSn/fPzs4uBvvoTcBBUgUeGE+LBOMC1lg9AKhKEHvhdctXpuM
2D/cZOi7bcnXbn6mBn6O65O7S1/0Pn4OCADpsdtKlvbmxuRNS9pSMgAWX8UAtYEIVCEamoYi4Jxci5iTlT+BkxBcKhE
XNOpAShWMilQ83y7O+Y+vLwhdaDaxHeyXz0Gzqmjk/5yPmVyzjSMvD6ka4c7c7uXYj04nDWIFbMd06EoJNfmFSLLp5S
H7hHxaJrT9lIJYAGzqU55JNcXF2PycinkwsawOEzqhEVNJDOR30AFLB/wNMYrmATiXDMPDw/EaM4AK7klxidg7oOvcs
wFi6Yat7lMrYtnQPjI5KoEfca3NsTBIBxpUNZVTS4REQESPk7FRx1pW3FPJbg6YtRPPQReddHaEnO8FQ7AnE650+H60
EQkgedSr0uYIS4kvfUVaFgIDc3KpFgYyT5lFNTCImLeCjo4f9FeGejP3KNRdWIXgWMxwqq2mulUq+TQb/X7xLskQ86K
rky/if6qtLkIxzuyLNUs62PPlAJOSdJkpO0VVYVu1l51EVgfkkdMzUld6jR1WXNtn1RnyvvCuywOZ6TH4n1sPtI/nxg
3IP7x78I3EfgYtpdsrX10Hrc2sImRLEypw08relFExeJ2zwF7AfrLLX+BCoW/Dfqx6BjSetRa6eAjkNWZINJCW8MTRh
lkJSuYKZftQXgY1YIInehhj0DTbOcDrbGiAah0a6RYRhix3lWXIrmVIzNx5mDvZg6deazs2c9Gnwq+XllT13XUm9TCC
tL8cGsUmKYwuVL8UrY9xLUDERmcmKJGU1Xw6xg9tVAPNVz4MjEo0MfjrPSs9AprPkngV1QqhG7SnaOV8d6pZvRo4oWB
0wy6I+y4XpMnrpB7DR3YeSpoRNe2VpYyRxkkkp9myxuNFJku06sqNG1apnqM71P9PXQKirZRjx9Ch4d2/qgc9DyImT2
7BxtNGtkt1qbm66NViK1esk3DisDfzCJwLkJh+kp6qwWBh02F8dpm0BDlN/OhUmA+tJI7YUFdVYtCP8+Q7KU8Z+BWZ7
Y7sLEGlqaCzk/Bg39kjBKxGD0UvWXMK5ZMu7tMK71VKeb35JyrZJyb4dynacSa31DyvFmd66ELvFCkISH+C7AVEnIt0
PIpqFeITMUt/dWZOQVvju8mpKtkpIlJZc8lleekWthZLtkZMnIPPcKmbVXfzdZCyP3SkaWjMy9FhcS23sRIfVnfqtv6
QbQ4r22tW//8EY3I61ejanPvLWQPPb977uLsXwfMIn5KeaKBZBJHfNDwmvnSKc4R9bZ3XKEfO8Rgvz+r3Btv+Ta/5tr
r+j015iK+YfZ3K8dKPkX4HdrN1MgAAA=
END_CODEGEN_DATA
*/
