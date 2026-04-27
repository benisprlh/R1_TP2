
public class LinkedListBuku {
    private Node head;
    private int size;

    public LinkedListBuku() {
        this.head = null;
        this.size = 0;
    }

    public void tambahAkhir(String kode, String judul, String penulis) {
        Node baru = new Node(kode, judul, penulis);
        if (head == null) {
            head = baru;
        } else {
            Node p = head;
            while (p.next != null) {
                p = p.next;
            }
            p.next = baru;
        }
        size++;
    }

    public boolean hapusTerakhir() {
        if (head == null) {
            return false;
        }
        if (head.next == null) {
            head = null;
        } else {
            Node p = head;
            while (p.next.next != null) {
                p = p.next;
            }
            p.next = null;
        }
        size--;
        return true;
    }

    public Node cari(String kodeBuku) {
        Node p = head;
        while (p != null) {
            if (p.kodeBuku.equals(kodeBuku)) {
                return p;
            }
            p = p.next;
        }
        return null;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public Node getHead() {
        return head;
    }
}
