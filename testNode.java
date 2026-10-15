public class testNode {
    public static void main(String[] args) {
        // Node 1: Inisialisasi lewat konstruktor dengan data
        Node baru = new Node(10);
        System.out.println("Data baru: " + baru.data);
        System.out.println("Pointer baru: " + baru.pointer);

        // Node 2: Inisialisasi lewat konstruktor (diisi null dulu), lalu ubah nilainya
        Node baru2 = new Node(null);
        baru2.data = 15;
        System.out.println("Data baru2: " + baru2.data);
        System.out.println("Pointer baru2: " + baru2.pointer);
    }
}