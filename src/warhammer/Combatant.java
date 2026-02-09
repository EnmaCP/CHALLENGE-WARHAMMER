package warhammer;

public interface Combatant {
    int attack(); //devuelve el daño que hace
    void battleCry(); //imprime su grito de guerra
    boolean isAlive(); //si sigue vivo
    String getName(); //para imprimir quién es
}
