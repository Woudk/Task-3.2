package org.colleg.practice2.task6;

public class UpdateMedicalRecordCommand extends AbstractCommand{
    private int patientId;
    private String updateDetails;

    public UpdateMedicalRecordCommand(int patientId, String updateDetails) {
        this.patientId = patientId;
        this.updateDetails = updateDetails;
    }

    @Override
    public void execute() {
        System.out.println("Медична картка пацієнта " + patientId + " оновлена: " + updateDetails);
    }

    @Override
    public void undo() {
        System.out.println("Оновлення медичної картки пацієнта " + patientId + " скасовано.");
    }
}
