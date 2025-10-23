public class Jagung extends Tanaman {
    public Jagung() {
        super("Jagung", 3, 2);
    }

    @Override
    public void tumbuh(Cuaca cuaca) {
        super.tumbuh(cuaca);
        if (cuaca.getKondisi().equals("Cerah")) {
            umur++; 
            System.out.println("🌞 Jagung tumbuh lebih cepat di cuaca cerah!");
        }
    }

    @Override
    public void pupuk() {
        umur += 2;
        System.out.println("🌽 Jagung menyerap pupuk dengan baik! Umur sekarang: " + umur);
        if (umur >= waktuPanen) siapPanen = true;
    }
}
