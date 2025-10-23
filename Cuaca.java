import java.util.Random;

public class Cuaca {
    private String kondisi;
    private String[] daftarCuaca = {"Cerah", "Hujan", "Panas"};

    public Cuaca() {
        ubahCuaca();
    }

    public void ubahCuaca() {
        Random r = new Random();
        kondisi = daftarCuaca[r.nextInt(daftarCuaca.length)];
    }

    public String getKondisi() {
        return kondisi;
    }
}
