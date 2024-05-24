package Listas;

public class LinkedListNode<T> implements Node<T> {

    private T object;
    
    public LinkedListNode next;
    public LinkedListNode previous;

    public LinkedListNode() {
        this.object = null;
    }

    public LinkedListNode(T object) {
        this.object = object;
    }
    
    @Override
    public boolean setObject(T object) {
        this.object = object;
        return true;
    }

    @Override
    public T getObject() {
        return this.object;
    }

    @Override
    public boolean isEquals(T object) {
        boolean c=false;
        if(this.object==object){
            c=true;
            return c;
        }else{
            return c;
        }
    }

    @Override
    public String toString() {
        return object.toString();
    }

    
    
}
