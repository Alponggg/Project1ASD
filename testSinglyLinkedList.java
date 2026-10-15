import java.util.Arrays;

/**
 * testSinglyLinkedList
 */
public class testSinglyLinkedList {

    public static void main(String[] args) {
        SinglyLinkedList linkedList = new SinglyLinkedList();
        
        // Penambahan data menggunakan addFirst:
        // urutan elemen dari head ke tail menjadi: 6 -> 5 -> 4 -> 3 -> 2 -> 1
        linkedList.addFirst(1);
        linkedList.addFirst(2);
        linkedList.addFirst(3);
        linkedList.addFirst(4);
        linkedList.addFirst(5);
        linkedList.addFirst(6);

        // a. Method get(index)
        System.out.println("Data index 2: " + linkedList.get(2));   // Menghasilkan 4 (index 0=6, 1=5, 2=4)
        System.out.println("Data index 12: " + linkedList.get(12)); // Menghasilkan null (karena index > size)

        // b. Method indexOf(targetData)
        System.out.println("Index data 4: " + linkedList.indexOf(4));   // Menghasilkan 2
        System.out.println("Index data 10: " + linkedList.indexOf(10)); // Menghasilkan -1

        // c. Method printReverse()
        System.out.println("Cetak Terbalik (Tail ke Head):");
        linkedList.printReverse(); // Mencetak: 1, 2, 3, 4, 5, 6 secara berurutan ke bawah

        // d. Method remove(targetData)
        System.out.println("Remove 3: " + linkedList.remove(3)); // Menghasilkan true
        System.out.println("Remove 8: " + linkedList.remove(8)); // Menghasilkan false

        // e. Method toArray()
        // Menggunakan Arrays.toString agar tidak memicu warning IDE 'Array instance printed on PrintStream'
        System.out.println("Array: " + Arrays.toString(linkedList.toArray())); 
        // Menghasilkan [6, 5, 4, 2, 1] (karena angka 3 sudah dihapus sebelumnya)
    }
}