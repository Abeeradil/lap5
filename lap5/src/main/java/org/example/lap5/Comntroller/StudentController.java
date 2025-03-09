package org.example.lap5.Comntroller;

import org.example.lap5.Api.ApiResponse;
import org.example.lap5.Model.Student;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/student")

public class StudentController {
    ArrayList<Student> students = new ArrayList<>();

    @GetMapping("/get")
    public ArrayList<Student> getStudents() {
        return students;
    }
@PostMapping("/add")
    public ApiResponse getStudent(@RequestBody Student student) {
        students.add(student);
        return new ApiResponse("Student added Successfully");
    }
    @PutMapping("/update/{index}")
    public ApiResponse updateStudent(@PathVariable int index, @RequestBody Student student) {
        students.set(index, student);
        return new ApiResponse("Student updated Successfully");
    }

    @DeleteMapping("delete/{index}")
    public ApiResponse deleteStudent(@PathVariable int index) {
        students.remove(index);
        return new ApiResponse("Student deleted Successfully");
    }
        @GetMapping("/based")
  public List <String> basedStudent() {
        List <String> based = new ArrayList<>();
            for (Student student : students) {
                if (student.getGpa() >= 3.5) {
                    based.add(student.getName() + "-" + student.getGpa());
                }
            }
            return based;
        }

    @GetMapping("/display")
    public List<Student> averageGpa() {
        if (students.isEmpty()) return new ArrayList<>();

        double totalGpa = 0;
        for (Student student : students) {
            totalGpa += student.gpa;
        }
        double averageGpa = totalGpa / students.size();

        List<Student> average = new ArrayList<>();
        for (Student student : students) {
            if (student.gpa > averageGpa) {
                average.add(student);
            }
        }
        return average;
}

}