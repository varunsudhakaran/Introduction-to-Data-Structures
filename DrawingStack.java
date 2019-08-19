import java.util.Iterator;

public class DrawingStack implements StackADT<DrawingChange>{

  protected Node<DrawingChange> top;
  public int size;
  
  public static void main(String[] args) {
    

  }
  public DrawingStack() {
    size = 0;
    top = null;
  }

  @Override
  public void push(DrawingChange element) throws IllegalArgumentException {
    
    
    if(element == null)
      throw new IllegalArgumentException();
    if (top == null) {
      top =  new Node<DrawingChange>(element,null);
      size++;
    }
    else {
      Node<DrawingChange> nt = new Node<DrawingChange>(element,top);
      top = nt;
      size++;
      
    }
    
    
    
  }

  @Override
  public DrawingChange pop() {
    if(top == null) {
      return null;
    }
    Node<DrawingChange> temp = new Node<DrawingChange>(top.getData(),top.getNext());
    top = top.getNext();
    size--;
    return temp.getData();

  }

  @Override
  public DrawingChange peek() {
    if(top == null) {
      return null;
    }
    return top.getData();
  }

  @Override
  public boolean isEmpty() {
   if(top == null)
     return true;
   else
     return false;
  }

  @Override
  public int size() {
    
    return size;
  }

  @Override
  public Iterator<DrawingChange> iterator() {
    
    return new DrawingStackIterator(top);
  }


}
