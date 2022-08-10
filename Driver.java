import java.util.EmptyStackException;

public class Driver {
  public static void main(String args[]){
    // LinkedList list = new LinkedList();
    // list.append(2);
    // list.append(3);
    // list.append(2);
    // list.append(4);
    // list.append(5);
    // list.append(3);

    // list.removeDups();

    // list.print();

    // Stack<Integer> s = new Stack<Integer>();
    // s.push(10);
    // s.push(20);
    // s.push(30);
    // s.print();
    // s.pop();
    // s.print();
    // System.out.println(s.peek());

    // Queue<Integer> q = new Queue<Integer>();
    // q.add(1);
    // q.add(2);
    // q.add(3);
    // q.print();
    // System.out.println(q.peek() + "\n");
    // q.remove();
    // q.print();

    Stack<Integer> s = new Stack<Integer>();
    s.push(5);
    s.push(4);
    s.push(6);
    s.push(2);
    s.push(3);
    s.print();
    System.out.println(" ");

    s = sortStack(s);
    s.print();
  }

  public static Stack<Integer> sortStack(Stack<Integer> s){
    Stack<Integer> t = new Stack<Integer>();
    int temp;
    if(s.isEmpty()) throw new EmptyStackException();

    t.push(s.pop());
    while(!s.isEmpty()){
      temp = s.pop();
      if(temp >= t.peek()){
        t.push(temp);
      }else{
        while(!t.isEmpty() && temp < t.peek()){
          s.push(t.pop());
        }
        t.push(temp);
      }
    }

    while(!t.isEmpty()){
      s.push(t.pop());
    }

    return s;
  }
}