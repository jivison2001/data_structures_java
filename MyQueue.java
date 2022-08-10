import java.util.EmptyStackException;

/*represents a queue using two stacks */
public class MyQueue<T> {
  private Stack<T> s1;/*this stack will represent the order of the queue */
  private Stack<T> s2;/*this stack will be used to obtain the first item of the queue */

  public MyQueue(){
    s1 = new Stack<T>();
    s2 = new Stack<T>();
  }

  public void add(T item){
    s1.push(item);
  }

  public T remove(){
    if(s1.isEmpty() ) throw new EmptyStackException();
    while(!s1.isEmpty()){
      s2.push(s1.pop());
    }
    T retItem = s2.pop(); /*item to be returned (what is at the front of the queue)*/
    while(!s2.isEmpty()){
      s1.push(s2.pop());
    }
    return retItem;
  }

  public T peek(){
    if(s1.isEmpty()) throw new EmptyStackException();
    while(!s1.isEmpty()){
      s2.push(s1.pop());
    }
    T retItem = s2.peek(); /*peeks at the front of the queue, doesn't remove item*/
    while(!s2.isEmpty()){
      s1.push(s2.pop());
    }
    return retItem;
  }

  public boolean isEmpty(){
    return s1.isEmpty() && s2.isEmpty();
  }
}