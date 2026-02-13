public class Queen extends ChessPiece {
  public Queen(int row, int col, Color color) {
    super(row, col, color);
  }

  @Override
  public boolean canMove(int row, int col) {
    if (row == getRow() && col == getColumn()) {
      return false;
    }

    boolean rookMove =
        row == getRow() || col == getColumn();

    int rowDiff = Math.abs(row - getRow());
    int colDiff = Math.abs(col - getColumn());

    boolean bishopMove =
        rowDiff == colDiff;

    return rookMove || bishopMove;
  }
}
