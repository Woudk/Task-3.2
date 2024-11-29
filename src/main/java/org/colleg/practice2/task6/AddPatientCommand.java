package org.colleg.practice2.task6;

public class AddPatientCommand extends AbstractCommand{
    private String patientName;
    private int patientAge;

    public AddPatientCommand(String patientName, int patientAge) {
        this.patientName = patientName;
        this.patientAge = patientAge;
    }

    @Override
    public void execute() {
        System.out.println("Пацієнт " + patientName + ", вік " + patientAge + " доданий.");
    }

    @Override
    public void undo() {
        System.out.println("Пацієнт " + patientName + " видалений.");
    }
}
