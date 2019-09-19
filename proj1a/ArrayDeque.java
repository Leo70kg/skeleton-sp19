public class ArrayDeque<T> {

    private T[] items;
    private int nextFirst;
    private int nextLast;
    private int size;

    public ArrayDeque() {

        items = (T[]) new Object[8];
        nextFirst = 0;
        nextLast = 1;
        size = 0;
    }

    private boolean isFull() {

        return size == items.length;

    }

    private boolean isSparse() {

        return items.length >= 16 && size < (items.length / 4);
    }

    private int plusOne(int index) {

        return (index + 1) % items.length;
    }
    private void resize(int capacity) {
        if (size == items.length) {
            T[] a = (T[]) new Object[capacity];
            System.arraycopy(items, 0, a, 0, size);
            items = a;
        }

    }

    public void addLast(T x) {

        if (size == items.length) {
            resize(size * 2);
        }

        items[size] = x;
        size++;
    }

    public T getLast() {

        return items[size - 1];
    }

    public T get(int index) {

        return items[index];
    }

    public int size() {
        return size;
    }

    public T removeLast() {
        T returnItem = getLast();
        items[size - 1] = null;
        size--;

        return returnItem;
    }


    public static void main(String[] args) {

         ArrayDeque<Integer> a = new ArrayDeque<>();
         a.addLast(2);
         a.addLast(3);
         a.getLast();
    }
}
