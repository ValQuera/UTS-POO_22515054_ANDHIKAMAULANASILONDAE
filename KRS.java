public class KRS {
    private String nim;
    private String namaMahasiswa;
    private String[] kodeMK;
    private int jumlahMK;
    private int totalSKS;

    public KRS() {
        nim = "";
        namaMahasiswa = "";
        kodeMK = new String[10];
        jumlahMK = 0;
        totalSKS = 0;
    }

    public KRS(String nim, String namaMahasiswa) {
        this.nim = nim;
        this.namaMahasiswa = namaMahasiswa;
        kodeMK = new String[10];
        jumlahMK = 0;
        totalSKS = 0;
    }

    public String getNim() {
        return nim;
    }

    public int getTotalSKS() {
        return totalSKS;
    }

    public boolean tambahMataKuliah(MataKuliah mk) {
        if (jumlahMK >= kodeMK.length) {
            System.out.println("KRS sudah penuh.");
            return false;
        }

        if (totalSKS + mk.getSks() > 24) {
            System.out.println("Gagal! Total SKS tidak boleh lebih dari 24.");
            return false;
        }

        if (!mk.tersedia()) {
            System.out.println("Gagal! Kuota mata kuliah sudah penuh.");
            return false;
        }

        for (int i = 0; i < jumlahMK; i++) {
            if (kodeMK[i].equals(mk.getKode())) {
                System.out.println("Mata kuliah sudah dimasukkan.");
                return false;
            }
        }

        kodeMK[jumlahMK] = mk.getKode();
        jumlahMK++;
        totalSKS += mk.getSks();
        mk.tambahPeserta();

        System.out.println("Mata kuliah berhasil ditambahkan ke KRS.");
        return true;
    }

    public void tampilkanKRS() {
        System.out.println("\nNIM           : " + nim);
        System.out.println("Nama Mahasiswa: " + namaMahasiswa);
        System.out.println("Daftar Mata Kuliah:");

        if (jumlahMK == 0) {
            System.out.println("Belum mengambil mata kuliah.");
        }

        for (int i = 0; i < jumlahMK; i++) {
            System.out.println((i + 1) + ". " + kodeMK[i]);
        }

        System.out.println("Total SKS     : " + totalSKS);
    }
}