package behavioural;

class Student{
    private String name;
    private String age;

    Student(String name, String age){
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    
}

class StudentView{
    public void display(Student student){
        System.out.println("Student Name: " + student.getName());
        System.out.println("Student Age: " + student.getAge());
    }
}

class Controller{
    private Student model;
    private StudentView view;

    public Controller(Student model, StudentView view){
        this.model = model;
        this.view = view;
    }

    public void setStudentNane(String name){
        model.setName(name);
    }
    public void setStudentAge(String age){
        model.setAge(age);
    }

    public void updateView(){
        view.display(model);
    }
}

public class MVCPattern {
    public static void main(String[] args) {
        Student student = new Student("John Doe", "20");
        StudentView view = new StudentView();
        Controller controller = new Controller(student, view);

        controller.updateView(); // Display initial state
        controller.setStudentNane("Jane Doe"); // Update name
        controller.setStudentAge("22"); // Update age
        controller.updateView(); // Display updated state
    }
}
