import com.ltp.gradesubmission.Constants;
import com.ltp.gradesubmission.entity.Grade;
import com.ltp.gradesubmission.repository.GradeRepository;
import com.ltp.gradesubmission.service.GradeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class GradeServiceTest {

    @Mock
    private  GradeRepository gradeRepository;
    @InjectMocks
    private GradeService gradeService;

   @Test
    public void getGradesFromRepoTest(){
       when(gradeRepository.getGrades()).thenReturn(Arrays.asList(
               new Grade("Juan", "Math", "B-"),
               new Grade("Juana", "English", "A+"),
               new Grade("Juanito", "History", "B+")
       ));

       List<Grade> getGrades = gradeService.getGrades();
       assertEquals("Juan", getGrades.get(0).getName());
       assertEquals("Juanito", getGrades.get(2).getName());
       assertEquals("B-", getGrades.get(0).getScore());
   }

   @Test
    public void getGradeIndexTest(){
       Grade grade = new Grade("Test User", "Sub2ject", "C-");
       when(gradeRepository.getGrades()).thenReturn(Arrays.asList(grade));
       when(gradeRepository.getGrade(0)).thenReturn(grade);

       int valid = gradeService.getGradeIndex(grade.getId());
       int notFound = gradeService.getGradeIndex("123");

       assertEquals(0, valid);
       assertEquals(Constants.INDEX_NOT_FOUND, notFound);
   }
}
