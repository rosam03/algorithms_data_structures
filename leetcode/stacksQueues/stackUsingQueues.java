
/* LEETCODE #225 */

/*

Implement the following operations of a stack using queues.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
empty() -- Return whether the stack is empty.

Notes:

You must use only standard operations of a queue -- which means only push to back, peek/pop from front, size, and is empty operations are valid.
Depending on your language, queue may not be supported natively. You may simulate a queue by using a list or deque (double-ended queue), as long as you use only standard operations of a queue.
You may assume that all operations are valid (for example, no pop or top operations will be called on an empty stack).

*/


class MyStack {

  // implementing a stack using two queues
  private Queue<Integer> q1 ;
  private Queue<Integer> q2;
  // popFirst is true when first stack has most recent element
  private boolean popFirst;

  /** Initialize your data structure here. */
  public MyStack() {
    popFirst = true;
    q1 = new LinkedList<Integer>();
    q2 = new LinkedList<Integer>();
  }

  /** Push element x onto stack. */
  public void push(int x) {

    if (popFirst) {
      // q1 has the most recent elements
      q1.add(x);
      return;
    }
    q2.add(x);
  }

  /** Removes the element on top of the stack and returns that element. */
  public int pop() {

    // use q2 as a buffer, last element to pop from q1 is the most recent
    if (popFirst) {
      int val = q1.remove();
      while (q1.peek() != null) {
        q2.add(val);
        val = q1.remove();
      }
      // rather than copying all back to q1, save time and work with q2
      popFirst = false;
      return val;
    }

    // use q1 as buffer, last element to pop from q2 is most recent
    int val = q2.remove();
    while (q2.peek() != null) {
      q1.add(val);
      val = q2.remove();
    }
    popFirst = true;
    return val;


  }

  /** Get the top element. */
  public int top() {

    // move elements to q2, last element to pop from q1 is returned
    if (popFirst) {
      int val = q1.remove();
      while (q1.peek() != null) {
        q2.add(val);
        val = q1.remove();
      }
      q2.add(val); // add val back since just peeking
      popFirst = false;
      return val;
    }

    // move elements to q1, last element to pop from q2 is returned
    int val = q2.remove();
    while (q2.peek() != null) {
      q1.add(val);
      val = q2.remove();
    }
    q1.add(val);
    popFirst = true;
    return val;


  }

  /** Returns whether the stack is empty. */
  public boolean empty() {
    if (q1.size() == 0 && q2.size() == 0) {
      return true;
    }

    return false;

  }
}

/**
* Your MyStack object will be instantiated and called as such:
* MyStack obj = new MyStack();
* obj.push(x);
* int param_2 = obj.pop();
* int param_3 = obj.top();
* boolean param_4 = obj.empty();
*/
