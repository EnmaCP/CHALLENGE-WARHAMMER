package warhammer;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        // 1) Creamos unidades (observa el super(...) por debug en cada constructor)
        Combatant u1 = new SpaceMarine("Titus", "Ultramarines", 60, 85); // combatant es el padre por eso podemos crear la unit asi
        Combatant u2 = new OrkBoy("Ghaz Jr.", "unknown", 55, 40);
        Combatant u3 = new EldarRanger("Iyanna", "unknown", 45, 80 );

        // 2) Polimorfismo: misma lista, tipos distintos
        List<Combatant> squad = new ArrayList<>();
        squad.add(u1); //añado los combatientes a la lista, aunque sean de tipos distintos, gracias al polimorfismo
        squad.add(u2);
        squad.add(u3);

        System.out.println("=== ROSTER ===");
        for (Combatant c : squad) {
            System.out.println(c); // toString dinámico
        }

        // 3) Cada uno lanza su grito (método del contrato)
        System.out.println("\n=== BATTLE CRIES ===");
        for (Combatant c : squad) {
            c.battleCry();
        }

        // 4) Simulación simple: todos atacan al objetivo 0 (Titus)
        //    Nota: receiveDamage no está en Combatant, así que necesitamos castear a UnitBase
        UnitBase target = (UnitBase) u1; //revisar esto con la IA, qué hace esta linea?

        System.out.println("\n=== FOCUS FIRE ON: " + target.getName() + " ===");
        for (Combatant attacker : squad) {
            if (attacker == target) continue;

            int dmg = attacker.attack();
            System.out.println(attacker.getName() + " hace " + dmg + " de daño a " + target.getName());
            target.receiveDamage(dmg);

            System.out.println("HP de " + target.getName() + ": " + target.getHp());
            if (!target.isAlive()) {
                System.out.println(target.getName() + " ha caído.");
                break;
            }
        }

        // 5) Demostración: acceso a métodos propios mediante casting seguro
        System.out.println("\n=== SPECIAL ACTIONS ===");
        if (u1 instanceof SpaceMarine) {
            ((SpaceMarine) u1).bolterBurst();
        }

        System.out.println("\n=== FINAL STATE ===");
        for (Combatant c : squad) {
            System.out.println(c.getName() + " alive? " + c.isAlive());
        }
    }
}
