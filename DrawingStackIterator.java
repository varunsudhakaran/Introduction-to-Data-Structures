import java.util.Iterator;

public class DrawingStackIterator implements Iterator<DrawingChange>{

 protected Node<DrawingChange> point;
 protected int currentIndex = 0;

  
  public DrawingStackIterator(Node<DrawingChange> element) {
    point = element;

  }
  @Override
  public boolean hasNext() {
    
    if(point != null)
      return true;
    else
      return false;
  }

  @Override
  public DrawingChange next() {
    
    if(!hasNext()) {
      return null;
    }

    else {
      
      DrawingChange current = point.getData();
      point = point.getNext();
    
      return current;
    }
    
  }

}
