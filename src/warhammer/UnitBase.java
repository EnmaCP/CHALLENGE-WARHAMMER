package warhammer;

import java.util.Objects;

public abstract class UnitBase implements Combatant {
    protected String name;
    protected String faction;
    protected int hp;

    public UnitBase(String name, String faction, int hp) {
        this.name = name;
        this.faction = faction;
        this.hp = hp;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    @Override
    public boolean isAlive() {
        return hp > 0;
    }

    public void setHp(int hp) {
        this.hp = Math.max(0,hp);
    }

    //METODO COMUN A TODOS
    public void receiveDamage(int dmg){
        if(dmg < 0) dmg = 0;
        setHp(this.hp - dmg);
    }

    //Igualdad base: mismo nombre + facción (puedes ajustar)

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if (!(o instanceof UnitBase unitBase)) return false;
        return hp == unitBase.hp &&
                Objects.equals(name, unitBase.name) &&
                Objects.equals(faction, unitBase.faction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, faction, hp);
    }

    @Override
    public String toString() {
        return "UnitBase{" +
                "name='" + name + '\'' +
                ", faction='" + faction + '\'' +
                ", hp=" + hp +
                '}';
    }

    //metodos override de Combatant
    @Override
    public int attack() {
        return 0;
    }

    @Override
    public void battleCry() {

    }
}
