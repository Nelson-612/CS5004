public class Pawn extends ChessPiece {

  public Pawn(int row, int col, Color color) {
    super(row, col, color);

    // Pawn creation restriction:
    // White pawns cannot be created on row 0
    // Black pawns cannot be created on row 7
    if (color == Color.WHITE && row == 0) {
      throw new IllegalArgumentException();
    }
    if (color == Color.BLACK && row == 7) {
      throw new IllegalArgumentException();
    }
  }

  @Override
  public boolean canMove(int row, int col) {
    int rowChange = row - getRow();
    int colDiff = Math.abs(col - getColumn());

    // cannot stay in place
    if (rowChange == 0 && colDiff == 0) {
      return false;
    }

    int forward = (getColor() == Color.WHITE) ? 1 : -1;

    // must move straight forward (same column)
    if (colDiff != 0) {
      return false;
    }

    // one step forward
    if (rowChange == forward) {
      return true;
    }

    // two steps forward only from starting row
    boolean inStartRow =
        (getColor() == Color.WHITE && getRow() == 1) ||
            (getColor() == Color.BLACK && getRow() == 6);

    return inStartRow && rowChange == 2 * forward;
  }

  @Override
  public boolean canKill(ChessPiece piece) {
    if (piece == null) {
      return false;
    }

    // must be enemy piece
    if (piece.getColor() == this.getColor()) {
      return false;
    }

    int rowChange = piece.getRow() - getRow();
    int colDiff = Math.abs(piece.getColumn() - getColumn());
    int forward = (getColor() == Color.WHITE) ? 1 : -1;

    // capture is one step forward diagonally
    return rowChange == forward && colDiff == 1;
  }
}