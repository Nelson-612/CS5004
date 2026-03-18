import org.junit.Test;
import static org.junit.Assert.*;

public class KingTest {

  @Test
  public void testMoveOneStepHorizontal() {
    King king = new King(4, 4, Color.WHITE);
    assertTrue(king.canMove(4, 5));
  }

  @Test
  public void testMoveOneStepVertical() {
    King king = new King(4, 4, Color.WHITE);
    assertTrue(king.canMove(5, 4));
  }

  @Test
  public void testMoveOneStepDiagonal() {
    King king = new King(4, 4, Color.WHITE);
    assertTrue(king.canMove(5, 5));
  }

  @Test
  public void testCannotMoveTwoSteps() {
    King king = new King(4, 4, Color.WHITE);
    assertFalse(king.canMove(6, 4));
  }

  @Test
  public void testCannotStayStill() {
    King king = new King(4, 4, Color.WHITE);
    assertFalse(king.canMove(4, 4));
  }

  @Test
  public void testCanKillEnemy() {
    King king = new King(4, 4, Color.WHITE);
    Pawn enemy = new Pawn(5, 5, Color.BLACK);

    assertTrue(king.canKill(enemy));
  }

  @Test
  public void testCannotKillSameColor() {
    King king = new King(4, 4, Color.WHITE);
    Pawn friend = new Pawn(5, 5, Color.WHITE);

    assertFalse(king.canKill(friend));
  }
}