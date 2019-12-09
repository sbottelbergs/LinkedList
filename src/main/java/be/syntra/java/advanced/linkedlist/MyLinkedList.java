package be.syntra.java.advanced.linkedlist;

public class MyLinkedList<E> implements MyList<E>, MyQueue<E> {
    private LinkedNode<E> root;
    private int size;

    public MyLinkedList() {
        size = 0;
    }

    @Override
    public boolean add(E e) {
        LinkedNode<E> newNode = new LinkedNode<>(e);
        if (root != null) {
            LinkedNode<E> node = root;
            while (node.getNext() != null) {
                node = node.getNext();
            }
            node.setNext(newNode);
        } else {
            root = newNode;
        }
        size++;
        return true;
    }

    @Override
    public void add(int i, E e) {
        if (i > size) {
            throw new IndexOutOfBoundsException(i);
        }
        LinkedNode<E> newNode = new LinkedNode<>(e);
        if (root == null) {
            root = newNode;
        } else {
            LinkedNode<E> node = root;
            LinkedNode<E> previousNode = null;
            for (int count = 0; count < i && count < size; count++) {
                previousNode = node;
                node = node.getNext();
            }
            newNode.setNext(node);
            if (previousNode != null) {
                previousNode.setNext(newNode);
            } else {
                root = newNode;
            }
        }
        size++;
    }

    @Override
    public void set(int i, E e) {
        if (i >= size) {
            throw new IndexOutOfBoundsException(i);
        }

        LinkedNode<E> node = root;
        for (int count = 0; count < i; count++) {
            node = node.getNext();
        }
        node.setData(e);
    }

    @Override
    public E get(int i) {
        if (i >= size) {
            throw new IndexOutOfBoundsException(i);
        }

        LinkedNode<E> node = root;
        for (int count = 0; count < i; count++) {
            node = node.getNext();
        }
        return node.getData();
    }

    @Override
    public boolean remove(E e) {
        if (root != null) {
            LinkedNode<E> node = root;
            LinkedNode<E> previousNode = null;
            for (int i = 0; i < size; i++) {
                if (node.getData().equals(e)) {
                    if (previousNode != null) {
                        previousNode.setNext(node.getNext());
                    } else {
                        root = node.getNext();
                    }
                    size--;
                    return true;
                }
                previousNode = node;
                node = node.getNext();
            }
        }
        return false;
    }

    @Override
    public void clear() {
        this.root = null;
        size = 0;
    }

    @Override
    public boolean contains(Object o) {
        if (root != null) {
            LinkedNode<E> node = root;
            while (node != null) {
                if (node.getData().equals(o)) {
                    return true;
                }
                node = node.getNext();
            }
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public E peek() {
        return (root != null) ? root.getData() : null;
    }

    @Override
    public E remove() {
        if (root != null) {
            LinkedNode<E> node = root;
            root = root.getNext();
            size--;
            return node.getData();
        }
        return null;
    }
}
