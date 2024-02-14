// Name: Manas Sunil Patil
// Enrollment Number: 202203103510235
// Branch: B.Tech. Computer Science and Engineering
// Practical 1: Implement a program for stack that performs following operations using array. (a) PUSH (b) POP (c) PEEP (d) CHANGE (e) DISPLAY

import java.util.Scanner;

class Stack {
    private int maxSize;
    private int[] stackArray;
    private int top;

    public Stack(int size) {
        maxSize = size;
        stackArray = new int[maxSize];
        top = -1;
    }

    public void push(int value) {
        if (top < maxSize - 1) {
            stackArray[++top] = value;
            System.out.println("Pushed " + value + " onto the stack.");
        } else {
            System.out.println("Stack is full, cannot push " + value);
        }
    }

    public int pop() {
        if (top >= 0) {
            int value = stackArray[top--];
            System.out.println("Popped " + value + " from the stack.");
            return value;
        } else {
            System.out.println("Stack is empty, cannot pop.");
            return -1;
        }
    }

    public int peep() {
        if (top >= 0) {
            return stackArray[top];
        } else {
            System.out.println("Stack is empty, cannot peep.");
            return -1;
        }
    }

    public void change(int index, int value) {
        if (index >= 0 && index <= top) {
            stackArray[index] = value;
            System.out.println("Changed value at index " + index + " to " + value);
        } else {
            System.out.println("Invalid index or stack is empty.");
        }
    }

    public void display() {
        if (top >= 0) {
            System.out.print("Stack: ");
            for (int i = top; i >= 0; i--) {
                System.out.print(stackArray[i] + " ");
            }
            System.out.println();
        } else {
            System.out.println("Stack is empty.");
        }
    }
}

public class Practical3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the stack: ");
        int size = scanner.nextInt();
        Stack stack = new Stack(size);

        while (true) {
            System.out.println("\nChoose an operation:");
            System.out.println("1. PUSH");
            System.out.println("2. POP");
            System.out.println("3. PEEP");
            System.out.println("4. CHANGE");
            System.out.println("5. DISPLAY");
            System.out.println("6. EXIT");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value to push: ");
                    int pushValue = scanner.nextInt();
                    stack.push(pushValue);
                    break;
                case 2:
                    stack.pop();
                    break;
                case 3:
                    int peepValue = stack.peep();
                    if (peepValue != -1) {
                        System.out.println("Peeped value: " + peepValue);
                    }
                    break;
                case 4:
                    System.out.print("Enter index to change: ");
                    int index = scanner.nextInt();
                    System.out.print("Enter new value: ");
                    int newValue = scanner.nextInt();
                    stack.change(index, newValue);
                    break;
                case 5:
                    stack.display();
                    break;
                case 6:
                    System.out.println("Exiting program.");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a number from 1 to 6.");
            }
        }
    }
}