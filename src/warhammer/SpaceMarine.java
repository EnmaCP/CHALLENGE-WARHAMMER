package warhammer;

import static java.lang.Math.clamp;

public class SpaceMarine extends UnitBase {

    private String chapter; //Ultramarines, Blood Angels...
    private int armor; //0-100


    public SpaceMarine(String name, String faction, int hp, int armor) {
        super("Imperium", faction, hp);
        this.chapter = chapter;
        this.armor = clamp(armor,0,100);
    }

    public String getChapter() {
        return chapter;
    }

    public void setChapter(String chapter) {
        this.chapter = chapter;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = clamp(armor,0,100);
    }
    //metodo propio
    public void bolterBurst(){
        System.out.println(getName() + " dispara una ráfaga de bólter!");
    }

    @Override
    public int attack() {
        //daño base + pequeño bonus por armadura alta (ejemplo simple)
        return 12 + (armor >=70 ? 3 : 0);
    }

    @Override
    public void battleCry() {
        System.out.println(getName() + " (" + chapter + "): For the Emperor!");
    }

    @Override
    public boolean isAlive() {
        return false;
    }

    @Override
    public String getName() {
        return "";
    }

    @Override
    public String toString() {
        return "SpaceMarine{" +
                "chapter='" + chapter + '\'' +
                ", armor=" + armor +
                '}';
    }
}
