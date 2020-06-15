package pl.alaran.pe.character;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "characters")
public class Character {

    public Integer getId() {
        return id;
    }

    public boolean isUnlocked() {
        return unlocked;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public int getExp() {
        return exp;
    }

    public int getForm() {
        return form;
    }

    public int getAttack() {
        return attack;
    }

    public int getHealth() {
        return health;
    }

    public int getDefense() {
        return defense;
    }

    public double getAccuracy() {
        return accuracy;
    }

    public double getDodge() {
        return dodge;
    }

    public double getCritical_chance() {
        return critical_chance;
    }

    public double getCritical_damage() {
        return critical_damage;
    }

    @PrimaryKey(autoGenerate = true)
    private Integer id;
    private boolean unlocked;
    private String name;
    private int level;
    private int exp;
    private int form;
    private int attack;
    private int health;
    private int defense;
    private double accuracy;
    private double dodge;
    private double critical_chance;
    private double critical_damage;

    public Character(Integer id, boolean unlocked, String name, int level, int exp, int form, int attack, int health, int defense, double accuracy, double dodge, double critical_chance, double critical_damage) {
        this.id = id;
        this.unlocked = unlocked;
        this.name = name;
        this.level = level;
        this.exp = exp;
        this.form = form;
        this.attack = attack;
        this.health = health;
        this.defense = defense;
        this.accuracy = accuracy;
        this.dodge = dodge;
        this.critical_chance = critical_chance;
        this.critical_damage = critical_damage;
    }

}
