package warhammer;

import static java.lang.Math.clamp;

public class OrkBoy extends UnitBase {

    private int rage; //0-100
    private int waagh; //contador de gritos/energía

    public OrkBoy(String name, String faction, int hp, int rage) {
        super("Orks", faction, hp);
        this.rage = clamp(rage, 0, 100);
        this.waagh = 0;
    }

    public int getRage() {
        return rage;
    }

    public void setRage(int rage) {
        this.rage = rage;
    }

    public int getWaagh() {
        return waagh;
    }

    public void setWaagh(int waagh) {
        this.waagh = waagh;
    }

    public void getAngrier(){
        rage = clamp(rage + 15, 0, 100);
    }

    @Override
    public int attack() {
        //cuanto mas rage, más pega
        return 8 + (rage/20); //0....5 extra
    }

    @Override
    public void battleCry() {
        waagh++;
        System.out.println(getName() + ": WAAAAGH! ("+ waagh + ")");
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
        return "OrkBoy{" +
                "rage=" + rage +
                ", waagh=" + waagh +
                '}';
    }
}
