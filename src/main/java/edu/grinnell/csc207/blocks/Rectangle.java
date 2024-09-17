package edu.grinnell.csc207.blocks;

/**
 * A rectangular block of one repeated character.
 *
 * @author Samuel A. Rebelsky
 */
public class Rectangle implements AsciiBlock {
  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * One row of the rectangle.
   */
  String row;

  /**
   * The height of the rectangle.
   */
  int height;

  /**
   * The left block.
   */
  AsciiBlock left;

  /**
   * The right block.
   */
  AsciiBlock right;

  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Build a rectangle.
   *
   * @param ch
   *   The character from which we build the rectangle.
   *
   * @param rectWidth
   *   The width of the rectangle.
   *
   * @param rectHeight
   *   The height of the rectangle.
   */
  public Rectangle(char ch, int rectWidth, int rectHeight)
      throws Exception {
    // Sanity check
    if (rectWidth <= 0) {
      throw new Exception("Rectangle width must be positive");
    } else if (rectHeight <= 0) {
      throw new Exception("Rectangle height must be positive");
    } // if/else
    // Set up the fields
    this.height = rectHeight;
    this.row = new String(new char[] {ch}).repeat(rectWidth);
  } // Rectangle(String)

  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Get one row from the block.
   *
   * @param i the number of the row
   *
   * @return row i.
   *
   * @exception Exception
   *   if i is outside the range of valid rows.
   */
  public String row(int i) throws Exception {
    if ((i < 0) || (i >= this.height())) {
      throw new Exception("Invalid row " + i);
    } // if
    return this.row;
  } // row(int)

  /**
   * Determine how many rows are in the block.
   *
   * @return the number of rows
   */
  public int height() {
    return this.height;
  } // height()

  /**
   * Determine how many columns are in the block.
   *
   * @return the number of columns
   */
  public int width() {
    return this.row.length();
  } // width()

} // class Rectangle
