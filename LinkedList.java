public class LinkedList{
  Node head;

  public void append(int d){
    if(head == null){
      head = new Node(d);
      return;
    }

    Node current = head;
    while(current.next != null){
      current = current.next;
    }
    current.next = new Node(d);
  }

  public void prepend(int d){
    Node newHead = new Node(d);
    newHead.next = head;
    head = newHead;
  }

  public void delete(int d){
    if(head == null) return;

    if(head.data == d){
      head = head.next;
      return;
    }

    Node current = head;
    while(current.next != null){
      if(current.next.data == d){
        current.next = current.next.next;
        return;
      }
      current = current.next;
    }
  }

  public void removeDups(){
    Node pointer1 = head;
    Node pointer2;

    while(pointer1.next != null && pointer1.next != null){
      pointer2 = pointer1;

      while(pointer2.next != null){
        if(pointer1.data == pointer2.next.data){
          pointer2.next = pointer2.next.next;
        }else{
          pointer2 = pointer2.next;
        }
      }
      pointer1 = pointer1.next;
    }
  }

  public int length(){
    int l = 1;
    if(head == null) return 0;

    if(head.next == null) return l;

    Node current = head;
    while(current.next != null){
      l++;
      current = current.next;
    }

    return l;
  }

  public void print(){
    Node current = head;
    String output = "";
    while(current.next != null){
      output += current.data + " -> ";
      current = current.next;
    }
    output += current.data;
    System.out.println(output);
  }
}