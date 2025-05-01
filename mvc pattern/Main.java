

class Student {
    String name;
    int rollNo;
}

class StudentView {
    void showDetails(String name, int rollNo) {
        System.out.println("Student Name: " + name);
        System.out.println("Roll No: " + rollNo);
    }
}

class StudentController {
    Student model;
    StudentView view;

    StudentController(Student model, StudentView view) {
        this.model = model;
        this.view = view;
    }

    void setStudentName(String name) {
        model.name = name;
    }

    void setRollNo(int rollNo) {
        model.rollNo = rollNo;
    }

    void updateView() {
        view.showDetails(model.name, model.rollNo);
    }
}

public class Main {
    public static void main(String[] args) {
        Student model = new Student();
        model.name = "Meet";
        model.rollNo = 101;

        StudentView view = new StudentView();
        StudentController controller = new StudentController(model, view);

        controller.updateView(); // Show initial details

        controller.setStudentName("Jain");
        controller.setRollNo(102);
        System.out.println("\nAfter update:");
        controller.updateView(); // Show updated details
    }
}

