package homework1;


import java.util.ArrayList;
import java.util.LinkedList;

class Node<T> {
    T item;
    Node<T> prev;
    Node<T> next;

    Node(T item, Node<T> prev, Node<T> next) {
        this.item = item;
        this.prev = prev;
        this.next = next;
    }

    T getItem() {
        return item;
    };
 }


public class MyLinkedList<T extends Comparable<T>> {

    private int size = 0;
    private Node<T> first = null;
    private Node<T> last = null;

    public void add(T value) {
        Node<T> newNode = new Node<T>(value, last, null);
        if (last == null) {
            first = newNode;
            last = newNode;
        }
        Node<T> lastNode = last;
        lastNode.next = newNode;
        last = newNode;
        size++;
    }
    public T get(int index) {
        if (index < 0 || index >= size) { throw new IndexOutOfBoundsException(); }
        Node<T> node = first;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
        return node.getItem();
    }
    public void remove(int index) {
        if (index < 0 || index >= size) { throw new IndexOutOfBoundsException(); }
        if (index == 0) {
            first.next.prev = null;
            return;
        } else
        if (index == size - 1) {
            last.prev.next = null;
            return;
        }
        Node<T> node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        node.prev.next = node.next;
        node.next.prev = node.prev;
        size--;
    }
    public void addAll(MyLinkedList<T> list) {
        for (int i = 0; i < list.size; i++) {
            add(list.get(i));
        }
    }

    public void set(int index, T value) {
        if (index < 0 || index >= size) { throw new IndexOutOfBoundsException();}
        Node<T> node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        node.item = value;
    }

    public static void sort(MyLinkedList list) {
        Comparable temp;
        for (int i = 0, end = list.size; i < list.size; i++, end--) {
            boolean sorted = true;
            for (int j = 0; j < end - 1; j++) {
                if (list.get(j).compareTo(list.get(j + 1)) > 0) {
                    sorted = false;
                    temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
            if (sorted) break;
        }
    }
}
