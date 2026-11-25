public class Mahasiswa {
    private String nim;
    private String nama;
    private String jurusan;
    private int semester;

    public Mahasiswa() {
        this.nim = "";
        this.nama = "";
        this.jurusan = "";
        this.semester = 1;
    }

    public Mahasiswa(String nim, String nama, String jurusan, int semester) {
        this.nim = nim;
        this.nama = nama;
        this.jurusan = jurusan;
        this.semester = semester;
    }

    public String getNim() {
        return nim;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        if (!nama.isEmpty()) {
            this.nama = nama;
        }
    }

    public void tampilkanInfo() {
        System.out.println("NIM      : " + nim);
        System.out.println("Nama     : " + nama);
        System.out.println("Jurusan  : " + jurusan);
        System.out.println("Semester  : " + semester);
    }
}