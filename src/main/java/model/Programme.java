package model;

import java.util.ArrayList;
import java.time.LocalDate;
import java.util.List;

/**
 * Programmes offered by a university
 */
public class Programme {
    /**
     * Name and id of the programme
     */
    private String name;
    private int pID;

    /**
     * Start date of the programme
     */
    private LocalDate startDate;

    /**
     * End date of the programme
     */
    private LocalDate dueDate;

    /**
     * Estimated duration of the course in months
     */
    private int estimatedDuration;

    /**
     * Students allocated to the programme
     */
    private List<Student> enrolled = new ArrayList<Student>();

    public Programme(){
        startDate = LocalDate.of(2023, 11, 29);
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getID() {
        return pID;
    }

    public void setID(int ID) {
        this.pID = ID;
    }


    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public int getEstimatedDuration() {
        return estimatedDuration;
    }

    public void setEstimatedDuration(int estimatedDuration) {
        this.estimatedDuration = estimatedDuration;
    }

    public List<Student> getEnrollments() {
        return enrolled;
    }

    
    public boolean removeEnrolledStudent(Student student) {
    
    	return false;
    	   
    }



    /**
     * Add a new student to the programme
     * @param Student: to enroll  to student in a programme 
     * @return true if the student is successfully enrolled, false otherwise
     * @throws Exception
     */

    public boolean addStudent(Student student,LocalDate currentDate,Football game) throws Exception{
        List<Student> student_lists = getEnrollments();
        if (student_lists.size() == 250) {
            return false;
        }
        for (int i=0;i<student_lists.size();i++){
            if(student == student_lists.get(i)){
                throw new Exception("Student already add");
            }
        }
        int result = currentDate.compareTo(getStartDate());
        if(result > 0){
            return false;
        }
        this.enrolled.add(student);
        game.addAvailStudent(student);
        return true;
    }




}
