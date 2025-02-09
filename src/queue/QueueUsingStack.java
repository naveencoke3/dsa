package queue;

import java.util.Queue;
import java.util.Stack;

/*
Implement a First In First Out (FIFO) queue using stacks only.
The implemented queue should support all the functions of a normal queue (push, peek, pop, and empty).
Implement the UserQueue class:
void push(int X) : Pushes element X to the back of the queue.
int pop() : Removes the element from the front of the queue and returns it.
int peek() : Returns the element at the front of the queue.
boolean empty() : Returns true if the queue is empty, false otherwise.
NOTES:
You must use only standard operations of a stack, which means only push to top, peek/pop from top, size, and is empty operations are valid.
Depending on your language, the stack may not be supported natively. You may simulate a stack using a list or deque (double-ended queue) as long as you use only a stack's standard operations.
Input 1:
 1) UserQueue()
 2) push(20)
 3) empty()
 4) peek()
 5) pop()
 6) empty()
 7) push(30)
 8) peek()
 9) push(40)
 10) peek()
 Output 1:
 false
 20
 20
 true
 30
 30
 Explanation 1:

 Queue => 20
 Queue => -
 Queue => 30
 Queue => 30, 40
 */
public class QueueUsingStack {

    public static void main(String[] args) {
        UserQueue queue = new UserQueue();
        queue.push(20);
        System.out.println(queue.empty());
        System.out.println(queue.peek());
        System.out.println(queue.pop());
        System.out.println(queue.empty());
        queue.push(30);
        System.out.println(queue.peek());
        queue.push(40);
        System.out.println(queue.peek());
    }

    public static class UserQueue {
        static Stack<Integer> stack1;
        static Stack<Integer> stack2;
        UserQueue() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }

        static void push(int X) {
            stack1.push(X);
        }

        static int pop() {
            if(empty()){
                return -1;
            }
            if(stack2.isEmpty()){
                while(!stack1.isEmpty()){
                    stack2.push(stack1.pop());
                }
            }
            return stack2.pop();
        }

        static int peek() {
            if(empty()){
                return -1;
            }
            if(stack2.isEmpty()){
                while(!stack1.isEmpty()){
                    stack2.push(stack1.pop());
                }
            }
            return stack2.peek();
        }

        static boolean empty() {
            return stack1.isEmpty()&&stack2.isEmpty();
        }
    }
}
