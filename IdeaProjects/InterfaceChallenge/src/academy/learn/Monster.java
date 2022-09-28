package academy.learn;

import java.util.ArrayList;
import java.util.List;

public class Monster implements ISaveable {
    private String name;
    private int hitPoint;
    private int strength;

    public Monster(String name, int hitPoint, int strength) {
        this.name = name;
        this.hitPoint = hitPoint;
        this.strength = strength;
    }

    public String getName() {
        return name;
    }

    public int getHitPoint() {
        return hitPoint;
    }

    public int getStrength() {
        return strength;
    }

    @Override
    public String toString() {
        return "Monster{" +
                "name='" + name + '\'' +
                ", hitPoint='" + hitPoint + '\'' +
                ", strength=" + strength +
                '}';
    }

    @Override
    public List<String> write() {
        ArrayList<String>value =  new ArrayList<>();
        value.add(0,this.name);
        value.add(1,""+this.hitPoint);
        value.add(2,""+this.strength);
        return value;

    }

    @Override
    public void read(List<String> savedValues) {
        if (savedValues !=null &&savedValues.size()>0){
            this.name = savedValues.get(0);
            this.hitPoint = Integer.parseInt(savedValues.get(1));

        }
    }
}
