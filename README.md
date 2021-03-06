# Java-MeetingCalculatorDemo

## Content

- Summary
- Validation
- Adding
- Removing
- Changing

## Summary

The AppointmentChecker should be able to check the validity of appointments. Additionally it should be possible to add, remove and change appointments. 

## Validation

An appointment is valid if the following conditions are met.

### Conditions A 

- The appointment itself is valid 
  - The starttime is before the end time 
  - The duration of the appointment is bigger than zero
  - The appointment exists
- The calendar to add the meeting exists

#### Actions if conditions not met 

RuntimeException which has to be handled by UI - see more in the UI Specification. 

### Conditions B

- The appointment does not overlap with already booked appointments
  - The appointment starts and ends after or before already applied appointments

#### Actions if conditions not met

Flag as invalid (false)

### Default Action

If valid, it has to be flagged as valid (true). 

## Adding
First the appointment to add has to be checked if valid, then it should be added to the calendar. If the appoint has been added successfully, a flag should be returned (true/false). 

## Removing
Before removing an appointment, it should be checked if the calendar and the meeting to remove are valid. 

### Conditions A 

- The appointment itself is valid 
  - The starttime is before the end time 
  - The duration of the appointment is bigger than zero
  - The appointment exists
- The calendar to add the meeting exists

#### Actions if conditions not met 

RuntimeException which has to be handled by UI - see more in the UI Specification. 

### Conditions B 

- The calendar contains the appointment to remove.

#### Actions if conditions not met

Flag as not removed (false)

### Default Action

If the appointment has been removed successfully it should be flagged as removed (true). 

## Changing
Before applying a change to an existing appointment it should be checked for validity (See Validation section). If the appointment to change is not valid or is not applied to the calendar it should be flagged as invalid (false) and the appointment does not get changed. If the calendar or the appointment to change is not available an RuntimeException should be thrown, which is handled by the UI (see UI Specification). 
