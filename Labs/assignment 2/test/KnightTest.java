import org.junit.Test;
import static org.junit.Assert.*;

public class KnightTest {

  @Test
  public void testValidMoveTwoOne() {
    Knight knight = new Knight(4, 4, Color.WHITE);
    assertTrue(knight.canMove(6, 5));
  }

  @Test
  public void testValidMoveOneTwo() {
    Knight knight = new Knight(4, 4, Color.WHITE);
    assertTrue(knight.canMove(5, 6));
  }

  @Test
  public void testInvalidMoveStraight() {
    Knight knight = new Knight(4, 4, Color.WHITE);
    assertFalse(knight.canMove(4, 6));
  }

  @Test
  public void testInvalidMoveDiagonal() {
    Knight knight = new Knight(4, 4, Color.WHITE);
    assertFalse(knight.canMove(6, 6));
  }

  @Test
  public void testCannotStayStill() {
    Knight knight = new Knight(4, 4, Color.WHITE);
    assertFalse(knight.canMove(4, 4));
  }

  @Test
  public void testCanKillEnemy() {
    Knight knight = new Knight(4, 4, Color.WHITE);
    Pawn enemy = new Pawn(6, 5, Color.BLACK);

    assertTrue(knight.canKill(enemy));
  }

  @Test
  public void testCannotKillSameColor() {
    Knight knight = new Knight(4, 4, Color.WHITE);
    Pawn friend = new Pawn(6, 5, Color.WHITE);

    assertFalse(knight.canKill(friend));
  }
}