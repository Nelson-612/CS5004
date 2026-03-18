public class Rook extends ChessPiece {
  public Rook(int row, int col, Color color) {
    super(row, col, color);
  }

    @Override
    public boolean canMove(int row, int col) {
      if (row == getRow() && col == getColumn()) {
        return false;
      }
      return row == getRow() || col == getColumn();
    }
}
