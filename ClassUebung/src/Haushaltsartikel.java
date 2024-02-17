public class Haushaltsartikel extends Waren{
    private int recylingAnteil;

    public Haushaltsartikel(String name, double EK, double VK, int anteile) {
        super(name,EK,VK);
        this.recylingAnteil = anteile;
    }
}