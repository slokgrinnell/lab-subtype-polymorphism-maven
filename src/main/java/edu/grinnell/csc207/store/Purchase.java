package edu.grinnell.csc207.store;

/**
 * Things people might purchase.
 */
public interface Purchase {
  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Determine the cost of this purchase.
   *
   * @return the cost in cents
   */
  public int cost();
} // interface Purchase

