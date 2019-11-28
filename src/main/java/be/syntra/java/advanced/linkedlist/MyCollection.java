package be.syntra.java.advanced.linkedlist;

public interface MyCollection<E> {
    void add(E e);
    boolean remove(E e);
    void clear();
    boolean contains(Object o);
    int size();
}
