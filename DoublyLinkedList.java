/**
 * DoublyLinkedList
 */
public class DoublyLinkedList implements LinkedList {
    private Node2P head, tail;
    int size = 0;

    public DoublyLinkedList() {
        head = tail = null;
    }

    @Override
    public boolean isEmpty() {
        return (size == 0);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void addFirst(Object inputData) {
        Node2P baru = new Node2P(inputData);
        if (isEmpty()) {
            head = baru;
            tail = baru;
        } else {
            baru.next = head;
            head.prev = baru;
            head = baru;
        }
        size++;
    }

    @Override
    public void addLast(Object inputData) {
        Node2P baru = new Node2P(inputData);
        if (isEmpty()) {
            head = baru;
            tail = baru;
        } else {
            tail.next = baru;
            baru.prev = tail;
            tail = baru;
        }
        size++;
    }

    @Override
    public void addAfter(int index, Object inputData) {
        if (index < 0 || index >= size) {
            System.out.println("Indeks di luar jangkauan");
            return;
        }

        if (index == size - 1) {
            addLast(inputData);
            return;
        }

        Node2P baru = new Node2P(inputData);
        Node2P temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }

        baru.prev = temp;
        baru.next = temp.next;
        if (temp.next != null) {
            temp.next.prev = baru;
        }
        temp.next = baru;
        size++;
    }

    @Override
    public void deleteFirst() {
        if (!isEmpty()) {
            if (head == tail) {
                head = tail = null;
            } else {
                head = head.next;
                head.prev = null;
            }
            size--;
        } else {
            System.out.println("List kosong!");
        }
    }

    @Override
    public void deleteLast() {
        if (!isEmpty()) {
            if (tail == head) {
                head = tail = null;
            } else {
                tail = tail.prev;
                tail.next = null;
            }
            size--;
        } else {
            System.out.println("List kosong!");
        }
    }

    @Override
    public void deleteAfter(int index) {
        if (isEmpty()) {
            System.out.println("List kosong!");
            return;
        }
        if (index < 0 || index >= size - 1) {
            System.out.println("Tidak ada elemen setelah indeks tersebut");
            return;
        }

        Node2P temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }

        if (temp.next == tail) {
            deleteLast();
        } else {
            temp.next = temp.next.next;
            temp.next.prev = temp;
            size--;
        }
    }

    @Override
    public void print() {
        Node2P currentNode = head;
        while (currentNode != null) {
            System.out.println(currentNode.data);
            currentNode = currentNode.next;
        }
    }

    // =========================================================
    // IMPLEMENTASI METHOD TUGAS (a - e)
    // =========================================================

    // a. Mengembalikan data pada index ke-i
    @Override
    public Object get(int index) {
        if (index < 0 || index >= size || head == null) {
            return null;
        }
        
        // Optimasi traversal: cari dari head atau tail berdasarkan posisi index
        Node2P current;
        if (index < size / 2) {
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--) {
                current = current.prev;
            }
        }
        return current.data;
    }

    // b. Mencari kemunculan pertama targetData
    @Override
    public int indexOf(Object targetData) {
        Node2P current = head;
        int index = 0;
        while (current != null) {
            if ((targetData == null && current.data == null) || 
                (targetData != null && targetData.equals(current.data))) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    // c. Mencetak data secara terbalik (tail ke head)
    @Override
    public void printReverse() {
        Node2P current = tail;
        while (current != null) {
            System.out.println(current.data);
            current = current.prev;
        }
    }

    // d. Mencari dan menghapus node dengan data targetData
    @Override
    public boolean remove(Object targetData) {
        if (isEmpty()) {
            return false;
        }

        // Jika data berada di head
        if ((targetData == null && head.data == null) || 
            (targetData != null && targetData.equals(head.data))) {
            deleteFirst();
            return true;
        }

        // Jika data berada di tail
        if ((targetData == null && tail.data == null) || 
            (targetData != null && targetData.equals(tail.data))) {
            deleteLast();
            return true;
        }

        // Cari di tengah list
        Node2P current = head.next;
        while (current != null && current != tail) {
            if ((targetData == null && current.data == null) || 
                (targetData != null && targetData.equals(current.data))) {
                
                current.prev.next = current.next;
                current.next.prev = current.prev;
                size--;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // e. Mendapatkan keseluruhan data dalam bentuk Array (head ke tail)
    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        Node2P current = head;
        int index = 0;
        while (current != null) {
            array[index++] = current.data;
            current = current.next;
        }
        return array;
    }
}