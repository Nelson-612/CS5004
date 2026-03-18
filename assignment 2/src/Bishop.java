public class Bishop extends ChessPiece{
  public Bishop(int row, int col, Color color) {
    super(row, col, color);
  }

  @Override
  public boolean canMove(int row, int col) {
    if (row == getRow() && col == getColumn()) {
      return false;
    }
    int rowDiff = Math.abs(row - getRow());
    int colDiff = Math.abs(col - getColumn());

    return rowDiff == colDiff;
  }
}