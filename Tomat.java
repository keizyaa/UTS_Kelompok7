public class Tomat extends Tanaman {
    public Tomat() {
        super("Tomat", 2, 2);
    }

    @Override
    public void tumbuh(Cuaca cuaca) {
        super.tumbuh(cuaca);
        if (cuaca.getKondisi().equals("Hujan")) {
            umur++;
            System.out.println("🌧️ Tomat senang dengan hujan, tumbuh lebih subur!");
        }
    }

    @Override
    public void pupuk() {
        umur++;
        System.out.println("🍅 Tomat diberi pupuk organik, pertumbuhannya stabil.");
        if (umur >= waktuPanen) siapPanen = true;
    }
}
