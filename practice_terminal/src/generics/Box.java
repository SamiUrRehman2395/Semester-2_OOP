package generics;

public class Box<T> {
    private T item;

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }


    public static void displayBox(Box<?> box) {

    }
    public static<T> void displayBox(T[] arry) {

    }
}
