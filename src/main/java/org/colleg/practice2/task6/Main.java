package org.colleg.practice2.task6;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        HospitalController controller = new HospitalController();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nОберіть дію:");
            System.out.println("1. Додати пацієнта");
            System.out.println("2. Записати на прийом");
            System.out.println("3. Оновити медичну картку");
            System.out.println("4. Виконати всі команди");
            System.out.println("5. Відмінити останні команди");
            System.out.println("0. Вихід");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Введіть ім'я пацієнта: ");
                    String name = scanner.nextLine();
                    System.out.print("Введіть вік пацієнта: ");
                    int age = scanner.nextInt();
                    controller.addCommand(new AddPatientCommand(name, age));
                    break;

                case 2:
                    System.out.print("Введіть ім'я лікаря: ");
                    String doctorName = scanner.nextLine();
                    System.out.print("Введіть дату прийому (yyyyMMdd): ");
                    int date = scanner.nextInt();
                    controller.addCommand(new ScheduleAppointmentCommand(doctorName, date));
                    break;

                case 3:
                    System.out.print("Введіть ID пацієнта: ");
                    int patientId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Введіть деталі оновлення: ");
                    String details = scanner.nextLine();
                    controller.addCommand(new UpdateMedicalRecordCommand(patientId, details));
                    break;

                case 4:
                    controller.executeAllPendingCommands();
                    break;

                case 5:
                    System.out.print("Скільки команд відмінити? ");
                    int undoCount = scanner.nextInt();
                    controller.undoChanges(undoCount);
                    break;

                case 0:
                    System.out.println("Вихід.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Невірний вибір. Спробуйте ще раз.");
            }
        }

    }
}