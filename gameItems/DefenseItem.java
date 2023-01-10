package gameItems;

public class DefenseItem extends Item {
  private int protection;
  private int weight;

  public DefenseItem(String name, String description, int protection, int weight) {
    super(name, description);
    this.protection = protection;
    this.weight = weight;
  }

  public int getProtection() {
    return protection;
  }

  public int getWeight() {
    return weight;
  }
}