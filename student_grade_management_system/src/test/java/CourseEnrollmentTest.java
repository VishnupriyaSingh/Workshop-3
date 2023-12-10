import static org.junit.jupiter.api.Assertions.*;

import com.example.CourseEnrollment;
import com.example.CourseNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CourseEnrollmentTest {

    private CourseEnrollment enrollment;

    @BeforeEach
    public void setUp() {
        enrollment = new CourseEnrollment();
        enrollment.addCourse("CS101");
    }

    @Test
    public void testValidEnrollment() {
        assertDoesNotThrow(() -> enrollment.enrollStudent("123", "CS101"));
    }

    @Test
    public void testEnrollInNonexistentCourse() {
        assertThrows(CourseNotFoundException.class, () ->
                enrollment.enrollStudent("123", "NONEXISTENT_COURSE"));
    }
}
