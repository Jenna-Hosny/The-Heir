package gameItems;

public class MeleeWeapon extends Item {
  private int damage;
  private int range;
  private int attackSpeed;

  public MeleeWeapon(String name, String description, int damage, int range, int attackSpeed) {
    super(name, description);
    this.damage = damage;
    this.range = range;
    this.attackSpeed = attackSpeed;
  }

  public int getDamage() {
    return damage;
  }

  public int getRange() {
    return range;
  }

  public int getAttackSpeed() {
    return attackSpeed;
  }
}