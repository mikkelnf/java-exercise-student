import com.enigmacamp.student.model.Major;
import com.enigmacamp.student.model.Student;
import com.enigmacamp.student.repository.StudentRepository;
import com.enigmacamp.student.repository.StudentRepositoryImpl;
import com.enigmacamp.student.service.StudentService;
import com.enigmacamp.student.service.StudentServiceImpl;
import com.enigmacamp.student.util.ResponseStatus;
import com.enigmacamp.student.validation.StudentValidationUtil;
import com.enigmacamp.student.validation.Validation;

import java.util.List;

public class App {
    public static void main(String[] args) {
        StudentRepository repository = new StudentRepositoryImpl(5);
        Validation ageValidation = StudentValidationUtil.ageValidation(17);
        Validation nameLengthValidation = StudentValidationUtil.nameLengthValidation(3,20);

        StudentService service = new StudentServiceImpl(repository, ageValidation, nameLengthValidation);

        Student student1 = new Student("Rohman", 27, new Major("Ekonomi"));
        Student student2 = new Student("Rohim", 27, new Major("Hukum"));
        Student student3 = new Student("Qo", 17, new Major("Hukum"));

        // Add student
//        service.registerStudent(student1);
//        service.registerStudent(student2);
        ResponseStatus<Student> register = service.registerStudent(student3);
        if(register.isSuccess()){
            System.out.println(register.getData());
        }else {
            System.err.println(register.getMessage());
        }


        // Delete student
        ResponseStatus<String> unregister = service.unregisterStudent();
        if (unregister.isSuccess()){
            System.out.println("Success");
        } else{
            System.err.println(unregister.getMessage());
        }

        // Find All Student
        ResponseStatus<List<Student>> studentList = service.getAllStudent();
        if(!studentList.isSuccess()){
            System.err.println(studentList.getMessage());
        }else{
            for(Student s : studentList.getData()) {
                System.out.println(s);
            }
        }


        // Find by index
//        Student student = service.getStudentByIndex(0);
//        System.out.println(student);
    }
}