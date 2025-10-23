public class Gandum extends Tanaman {
    public Gandum() {
        super("Gandum", 4, 3);
    }

    @Override
    public void tumbuh(Cuaca cuaca) {
        super.tumbuh(cuaca);
        if (cuaca.getKondisi().equals("Panas")) {
            umur--;
            System.out.println("🔥 Gandum melambat tumbuh karena panas ekstrem!");
        }
    }

    @Override
    public void pupuk() {
        umur += 3;
        System.out.println("🌿 Gandum menyerap pupuk intensif! Umur sekarang: " + umur);
        if (umur >= waktuPanen) siapPanen = true;
    }
}
