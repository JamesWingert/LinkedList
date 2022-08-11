public class LinkedListDeque<T> {
    public class Node {
        private Node prev;
        private T item;
        private Node next;

        public Node(Node p, T i, Node n) {
            prev = p;
            item = i;
            next = n;
        }
    }

    private Node sentinel;
    private int size;
    /** Constructors. */
    public LinkedListDeque() {
        sentinel = new Node(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    public void addFirst(T item) {
        // sentinel.next is similar to front
        sentinel.next.prev = new Node(sentinel, item, sentinel.next);
        sentinel.next = sentinel.next.prev;
        size += 1;
    }

    public void addLast(T item) {
        // sentinel.prev is similar to back
        sentinel.prev.next = new Node(sentinel.prev, item, sentinel);
        sentinel.prev = sentinel.prev.next;
        size += 1;
    }

    public boolean isEmpty() {
        while(size == 0) {
            return true;
        }
        return false;
    }

    public int size() {
        return size;
    }
    }
}