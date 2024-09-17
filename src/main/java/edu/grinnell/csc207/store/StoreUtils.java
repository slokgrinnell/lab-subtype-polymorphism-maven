package edu.grinnell.csc207.store;

import java.io.PrintWriter;

/**
 * Utilities for maintaining a store.
 */
public interface StoreUtils {
  // +-----------+---------------------------------------------------
  // | Constants |
  // +-----------+

  /**
   * The width of a line on the receipt.
   */
  static final int RECEIPT_WIDTH = 60;

  /**
   * The width of one purchase.
   */
  static final int PURCHASE_WIDTH = RECEIPT_WIDTH - 7;

  // +----------------+----------------------------------------------
  // | Static methods |
  // +----------------+

  /**
   * Convert a cost in cents to a "dollar string".
   *
   * @param cents
   *   The cost in cents.
   *
   * @return
   *   The cost as a string of the form "D.CC", where "D" is the
   *   dollar portion and "CC" is the cent portion.
   */
  public static String centsToDollars(int cents) {
    return String.format("%d.%02d", cents / 100, cents % 100);
  } // centsToDollars

  /**
   * Generate a line for this purchase appropriate for a receipt.
   *
   * @param p
   *   The item we are purchasing.
   *
   * @return one line of the receipt.
   */
  public static String receiptLine(Purchase p) {
    String info = p.toString();
    if (info.length() > PURCHASE_WIDTH) {
      info = info.substring(0, PURCHASE_WIDTH);
    } // if too wide

    if (info.length() < PURCHASE_WIDTH) {
      info = info + " " + ".".repeat(PURCHASE_WIDTH - info.length());
    } // if
    return info + String.format("%6s", centsToDollars(p.cost()));
  } // receiptLine(Purchase)

  /**
   * Print out a receipt for a set of purchases.
   *
   * @param pen
   *   The PrintWriter used for printing.
   *
   * @param purchases
   *   The array of purchases to print.
   */
  public static void printReceipt(PrintWriter pen, Purchase[] purchases) {
    int totalCost = 0;
    for (Purchase p : purchases) {
      pen.println(receiptLine(p));
      totalCost += p.cost();
    } // for
    String total = centsToDollars(totalCost);
    pen.println();
    pen.printf("TOTAL: %s$%s\n",
        " ".repeat(RECEIPT_WIDTH - 8 - total.length()),
        total);
  } // printReceipt(PrintWriter, Purchase)

} // class StoreUtils
