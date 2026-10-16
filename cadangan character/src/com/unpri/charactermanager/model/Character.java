package com.unpri.charactermanager.model;

/**
 * Merepresentasikan satu karakter dalam aplikasi Character Manager.
 * Menerapkan prinsip Encapsulation: semua atribut private,
 * akses hanya melalui getter/setter.
 */
public class Character {

    // ===== ATRIBUT PRIVATE =====
    private int id;
    private String name;
    private CharacterType type;
    private int level;
    private int hitPoints;
    private int attackPower;
    private int mana; // Atribut baru untuk Mini-Challenge

    // ===== CONSTRUCTOR 1: MEMBUAT KARAKTER BARU =====
    public Character(String name, CharacterType type, int level) {
        this.name = name;
        this.type = type;
        this.level = level;
        this.hitPoints = calculateBaseHP();
        this.attackPower = calculateBaseAttack();
        this.mana = 0;
    }

    // ===== CONSTRUCTOR 2: MEMUAT KARAKTER DARI DATABASE =====
    public Character(int id, String name, CharacterType type,
            int level, int hitPoints, int attackPower) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.level = level;
        this.hitPoints = hitPoints;
        this.attackPower = attackPower;
        this.mana = 0;
    }

    // ===== HELPER PRIVATE =====
    private int calculateBaseHP() {
        return 100 + (level * 10);
    }

    private int calculateBaseAttack() {
        return 10 + (level * 5);
    }

    // ===== GETTER =====
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public CharacterType getType() {
        return type;
    }

    public int getLevel() {
        return level;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public int getAttackPower() {
        return attackPower;
    }

    // Getter baru untuk mana
    public int getMana() {
        return mana;
    }

    // ===== SETTER =====
    public void setId(int id) {
        this.id = id;
    }

    public void setLevel(int level) {
        if (level < 1) {
            throw new IllegalArgumentException(
                    "Level minimal adalah 1");
        }

        this.level = level;
        this.hitPoints = calculateBaseHP();
        this.attackPower = calculateBaseAttack();
    }

    // Setter baru dengan validasi mana
    public void setMana(int mana) {
        if (mana < 0) {
            throw new IllegalArgumentException(
                    "Mana tidak boleh negatif");
        }

        this.mana = mana;
    }

    // ===== MEMERIKSA STATUS HIDUP KARAKTER =====
    public boolean isAlive() {
        return hitPoints > 0;
    }

    // ===== TOSTRING =====
    @Override
    public String toString() {
        return "Character{id=" + id +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", level=" + level +
                ", hp=" + hitPoints +
                ", atk=" + attackPower +
                ", mana=" + mana +
                '}';
    }
}
