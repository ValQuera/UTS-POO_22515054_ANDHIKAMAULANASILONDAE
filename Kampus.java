public class Kampus {
    private String namaKampus;
    private MataKuliah[] daftarMK;
    private KRS[] daftarKRS;
    private int jumlahMK;
    private int jumlahKRS;

    public Kampus() {
        namaKampus = "Kampus Akademik Mini";
        daftarMK = new MataKuliah[100];
        daftarKRS = new KRS[100];
        jumlahMK = 0;
        jumlahKRS = 0;
    }

    public Kampus(String namaKampus) {
        this.namaKampus = namaKampus;
        daftarMK = new MataKuliah[100];
        daftarKRS = new KRS[100];
        jumlahMK = 0;
        jumlahKRS = 0;
    }

    public String getNamaKampus() {
        return namaKampus;
    }

    public MataKuliah cariMataKuliah(String kode) {
        for (int i = 0; i < jumlahMK; i++) {
            if (daftarMK[i].getKode().equalsIgnoreCase(kode)) {
                return daftarMK[i];
            }
        }

        return null;
    }

    public boolean tambahMataKuliah(MataKuliah mk) {
        if (jumlahMK >= daftarMK.length) {
            return false;
        }

        if (cariMataKuliah(mk.getKode()) != null) {
            System.out.println("Kode mata kuliah sudah ada.");
            return false;
        }

        daftarMK[jumlahMK] = mk;
        jumlahMK++;
        return true;
    }

    public void tampilkanMataKuliah() {
        if (jumlahMK == 0) {
            System.out.println("Belum ada mata kuliah.");
            return;
        }

        for (int i = 0; i < jumlahMK; i++) {
            System.out.println("-------------------");
            daftarMK[i].tampilkanInfo();
        }
    }

    public KRS cariKRS(String nim) {
        for (int i = 0; i < jumlahKRS; i++) {
            if (daftarKRS[i].getNim().equals(nim)) {
                return daftarKRS[i];
            }
        }

        return null;
    }

    public boolean tambahKRS(String nim, String nama) {
        if (jumlahKRS >= daftarKRS.length) {
            System.out.println("Data KRS penuh.");
            return false;
        }

        if (cariKRS(nim) != null) {
            return true;
        }

        daftarKRS[jumlahKRS] = new KRS(nim, nama);
        jumlahKRS++;
        return true;
    }

    public void tampilkanSemuaKRS() {
        if (jumlahKRS == 0) {
            System.out.println("Belum ada data KRS.");
            return;
        }

        for (int i = 0; i < jumlahKRS; i++) {
            System.out.println("===================");
            daftarKRS[i].tampilkanKRS();
        }
    }

    public int getJumlahMK() {
        return jumlahMK;
    }

    public int getJumlahKRS() {
        return jumlahKRS;
    }
}