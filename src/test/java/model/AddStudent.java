package model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.BeforeEach;
import java.lang.Exception;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.RepeatedTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.time.LocalDate;
//import org.junit.jupiter.api.BeforeAll;

/**
 *  Implement and test {Programme.addStudent } that respects the considtion given the assignment specification
 * NOTE: You are expected to verify that the constraints to add a new student to a programme are met.
 *
 * Each test criteria must be in an independent test method .
 *
 * Initialize the test object with initialise method.
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AddStudent {
	
	private Programme test_prgm;
    private Student test_student;

    @BeforeEach
    void initialise(){
        test_prgm = new Programme();
        test_student = new Student("Kawish",393);
    }
    /**
     * Comman Cases
     * @throws Exception
     */
    @Test
    void true_ifBeforeStartDate() throws Exception{
        LocalDate currentDate = LocalDate.of(2022, 5, 29);
        assertEquals(true,test_prgm.addStudent(test_student,currentDate),
        "returns false if the start date has passed");
    }

    @Test
    void true_ifStudentSuccessfullyAdded() throws Exception{
        LocalDate currentDate = LocalDate.of(2022, 5, 29);
        test_prgm.addStudent(test_student,currentDate);
        assertEquals(true, test_prgm.getEnrollments().contains(test_student));
    }
    /**
     * Boder Line/Edge Cases
     * @throws Exception
     */

     @Test
     void true_ifAfterStartDate() throws Exception{
         LocalDate currentDate = LocalDate.of(2024, 5, 29);
         assertEquals(false,test_prgm.addStudent(test_student,currentDate),
         "returns false if the start date has passed");
     }
 
    @Test
    void false_ifStudentAlreadyEnrolled() throws Exception{
        LocalDate currentDate = LocalDate.of(2022, 5, 29);
        test_prgm.addStudent(test_student,currentDate);
        assertThrows(Exception.class, () -> {test_prgm.addStudent(test_student,currentDate);});
    }

    @Test
    void false_ifMoreThan250() throws Exception{
        LocalDate currentDate = LocalDate.of(2022, 5, 29);
        for(int i=0;i<250;i++){
            test_prgm.addStudent(new Student("Kawish",i),currentDate);
        }
        assertEquals(false,test_prgm.addStudent(test_student,currentDate));
    }

}