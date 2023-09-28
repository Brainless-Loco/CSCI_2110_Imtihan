import java.util.ArrayList;

public class GenericStack<T> {
    private ArrayList<T> stack;
    private int size;

    public GenericStack() {
        stack = new ArrayList<>();
        size = 0;
    }

    public int size() {
        return size;
    }

    public T peek() {
        return stack.get(size - 1);
    }

    public void push(T item) {
        stack.add(item);
        size++;
    }

    public T pop() {
        T item = stack.get(size - 1);
        stack.remove(size-1);
        size--;
        return item;
    }

    public boolean isEmpty() {
        return size == 0;
    }

}
