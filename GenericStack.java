import java.util.Iterator;
import java.util.NoSuchElementException;

public class GenericStack<Item> implements Iterable<Item>{
   private Node <Item> first = null;
   private int n = 0;

   private static class Node<Item>{
     private Item item;
     private Node <Item> next;
   }

   public boolean isEmpty(){
      return (first == null);
   }

   public int size(){
      return n;
   }

   public void push(Item item){
      Node <Item> oldFirst = first;
      first = new Node <Item> ();
      first.item = item;
      first.next = oldFirst;
      n++;
   }

   public Item pop(){
      if (isEmpty()) throw new NoSuchElementException("Stack underflow");
      Item item = first.item;
      first = first.next;
      n--;
      return item;
   }

   public Item peek(){
      if (isEmpty()) throw new NoSuchElementException("Stack underflow");
      return first.item;
   }

   public Iterator <Item> iterator(){
      return new ListIterator <Item> (first);
   }

   private class ListIterator<Item> implements Iterator<Item>{
      private Node <Item> current;
      public ListIterator(Node <Item> first){
        current = first;
      }
      public boolean hasNext(){
        return (current!=null);
      }
      public void remove(){
        throw new UnsupportedOperationException();
      }
      public Item next(){
        if(!hasNext()) throw new NoSuchElementException();
        Item item = current.item;
        current = current.next;
        return item;
      }
   }
   public static void main(String []args){
      GenericStack <String> g = new GenericStack <String> ();
      g.push("hello");
      g.push("how");
      g.push("are");
      Iterator iterator = g.iterator();
      while(iterator.hasNext()){
        System.out.println(iterator.next() + " ");
      }
   }
}
