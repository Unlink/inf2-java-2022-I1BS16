package sk.uniza.fru.inf2.snake.had;

public enum Smer {
    HORE(0, 1),
    DOLE(0, -1),
    VPRAVO(1, 0),
    VLAVO(-1, 0);

    private final int posunX;
    private final int posunY;

    Smer(int posunX, int posunY) {
        this.posunX = posunX;
        this.posunY = posunY;
    }

    public int getPosunX() {
        return posunX;
    }

    public int getPosunY() {
        return posunY;
    }
}
