import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Database db = new Database();

        while (true) {
            System.out.println("=============================================================");
            System.out.println("|  Pilih menu: |");
            System.out.println("|  [C] : Create (Tambah Data) |");
            System.out.println("|  [R] : Read (Lihat Data)   |");
            System.out.println("|  [U] : Update (Perbarui Data) |");
            System.out.println("|  [D] : Delete (Hapus Data) |");
            System.out.println("|  [X] : Exit (Keluar)   |");
            System.out.println("=============================================================");
            System.out.print("Pilih: ");
            String pilihan = scanner.nextLine().toUpperCase();

            switch (pilihan) {
                case "C":
                    System.out.print("Masukkan NIM: ");
                    String nim = scanner.nextLine();
                    System.out.print("Masukkan Nama: ");
                    String nama = scanner.nextLine();
                    System.out.print("Masukkan Alamat: ");
                    String alamat = scanner.nextLine();
                    System.out.print("Masukkan Semester: ");
                    int semester = Integer.parseInt(scanner.nextLine());
                    System.out.print("Masukkan SKS: ");
                    int sks = Integer.parseInt(scanner.nextLine());
                    System.out.print("Masukkan IPK: ");
                    double ipk = Double.parseDouble(scanner.nextLine());

                    db.addMahasiswa(new Mahasiswa(nim, nama, alamat, semester, sks, ipk));
                    System.out.println("Data berhasil ditambahkan!");
                    break;

                case "R":
                    System.out.println("==========================================================================");
                    System.out.println("|    NIM    |       Nama       |   Alamat   | Semester |  SKS  |  IPK  |");
                    System.out.println("==========================================================================");
                    for (Mahasiswa mhs : db.getAllMahasiswa()) {
                        System.out.printf("| %-10s | %-15s | %-10s | %-8d | %-5d | %-4.2f |\n",
                                mhs.getNim(), mhs.getNama(), mhs.getAlamat(),
                                mhs.getSemester(), mhs.getSks(), mhs.getIpk());
                    }
                    System.out.println("==========================================================================");
                    break;

                case "U":
                    System.out.print("Masukkan NIM yang ingin diupdate: ");
                    nim = scanner.nextLine();
                    Mahasiswa mhs = db.findMahasiswa(nim);
                    if (mhs != null) {
                        System.out.print("Masukkan Nama Baru: ");
                        nama = scanner.nextLine();
                        System.out.print("Masukkan Alamat Baru: ");
                        alamat = scanner.nextLine();
                        System.out.print("Masukkan Semester Baru: ");
                        semester = Integer.parseInt(scanner.nextLine());
                        System.out.print("Masukkan SKS Baru: ");
                        sks = Integer.parseInt(scanner.nextLine());
                        System.out.print("Masukkan IPK Baru: ");
                        ipk = Double.parseDouble(scanner.nextLine());

                        db.updateMahasiswa(nim, nama, alamat, semester, sks, ipk);
                        System.out.println("Data berhasil diperbarui!");
                    } else {
                        System.out.println("Mahasiswa tidak ditemukan!");
                    }
                    break;

                case "D":
                    System.out.print("Masukkan NIM yang ingin dihapus: ");
                    nim = scanner.nextLine();
                    db.deleteMahasiswa(nim);
                    System.out.println("Data berhasil dihapus!");
                    break;

                case "X":
                    System.out.println("Keluar...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Pilihan tidak valid!");
            }
        }
    }
}