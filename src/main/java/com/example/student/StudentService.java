package com.example.student;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StudentService {
    private final List<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);
    }

    public boolean removeStudent(int id) {
        return students.removeIf(s -> s.getId() == id);
    }

    public Optional<Student> findStudentById(int id) {
        return students.stream().filter(s -> s.getId() == id).findFirst();
    }

    public List<Student> getAllStudents() {
        return new ArrayList<>(students);
    }
}
