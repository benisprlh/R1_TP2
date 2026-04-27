public class QueuePelanggan {
    private Node front;
    private Node rear;
    private int size;
    private final int kapasitasMaks;

    public QueuePelanggan(int kapasitasMaks) {
        this.front = null;
        this.rear = null;
        this.size = 0;
        this.kapasitasMaks = kapasitasMaks;
    }

    public boolean enqueue(String nomor, String nama, double total) {
        if (size >= kapasitasMaks) {
            return false;
        }
        Node baru = new Node(nomor, nama, total);
        if (rear == null) {
            front = rear = baru;
        } else {
            rear.next = baru;
            rear = baru;
        }
        size++;
        return true;
    }

    public Node dequeue() {
        if (front == null) {
            return null;
        }
        Node keluar = front;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        keluar.next = null;
        size--;
        return keluar;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public int getSize() {
        return size;
    }

    public int getKapasitasMaks() {
        return kapasitasMaks;
    }

    public Node getFront() {
        return front;
    }
}
