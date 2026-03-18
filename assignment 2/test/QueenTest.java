import org.junit.Test;
import static org.junit.Assert.*;

public class QueenTest {

  @Test
  public void testMoveHorizontal() {
    Queen queen = new Queen(4, 4, Color.WHITE);
    assertTrue(queen.canMove(4, 7));
  }

  @Test
  public void testMoveVertical() {
    Queen queen = new Queen(4, 4, Color.WHITE);
    assertTrue(queen.canMove(7, 4));
  }

  @Test
  public void testMoveDiagonal() {
    Queen queen = new Queen(4, 4, Color.WHITE);
    assertTrue(queen.canMove(6, 6));
  }

  @Test
  public void testCannotMoveLikeKnight() {
    Queen queen = new Queen(4, 4, Color.WHITE);
    assertFalse(queen.canMove(6, 5));
  }

  @Test
  public void testCannotStayStill() {
    Queen queen = new Queen(4, 4, Color.WHITE);
    assertFalse(queen.canMove(4, 4));
  }

  @Test
  public void testCanKillEnemy() {
    Queen queen = new Queen(4, 4, Color.WHITE);
    Pawn enemy = new Pawn(6, 6, Color.BLACK);

    assertTrue(queen.canKill(enemy));
  }

  @Test
  public void testCannotKillSameColor() {
    Queen queen = new Queen(4, 4, Color.WHITE);
    Pawn friend = new Pawn(6, 6, Color.WHITE);

    assertFalse(queen.canKill(friend));
  }
}
