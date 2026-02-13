import org.junit.Test;
import static org.junit.Assert.*;

public class BishopTest {

  @Test
  public void testMoveDiagonal() {
    Bishop bishop = new Bishop(4, 4, Color.WHITE);
    assertTrue(bishop.canMove(6, 6));
  }

  @Test
  public void testMoveDiagonalOtherDirection() {
    Bishop bishop = new Bishop(4, 4, Color.WHITE);
    assertTrue(bishop.canMove(2, 6));
  }

  @Test
  public void testCannotMoveStraight() {
    Bishop bishop = new Bishop(4, 4, Color.WHITE);
    assertFalse(bishop.canMove(4, 7));
  }

  @Test
  public void testCannotStayStill() {
    Bishop bishop = new Bishop(4, 4, Color.WHITE);
    assertFalse(bishop.canMove(4, 4));
  }

  @Test
  public void testCanKillEnemy() {
    Bishop bishop = new Bishop(4, 4, Color.WHITE);
    Pawn enemy = new Pawn(6, 6, Color.BLACK);

    assertTrue(bishop.canKill(enemy));
  }

  @Test
  public void testCannotKillSameColor() {
    Bishop bishop = new Bishop(4, 4, Color.WHITE);
    Pawn friend = new Pawn(6, 6, Color.WHITE);

    assertFalse(bishop.canKill(friend));
  }
}