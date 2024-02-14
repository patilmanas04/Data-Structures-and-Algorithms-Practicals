// Name: Manas Sunil Patil
// Enrollment Number: 202203103510235
// Branch: B.Tech. Computer Science and Engineering
// Practical 1: Implementation of Array operations - Insert, Delete, Search, Update, and Display.

import java.util.Scanner;

public class Practical1 {
    private static final int MAX_SIZE = 100; // Maximum size of the array
    private int[] array;
    private int size;

    public Practical1() {
        array = new int[MAX_SIZE];
        size = 0;
    }

    // Insert element at the end of the array
    public void insert(int element) {
        if (size < MAX_SIZE) {
            array[size++] = element;
            System.out.println("Element inserted successfully.");
        } else {
            System.out.println("Array is full. Cannot insert more elements.");
        }
    }

    // Delete element at a given index
    public void delete(int index) {
        if (index >= 0 && index < size) {
            for (int i = index; i < size - 1; i++) {
                array[i] = array[i + 1];
            }
            size--;
            System.out.println("Element deleted successfully.");
        } else {
            System.out.println("Invalid index. Deletion failed.");
        }
    }

    // Search for an element in the array
    public void search(int element) {
        for (int i = 0; i < size; i++) {
            if (array[i] == element) {
                System.out.println("Element found at index " + i);
                return;
            }
        }
        System.out.println("Element not found in the array.");
    }

    // Update element at a given index
    public void update(int index, int newValue) {
        if (index >= 0 && index < size) {
            array[index] = newValue;
            System.out.println("Element updated successfully.");
        } else {
            System.out.println("Invalid index. Update failed.");
        }
    }

    // Display elements of the array
    public void display() {
        System.out.print("Array elements: ");
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Practical1 arrayOps = new Practical1();
        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            System.out.println("\nArray Operations Menu:");
            System.out.println("1. Insert  2. Delete  3. Search  4. Update  5. Display  6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the element to insert: ");
                    int insertElement = scanner.nextInt();
                    arrayOps.insert(insertElement);
                    break;

                case 2:
                    System.out.print("Enter the index to delete: ");
                    int deleteIndex = scanner.nextInt();
                    arrayOps.delete(deleteIndex);
                    break;

                case 3:
                    System.out.print("Enter the element to search: ");
                    int searchElement = scanner.nextInt();
                    arrayOps.search(searchElement);
                    break;

                case 4:
                    System.out.print("Enter the index to update: ");
                    int updateIndex = scanner.nextInt();
                    System.out.print("Enter the new value: ");
                    int newValue = scanner.nextInt();
                    arrayOps.update(updateIndex, newValue);
                    break;

                case 5:
                    arrayOps.display();
                    break;

                case 6:
                    System.out.println("Exiting the program. Bye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        } while (choice != 6);

        scanner.close();
    }
}