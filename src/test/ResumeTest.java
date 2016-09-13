import org.junit.*;
import static org.junit.Assert.*;

public class PlacesTest{

  @Test
  public void Resume_instantiatesCorectly_true() {
    Resume myResume = new Resume("a", "a", "a", "a", "a",);
    assertEquals(true, myResume instanceof Resume);
  }

  @Test
  public void Resume_getPosition_manager() {
    Resume myResume = new Resume("manager", "a", "a", "a", "a",);
    assertEquals("manager", myResume.getPosition());
  }

  @Test
  public void Resume_getCompany_GoldenToothBrush() {
    Resume myResume = new Resume("a", "goldenToothBrush", "a", "a", "a",);
    assertEquals("goldenToothBrush", myResume.getCompany());
  }

  @Test
  public void Resume_getLocation_Portland() {
    Resume myResume = new Resume("a", "a", "Portland", "a", "a",);
    assertEquals("Portland", myResume.getLocation());
  }

  @Test
  public void Resume_getDescription_Difficult() {
    Resume myResume = new Resume("a", "a", "a", "difficult", "a",);
    assertEquals("difficult", myResume.getDescription());
  }

  @Test
  public void Resume_GetDate_twoMonths() {
    Resume myResume = new Resume("a", "a", "a", "a", "two Months",);
    assertEquals("two months", myResume.getDate());
  }
}
