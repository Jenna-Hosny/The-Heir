package gameItems;

public class Consumable extends Item {
  private int healing;
  private int resistance;
  private int strength;
  private int duration;
  private int piercing;
  private String special;

  public Consumable(String name, String description, int healing, int resistance, int strength, int duration, int piercing, String special) {
    super(name, description);
    this.healing = healing;
    this.resistance = resistance;
    this.strength = strength;
    this.duration = duration;
    this.piercing = piercing;
    this.bounce = bounce;
  }

  public int getHealing() {
    return healing;
  }

  public int getResistance() {
    return resistance;
  }

  public int getStrength() {
    return strength;
  }

  public int getDuration() {
    return duration;
  }
  
  public int getPiercing() {
    return piercing;
  }

  public int getSpecial() {
    return special;
  }
}