package edu.grinnell.csc207.store;

/**
 * Items purchased individually.
 */
public class Item implements Purchase {
  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The name of the item.
   */
  String name;

  /**
   * A description of the item.
   */
  String description;

  /**
   * The cost per item (in cents).
   */
  int cost;

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a new item.
   *
   * @param itemName
   *   The name of the item.
   *
   * @param itemDescription
   *   A desciption of the item.
   *
   * @param itemCost
   *   The cost of the item.
   */
  public Item(String itemName, String itemDescription, int itemCost) {
    this.name = itemName;
    this.description = itemDescription;
    this.cost = itemCost;
  } // Item(String, String, int)

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Determine the cost of this purchase.
   *
   * @return the cost in cents
   */
  public int cost() {
    return this.cost;
  } // cost()

  /**
   * Convert to a string.
   *
   * @return the item as a string.
   */
  public String toString() {
    return String.format("%s (at $%s)",
        this.name, StoreUtils.centsToDollars(this.cost()));
  } // toString()
} // class Item

