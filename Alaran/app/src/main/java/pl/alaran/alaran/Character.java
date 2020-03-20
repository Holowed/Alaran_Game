package pl.alaran.alaran;

public class Character {
    private String Name;
    private Integer Level;
    private Integer Form;
    private Double Attack;
    private Double Defense;
    private Double HP;
    private Double Speed;
    private Double Accuracy;
    private Double Evasion;
    private Double Crit_rate;
    private Double Crit_dmg;

    Character(String name, int[] basic)
    {
        Name = name;
        Level = basic[0];
        Form = basic[1];
        Attack = basic[2]*2.5*Level+5*Form;
        Defense = basic[3]*2.5*Level+5*Form;
        HP = basic[4]*2.5*Level+5*Form;
        Speed = basic[5]*2.5*Level+5*Form;
        Accuracy = (double)basic[6];
        Evasion = (double)basic[7];
        Crit_rate = (double)basic[8];
        Crit_dmg = (double)basic[9];
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Integer getLevel() {
        return Level;
    }

    public void setLevel(Integer level) throws Exception {
        if(level>=0 && level<=200)
        {
            Level = level;
        } else {
            throw new Exception("Wrong level value!");
        }

    }

    public Integer getForm() {
        return Form;
    }

    public void setForm(Integer form) throws Exception {
        if(form>=0 && form<=7)
        {
            Form = form;
        } else {
            throw new Exception("Wrong form value!");
        }
    }

    public Double getAttack() {
        return Attack;
    }

    public void setAttack(Double attack) {
        Attack = attack;
    }

    public Double getDefense() {
        return Defense;
    }

    public void setDefense(Double defense) {
        Defense = defense;
    }

    public Double getHP() {
        return HP;
    }

    public void setHP(Double HP) {
        this.HP = HP;
    }

    public Double getSpeed() {
        return Speed;
    }

    public void setSpeed(Double speed) {
        Speed = speed;
    }

    public Double getAccuracy() {
        return Accuracy;
    }

    public void setAccuracy(Double accuracy) throws Exception {
        if(accuracy >=0 && accuracy <= 1.0) {
            Accuracy = accuracy;
        } else {
            throw new Exception("Wrong accuracy value!");
        }
    }

    public Double getEvasion() {
        return Evasion;
    }

    public void setEvasion(Double evasion) throws Exception {
        if(evasion >=0 && evasion <= 1.0) {
            Evasion = evasion;
        } else {
            throw new Exception("Wrong evasion value!");
        }
    }

    public Double getCrit_rate() {
        return Crit_rate;
    }

    public void setCrit_rate(Double crit_rate) throws Exception {
        if(crit_rate >= 0 && crit_rate <= 1.0) {
            Crit_rate = crit_rate;
        } else {
            throw new Exception("Wrong crit_rate value!");
        }
    }

    public Double getCrit_dmg() {
        return Crit_dmg;
    }

    public void setCrit_dmg(Double crit_dmg)  throws Exception {
        if(crit_dmg >= 0) {
            Crit_dmg = crit_dmg;
        } else {
            throw new Exception("Crit_dmg can't be negative!");
        }
    }
}
