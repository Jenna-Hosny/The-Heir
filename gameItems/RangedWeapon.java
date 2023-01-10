package gameItems;

public class RangedWeapon extends Item {
  private int damage;
  private int range;
  private int fireSpeed;

  public RangedWeapon(String name, String description, int damage, int range, int fireSpeed) {
    super(name, description);
    this.damage = damage;
    this.range = range;
    this.fireSpeed = fireSpeed;
  }

  public int getDamage() {
    return damage;
  }

  public int getRange() {
    return range;
  }

  public int getFireSpeed() {
    return fireSpeed;
  }
}