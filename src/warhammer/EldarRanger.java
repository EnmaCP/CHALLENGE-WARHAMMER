package warhammer;

import java.util.Random;

import static java.lang.Math.clamp;

public class EldarRanger extends UnitBase {

    private int precision; //0-100
    private static final Random random = new Random();

    public EldarRanger(String name, String faction, int hp, int precision) {
        super(name, faction, hp);
        this.precision = clamp(precision, 0, 100);
    }

    public int getPrecision() {
        return precision;
    }

    @Override
    public void battleCry() {
        System.out.println(getName() + ": Silent as the void.");
    }

    @Override
    public String toString() {
        return "EldarRanger{" +
                "precision=" + precision +
                '}';
    }
}
