public class LinkedListDeque<T> {

    private class IntNode {

        public T item;
        public IntNode next;
        public IntNode prev;

        public IntNode(IntNode prev, T item, IntNode next) {

            this.prev = prev;
            this.item = item;
            this.next = next;
        }
    }

    private IntNode sentinel;
    private int size;

    public LinkedListDeque() {

        sentinel = new IntNode(null, null, null);
        size = 0;

        sentinel.prev = sentinel;
        sentinel.next = sentinel;
    }

    public LinkedListDeque(T x) {

        sentinel = new IntNode(null, null, null);
        size = 1;

        sentinel.next = new IntNode(sentinel, x, sentinel);
        sentinel.prev = sentinel.next;
    }

    public void addFirst(T x) {

        sentinel.next = new IntNode(sentinel, x, sentinel.next);
        sentinel.next.next.prev = sentinel.next;
        size++;
    }

    public void addLast(T x) {

        sentinel.prev = new IntNode(sentinel.prev, x, sentinel);
        sentinel.prev.prev.next = sentinel.prev;
        size++;

    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {

        if (size == 0) {
            System.out.println();
        } else {
            int count = size;
            IntNode ptr = sentinel.next;
            while (count > 0) {
                System.out.print(ptr.item + " ");
                ptr = ptr.next;
                count--;
            }
            System.out.println();
        }
    }

    public T removeFirst() {

        T toRemove = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;

        if (!isEmpty()) {
            size--;
        }

        return toRemove;

    }

    public T removeLast() {

        T toRemove = sentinel.prev.item;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;

        if (!isEmpty()) {
            size--;
        }

        return toRemove;

    }

    public T get(int index) {

        IntNode ptr = sentinel.next;

        for (int i = 0; i < index; i++) {

            ptr = ptr.next;
        }

        return ptr.item;
    }

    public LinkedListDeque(LinkedListDeque other) {

        sentinel = new IntNode(null,null,null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;

        for (int i = 0; i < other.size; i++) {
            addLast((T) other.get(i));
        }

    }

    private T getRecursive(int index, IntNode curr) {
        if (index == 0) {
            return curr.item;
        }
        return getRecursive(index - 1, curr.next);
    }

    public T getRecursive(int index) {
        return getRecursive(index, sentinel.next);
    }

    public static void main(String[] args) {

        LinkedListDeque<Integer> d1 = new LinkedListDeque<>(3);
        d1.addFirst(2);
        d1.addLast(3);
        d1.addLast(4);
        d1.addLast(5);
        d1.addLast(6);
        d1.printDeque();
        int a = d1.get(3);
        int b = d1.getRecursive(5);
        System.out.println(a);
        System.out.println(b);
    }
}
