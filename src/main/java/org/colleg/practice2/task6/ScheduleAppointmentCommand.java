package org.colleg.practice2.task6;

public class ScheduleAppointmentCommand extends AbstractCommand{
    private String doctorName;
    private int appointmentDate;

    public ScheduleAppointmentCommand(String doctorName, int appointmentDate) {
        this.doctorName = doctorName;
        this.appointmentDate = appointmentDate;
    }

    @Override
    public void execute() {
        System.out.println("Запис на прийом до лікаря " + doctorName + " на дату " + appointmentDate + " виконано.");
    }

    @Override
    public void undo() {
        System.out.println("Запис на прийом до лікаря " + doctorName + " скасовано.");
    }
}
