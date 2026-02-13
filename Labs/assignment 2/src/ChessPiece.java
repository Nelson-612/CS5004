public abstract class ChessPiece implements ChessPieceContract {
  private final int row;
  private final int col;
  private final Color color;

  public ChessPiece(int row, int col, Color color) {
    if (row < 0 || row > 7) {
      throw new IllegalArgumentException("Row must be between 0 and 7.");
    }
    if (col < 0 || col > 7) {
      throw new IllegalArgumentException("Column must be between 0 and 7.");
    }
    if (color == null) {
      throw new IllegalArgumentException("Color cannot be null.");
    }

    this.row = row;
    this.col = col;
    this.color = color;
  }

  @Override
  public int getRow() {
    return row;
  }

  @Override
  public int getColumn() {
    return col;
  }

  @Override
  public Color getColor() {
    return color;
  }

  @Override
  public abstract boolean canMove(int row, int col);

  @Override
  public boolean canKill(ChessPiece piece) {
    if (piece == null) {
      return false;
    }
    if (this.getColor() == piece.getColor()) {
      return false;
    }
    return this.canMove(piece.getRow(), piece.getColumn());
  }
}