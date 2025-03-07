
public class Mahasiswa {
    private String nim;
    private String nama;
    private String alamat;
    private int semester;
    private int sks;
    private double ipk;

    public Mahasiswa(String nim, String nama, String alamat, int semester, int sks, double ipk) {
        this.nim = nim;
        this.nama = nama;
        this.alamat = alamat;
        this.semester = semester;
        this.sks = sks;
        this.ipk = ipk;
    }

    public String getNim() { return nim; }
    public String getNama() { return nama; }
    public String getAlamat() { return alamat; }
    public int getSemester() { return semester; }
    public int getSks() { return sks; }
    public double getIpk() { return ipk; }

    public void setNama(String nama) { this.nama = nama; }
    public void setAlamat(String alamat) { this.alamat = alamat; }
    public void setSemester(int semester) { this.semester = semester; }
    public void setSks(int sks) { this.sks = sks; }
    public void setIpk(double ipk) { this.ipk = ipk; }

    @Override
    public String toString() {
        return nim + "," + nama + "," + alamat + "," + semester + "," + sks + "," + ipk;
    }
}