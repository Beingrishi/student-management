package com.example.student;

import org.junit.jupiter.api.Test;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

public class StudentServiceTest {

    @Test
    public void testAddAndFindStudent() {
        StudentService service = new StudentService();
        Student student = new Student(1, "Ravi", 21);
        service.addStudent(student);
        Optional<Student> found = service.findStudentById(1);
        assertTrue(found.isPresent());
        assertEquals("Ravi", found.get().getName());
    }

    @Test
    public void testRemoveStudent() {
        StudentService service = new StudentService();
        Student student = new Student(2, "Sita", 22);
        service.addStudent(student);
        boolean removed = service.removeStudent(2);
        assertTrue(removed);
        assertFalse(service.findStudentById(2).isPresent());
    }
}
