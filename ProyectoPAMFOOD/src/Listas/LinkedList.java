package Listas;

import java.util.ArrayList;
import java.util.Iterator;

public class LinkedList<T> implements List<T> {

    public LinkedListNode head;
    public LinkedListNode tail;

    public LinkedList() {
        this.head = null;
        this.tail = null;
    }

    public LinkedList(T object) {
        this.head = tail = new LinkedListNode(object);
    }

    public boolean add(T object) {
        boolean c = false;
        try {
            if (object != null) {
                if (isEmpty()) {
                    head = new LinkedListNode(object);// se crea un nuevo nodo después del último nodo
                    tail = head; // la cola también apunta al nuevo nodo
                } else {
                    tail.next = new LinkedListNode(object);
                    tail.next.previous = tail;
                    tail = tail.next;
                }
                c = true;
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            return c;
        }
    }

    public boolean add(Node node, T object) {
        boolean c = false;
        try {
            LinkedListNode nodo = (LinkedListNode) node;
            LinkedListNode nodoNuevo = new LinkedListNode(object);
            if (nodo.next == null) {
                nodo.next = nodoNuevo;
                nodoNuevo.previous = nodo;
                tail = nodoNuevo;
            } else {
                nodo.next.previous = nodoNuevo;
                nodoNuevo.next = nodo.next;
                nodoNuevo.previous = nodo;
                nodo.next = nodoNuevo;
            }
            c = true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            return c;
        }
    }

    public boolean add(Node node, Node next) {
        boolean c = false;
        try {
            LinkedListNode nodo = (LinkedListNode) node;
            LinkedListNode nodoNuevo = (LinkedListNode) next;
            if (nodo.next == null) {
                nodo.next = nodoNuevo;
                nodoNuevo.previous = nodo;
                tail = nodoNuevo;
            } else {
                nodo.next.previous = nodoNuevo;
                nodoNuevo.next = nodo.next;
                nodoNuevo.previous = nodo;
                nodo.next = nodoNuevo;
            }
            c = true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            return c;
        }
    }

    public boolean add(T[] objects) {
        boolean c = false;
        try {
            for (T object : objects) {
                LinkedListNode nodoNuevo = new LinkedListNode(object);
                add(tail, object);
            }
            c = true;
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean add(Node node, T[] objects) {
        boolean c = false;
        try {
            LinkedListNode nodo = (LinkedListNode) node;
            if (nodo.next != null) {
                for (T object : objects) {
                    LinkedListNode nodoNuevo = new LinkedListNode(object);
                    nodoNuevo.next = nodo.next;
                    nodo.next.previous = nodoNuevo;
                    nodo.next = nodoNuevo;
                    nodoNuevo.previous = nodo;
                    nodo = nodoNuevo;
                }
            } else {
                for (T object : objects) {
                    LinkedListNode nodoNuevo = new LinkedListNode(object);
                    tail.next = nodoNuevo;
                    nodoNuevo.previous = tail;
                    tail = nodoNuevo;
                }
            }
            c = true;
            return c;
        } catch (Exception e) {
            e.printStackTrace();
            return c;
        }
    }

    public boolean addFirst(T object) {
        boolean c = false;
        try {
            LinkedListNode nodoNuevo = new LinkedListNode(object);
            nodoNuevo.next = head;
            head.previous = nodoNuevo;
            head = nodoNuevo;
            c = true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            return c;
        }
    }

    public boolean addFirst(T[] objects) {
        boolean c = false;
        try {
            for (T object : objects) {
                LinkedListNode nodoNuevo = new LinkedListNode(object);
                nodoNuevo.next = head;
                head.previous = nodoNuevo;
                head = nodoNuevo;
            }
            c = true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            return c;
        }
    }

    public boolean addLast(T object) {
        boolean c = false;
        try {
            LinkedListNode nodoNuevo = new LinkedListNode(object);
            tail.next = nodoNuevo;
            nodoNuevo.previous = tail;
            tail = nodoNuevo;
            c = true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            return c;
        }
    }

    public boolean addLast(T[] objects) {
        boolean c = false;
        try {
            for (T object : objects) {
                LinkedListNode nodoNuevo = new LinkedListNode(object);
                tail.next = nodoNuevo;
                nodoNuevo.previous = tail;
                tail = nodoNuevo;
                c = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            return c;
        }
    }

    public boolean clear() {
        boolean c = false;
        try {
            head = tail = null;
            c = true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            return c;
        }
    }

    public List clone() {
        Iterator iterador = iterator();
        LinkedList cloned = new LinkedList();
        while (iterador.hasNext()) {
            LinkedListNode nodoTemp = (LinkedListNode) iterador.next();
            cloned.add(nodoTemp.getObject());
        }
        return cloned;
    }

    public boolean contains(T object) {
        boolean c = false;
        try {
            Iterator iterador = iterator();
            while (iterador.hasNext()) {
                LinkedListNode nodo = (LinkedListNode) iterador.next();
                if (nodo.getObject().equals(object)) {
                    c = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            return c;
        }
    }

    public boolean contains(T[] objects) {
        boolean c = true;
        try {
            int i = 0;
            Iterator iterator = iterator();
            for (T object : objects) {
                while (iterator.hasNext()) {
                    LinkedListNode nodo = (LinkedListNode) iterator.next();
                    if (!(nodo.getObject().equals(object))) {
                        c = false;
                        break;
                    }
                }
                if (!c) {
                    break;
                }
                i++;

            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    public Node nodeOf(T object) {
        LinkedListNode nodeof = null;
        Iterator iterador = iterator();

        while (iterador.hasNext()) {
            LinkedListNode nodo = (LinkedListNode) iterador.next();
            if (nodo.getObject().equals(object)) {
                nodeof = nodo;
                break;
            }
        }
        return nodeof;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public T get() {
        return (T) tail.getObject();
    }

    public T get(Node node) {
        return (T) node.getObject();
    }

    public T getPrevious(Node node) {
        LinkedListNode nodo = (LinkedListNode) node;
        return (T) nodo.previous.getObject();
    }

    public T getNext(Node node) {
        LinkedListNode nodo = (LinkedListNode) node;
        return (T) nodo.next.getObject();
    }

    public T getFirst() {
        return (T) head.getObject();
    }

    public T[] getFirst(int n) {
        T[] a = null;
        ArrayList<T> array = new ArrayList<>();
        Iterator iterador = iterator();

        while (n>0) {
            LinkedListNode nodo = (LinkedListNode) iterador.next();
            array.add((T) nodo.getObject());
            n--;
        }
        return array.toArray(a);
    }

    public T getLast() {
        return (T) tail.getObject();
    }

    public T[] getLast(int n) {
        Object[] elements = new Object[n];
        int i = 0;
        int j = 0;
        for (LinkedListNode<T> x = head; x != null; x = x.next) {
            if (j >= size() - n) {
                elements[i++] = x.getObject();
            }
            j++;
        }
        return (T[]) elements;
    }

    public T pop() {
        LinkedListNode pop = tail;
        LinkedListNode anterior = (LinkedListNode) nodeOf(getPrevious(tail));
        anterior.next = null;
        tail = anterior;
        return (T) pop.getObject();
    }

    public boolean remove(T object) {
        boolean c = false;
        try {
            LinkedListNode<T> remove = (LinkedListNode<T>) nodeOf(object);
            LinkedListNode<T> anterior = (LinkedListNode<T>) nodeOf(getPrevious(remove));
            anterior.next = remove.next;
            remove.next.previous = anterior;
            c = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return c;
        }
    }

    public boolean remove(Node node) {
        boolean c = false;
        try {
            LinkedListNode<T> remove = (LinkedListNode<T>) node;
            LinkedListNode<T> anterior = (LinkedListNode<T>) nodeOf(getPrevious(remove));
            anterior.next = remove.next;
            remove.next.previous = anterior;
            c = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return c;
        }
    }

    public boolean removeAll(T[] objects) {
        try {
            for (T object : objects) {
                remove(object);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean retainAll(T[] objects) {
        
        try {
            Iterator iterator = iterator();
            LinkedList list = new LinkedList();
            for (T object : objects) {
                while (iterator.hasNext()) {
                    LinkedListNode nodo = (LinkedListNode) iterator.next();
                    if (nodo.getObject().equals(object)) {
                        list.add(nodo.getObject());
                    }
                }
            }
            head = list.head;
            tail = list.tail;
            return true;
        } catch (Exception e) {
            e.getStackTrace();
            return false;
        }
    }

    public boolean set(Node node, T object) {
        boolean c = false;
        try {
            node.setObject(object);
            c = true;
        } catch (Exception e) {
            e.getStackTrace();
        } finally {
            return c;
        }
    }

    public int size() {
        Iterator iterador = iterator();
        int tm = 0;
        while (iterador.hasNext()) {
            iterador.next();
            tm++;
        }
        return tm;
    }

    public List subList(Node from, Node to) {
        LinkedList<T> lista2 = new LinkedList<T>();
        lista2.head = (LinkedListNode<T>) from;
        lista2.tail = (LinkedListNode<T>) to;
        LinkedList<T> listaR = (LinkedList<T>) lista2.clone();
        listaR.tail.next = null;
        return listaR;
    }

    public T[] toArray() {
        Object[] array = new Object[size()];
        int i = 0;
        Iterator iterador = iterator();
        while (iterador.hasNext()) {
            LinkedListNode next = (LinkedListNode) iterador.next();
            array[i++] = next.getObject();
        }
        return (T[]) array;
    }

    public boolean orderBy(char c) {
        return false;
    }

    public String toString() {
        String string = "";
        Iterator iterator = iterator();
        while (iterator.hasNext()) {
            LinkedListNode next = (LinkedListNode) iterator.next();
            string += next.toString() + ", ";
        }
        string += null;
        return string;
    }

    public void print() {
        if (head == null) {
            System.out.println("Lista vacia");
        } else {
            System.out.println(toString());
        }

    }

    public Iterator<Node> iterator() {
        Iterator<Node> iterador = new Iterator<>() {
            LinkedListNode nodoActual = head;
            LinkedListNode nodoTemp = null;

            int iteracion = 0;

            public boolean hasNext() {
                boolean c = false;
                try {
                    if (nodoActual.next != null) {
                        c = true;
                    }
                } catch (Exception e) {
                    System.err.println(e.getStackTrace());
                } finally {
                    return c;
                }
            }

            public Node next() {
                try {
                    if (iteracion != 0) {
                        nodoActual = nodoActual.next;
                    }
                    iteracion++;
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    return nodoActual;
                }
            }
        };
        return iterador;
    }

}
