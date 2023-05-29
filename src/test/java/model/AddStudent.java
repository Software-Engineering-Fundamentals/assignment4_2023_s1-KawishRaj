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
    private Football game;

    @BeforeEach
    void initialise(){
        test_prgm = new Programme();
        test_student = new Student("Kawish",393);
        game = new Football();
    }
    /**
     * Comman Cases
     */

     /**
      * This method tests if the student is allowed to enroll if the student
      * applies before the start date of the programme.
      * @throws Exception
      */
    @Test
    void true_ifBeforeStartDate() throws Exception{
        LocalDate currentDate = LocalDate.of(2022, 5, 29);
        assertEquals(true,test_prgm.addStudent(test_student,currentDate,game),
        "returns false if the start date has passed");
    }

    /**
     * This method tests that after being enrolled if the 
     * student is added to the enrolled list of students or not.
     * @throws Exception
     */
    @Test
    void true_ifStudentSuccessfullyAdded() throws Exception{
        LocalDate currentDate = LocalDate.of(2022, 5, 29);
        test_prgm.addStudent(test_student,currentDate,game);
        assertEquals(true, test_prgm.getEnrollments().contains(test_student));
    }

     /**
     * This method tests that the students are not allowed 
     * to enroll if there are already 250 students in the programme.
     * @throws Exception
     */
    @Test
    void true_ifStudentInAvailStudentList() throws Exception{
        LocalDate currentDate = LocalDate.of(2022, 5, 29);
        test_prgm.addStudent(test_student,currentDate,game);
        assertEquals(true, game.getAvailStudents().contains(test_student));
    }

    /************************************************* */
    /**
     * Boder Line/Edge Cases
     * @throws Exception
     */

    /**
     * This method tests that the students are not allowed to 
     * enroll if they apply after the startDate of the programme.
     * @throws Exception
     */

     @Test
     void true_ifAfterStartDate() throws Exception{
         LocalDate currentDate = LocalDate.of(2024, 5, 29);
         assertEquals(false,test_prgm.addStudent(test_student,currentDate,game),
         "returns false if the start date has passed");
     }
    

    /**
     * This method tests if already enrolled students are not 
     * allowed to enroll or not.
     * @throws Exception
     */
    @Test
    void false_ifStudentAlreadyEnrolled() throws Exception{
        LocalDate currentDate = LocalDate.of(2022, 5, 29);
        test_prgm.addStudent(test_student,currentDate,game);
        assertThrows(Exception.class, () -> {test_prgm.addStudent(test_student,currentDate,game);});
    }



    /**
     * This method tests that the students are not allowed 
     * to enroll if there are already 250 students in the programme.
     * @throws Exception
     */
    @Test
    void false_ifMoreThan250() throws Exception{
        LocalDate currentDate = LocalDate.of(2022, 5, 29);
        for(int i=0;i<250;i++){
            test_prgm.addStudent(new Student("Kawish",i),currentDate,game);
        }
        assertEquals(false,test_prgm.addStudent(test_student,currentDate,game));
    }


}