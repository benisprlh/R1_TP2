public class StackRiwayat {
    private Node top;

    public StackRiwayat() {
        this.top = null;
    }

    public void push(Node data) {
        if (data == null) {
            return;
        }
        data.next = top;
        top = data;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public Node getTop() {
        return top;
    }
}
