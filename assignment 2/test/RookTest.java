import org.junit.Test;
import static org.junit.Assert.*;

public class RookTest {

  @Test
  public void testMoveHorizontal() {
    Rook rook = new Rook(4, 4, Color.WHITE);
    assertTrue(rook.canMove(4, 7));
  }

  @Test
  public void testMoveVertical() {
    Rook rook = new Rook(4, 4, Color.WHITE);
    assertTrue(rook.canMove(7, 4));
  }

  @Test
  public void testCannotMoveDiagonally() {
    Rook rook = new Rook(4, 4, Color.WHITE);
    assertFalse(rook.canMove(6, 6));
  }

  @Test
  public void testCannotStayStill() {
    Rook rook = new Rook(4, 4, Color.WHITE);
    assertFalse(rook.canMove(4, 4));
  }

  @Test
  public void testCanKillEnemy() {
    Rook rook = new Rook(4, 4, Color.WHITE);
    Pawn enemy = new Pawn(4, 7, Color.BLACK);

    assertTrue(rook.canKill(enemy));
  }

  @Test
  public void testCannotKillSameColor() {
    Rook rook = new Rook(4, 4, Color.WHITE);
    Pawn friend = new Pawn(4, 7, Color.WHITE);

    assertFalse(rook.canKill(friend));
  }
}