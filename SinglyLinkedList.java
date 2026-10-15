/**
 * SinglyLinkedList
 */
public class SinglyLinkedList implements LinkedList {

    public Node head, tail;
    private int size = 0;

    public SinglyLinkedList() {
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
        Node baru = new Node(inputData);
        if (isEmpty()) {
            head = baru;
            tail = baru;
        } else {
            baru.pointer = head;
            head = baru;
        }
        size++;
    }

    @Override
    public void addLast(Object inputData) {
        Node baru = new Node(inputData);
        if (isEmpty()) {
            head = baru;
            tail = baru;
        } else {
            tail.pointer = baru;
            tail = baru;
        }
        size++;
    }

    @Override
    public void addAfter(int index, Object inputData) {
        if (index < 0 || index >= size) {
            System.err.println("Indeks di luar jangkauan");
            return;
        }
        if (index == size - 1) {
            addLast(inputData);
            return;
        }
        Node baru = new Node(inputData);
        Node C = head;
        for (int i = 0; i < index; i++) {
            C = C.pointer;
        }
        baru.pointer = C.pointer;
        C.pointer = baru;
        size++;
    }

    @Override
    public void deleteFirst() {
        if (isEmpty()) {
            System.err.println("Linked list kosong");
            return;
        }
        if (size == 1) {
            head = null;
            tail = null;
        } else {
            head = head.pointer;
        }
        size--;
    }

    @Override
    public void deleteLast() {
        if (isEmpty()) {
            System.err.println("Linked list kosong");
            return;
        }
        if (size == 1) {
            head = null;
            tail = null;
        } else {
            Node temp = head;
            for (int i = 0; i < size - 2; i++) {
                temp = temp.pointer;
            }
            tail = temp;
            tail.pointer = null;
        }
        size--;
    }

    @Override
    public void deleteAfter(int index) {
        if (isEmpty()) {
            System.err.println("Linked list kosong");
            return;
        }
        if (index < 0 || index >= size - 1) {
            System.err.println("Tidak ada elemen setelah indeks tersebut");
            return;
        }
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.pointer;
        }
        if (temp.pointer == tail) {
            tail = temp;
            tail.pointer = null;
        } else {
            temp.pointer = temp.pointer.pointer;
        }
        size--;
    }

    @Override
    public void print() {
        Node currentNode = head;
        while (currentNode != null) {
            System.out.println(currentNode.data);
            currentNode = currentNode.pointer;
        }
    }


    // a. Mengembalikan data pada index ke-i
    @Override
    public Object get(int index) {
        if (index < 0 || index >= size || head == null) {
            return null;
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.pointer;
        }
        return current.data;
    }

    // b. Mencari kemunculan pertama targetData
    @Override
    public int indexOf(Object targetData) {
        Node current = head;
        int index = 0;
        while (current != null) {
            if ((targetData == null && current.data == null) || 
                (targetData != null && targetData.equals(current.data))) {
                return index;
            }
            current = current.pointer;
            index++;
        }
        return -1;
    }

    // c. Mencetak data secara terbalik (tail ke head)
    @Override
    public void printReverse() {
        printReverseHelper(head);
    }

    private void printReverseHelper(Node node) {
        if (node == null) {
            return;
        }
        printReverseHelper(node.pointer);
        System.out.println(node.data);
    }

    // d. Mencari dan menghapus node dengan targetData
    @Override
    public boolean remove(Object targetData) {
        if (isEmpty()) {
            return false;
        }

        if ((targetData == null && head.data == null) || 
            (targetData != null && targetData.equals(head.data))) {
            deleteFirst();
            return true;
        }

        Node current = head;
        while (current.pointer != null) {
            if ((targetData == null && current.pointer.data == null) || 
                (targetData != null && targetData.equals(current.pointer.data))) {
                
                if (current.pointer == tail) {
                    tail = current;
                }
                current.pointer = current.pointer.pointer;
                size--;
                return true;
            }
            current = current.pointer;
        }
        return false;
    }

    // e. Mengubah linked list menjadi array dari head ke tail
    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        Node current = head;
        int index = 0;
        while (current != null) {
            array[index++] = current.data;
            current = current.pointer;
        }
        return array;
    }
}