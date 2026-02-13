import org.junit.Test;
import static org.junit.Assert.*;

public class PawnTest {

  @Test
  public void testWhitePawnMoveForwardOne() {
    Pawn pawn = new Pawn(1, 4, Color.WHITE);
    assertTrue(pawn.canMove(2, 4));
  }

  @Test
  public void testWhitePawnMoveForwardTwoFromStart() {
    Pawn pawn = new Pawn(1, 4, Color.WHITE);
    assertTrue(pawn.canMove(3, 4));
  }

  @Test
  public void testWhitePawnCannotMoveSideways() {
    Pawn pawn = new Pawn(1, 4, Color.WHITE);
    assertFalse(pawn.canMove(1, 5));
  }

  @Test
  public void testWhitePawnCannotMoveBackward() {
    Pawn pawn = new Pawn(3, 4, Color.WHITE);
    assertFalse(pawn.canMove(2, 4));
  }

  @Test
  public void testPawnCaptureDiagonal() {
    Pawn pawn = new Pawn(3, 4, Color.WHITE);
    Rook enemy = new Rook(4, 5, Color.BLACK);

    assertTrue(pawn.canKill(enemy));
  }

  @Test
  public void testPawnCannotCaptureForward() {
    Pawn pawn = new Pawn(3, 4, Color.WHITE);
    Rook enemy = new Rook(4, 4, Color.BLACK);

    assertFalse(pawn.canKill(enemy));
  }

  @Test
  public void testPawnCannotCaptureSameColor() {
    Pawn pawn = new Pawn(3, 4, Color.WHITE);
    Rook friend = new Rook(4, 5, Color.WHITE);

    assertFalse(pawn.canKill(friend));
  }

  @Test(expected = IllegalArgumentException.class)
  public void testWhitePawnInvalidRow() {
    new Pawn(0, 3, Color.WHITE);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testBlackPawnInvalidRow() {
    new Pawn(7, 3, Color.BLACK);
  }
}
