public class MataKuliah {
    private String kode;
    private String nama;
    private int sks;
    private int kuota;
    private int jumlahPeserta;

    public MataKuliah() {
        kode = "";
        nama = "";
        sks = 0;
        kuota = 0;
        jumlahPeserta = 0;
    }

    public MataKuliah(String kode, String nama, int sks, int kuota) {
        this.kode = kode;
        this.nama = nama;
        this.sks = sks;
        this.kuota = kuota;
        this.jumlahPeserta = 0;
    }

    public String getKode() {
        return kode;
    }

    public String getNama() {
        return nama;
    }

    public int getSks() {
        return sks;
    }

    public int getKuota() {
        return kuota;
    }

    public int getJumlahPeserta() {
        return jumlahPeserta;
    }

    public boolean tersedia() {
        return jumlahPeserta < kuota;
    }

    public void tambahPeserta() {
        if (tersedia()) {
            jumlahPeserta++;
        }
    }

    public void tampilkanInfo() {
        System.out.println("Kode       : " + kode);
        System.out.println("Nama       : " + nama);
        System.out.println("SKS       : " + sks);
        System.out.println("Kuota     : " + kuota);
        System.out.println("Peserta   : " + jumlahPeserta);
    }
}