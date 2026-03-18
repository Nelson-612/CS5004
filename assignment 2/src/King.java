public class King extends ChessPiece {
  public King(int row, int col, Color color) {
    super(row, col, color);
  }

  @Override
  public boolean canMove (int row, int col) {
    int rowDiff = Math.abs(row - getRow());
    int colDiff = Math.abs(col - getColumn());

    if (rowDiff == 0 && colDiff == 0) {
      return false;
    }

    return rowDiff <=1 && colDiff <=1;
  }
}