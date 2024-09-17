package edu.grinnell.csc207.store;

/**
 * Items purchased in bulk (by weight).
 */
public class BulkItem implements Purchase {
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
   * The name of the units (e.g., "ounce").
   */
  String unit;

  /**
   * The cost per unit (in cents).
   */
  int costPerUnit;

  /**
   * The number of units.
   */
  int weight;

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
   * @param itemUnit
   *   The basic unit (e.g., "ounce" or "pound").
   *
   * @param itemCost
   *   The cost of the item per unit.
   *
   * @param itemWeight
   *   The weight of the item (in the given units).
   */
  public BulkItem(String itemName, String itemDescription, String itemUnit,
      int itemCost, int itemWeight) {
    this.name = itemName;
    this.description = itemDescription;
    this.unit = itemUnit;
    this.costPerUnit = itemCost;
    this.weight = itemWeight;
  } // BulkItem(String, String, int)

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Determine the cost of this purchase.
   *
   * @return the cost in cents
   */
  public int cost() {
    return this.costPerUnit * this.weight;
  } // cost()

  /**
   * Convert to a string.
   *
   * @return the item as a string.
   */
  public String toString() {
    return String.format("%s (%d %s at $%s per %s)",
        this.name,
        this.weight,
        this.weight == 1 ? this.unit : this.unit + "s",
        StoreUtils.centsToDollars(this.costPerUnit),
        this.unit);
  } // toString()
} // class BulkItem

