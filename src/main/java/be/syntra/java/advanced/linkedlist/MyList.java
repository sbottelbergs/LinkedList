package be.syntra.java.advanced.linkedlist;

public interface MyList<E> extends MyCollection<E> {
    void add(int i, E e);
    void set(int i, E e);
    E get(int i);
    boolean remove(int i);
}
