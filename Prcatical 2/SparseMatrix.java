import java.util.Scanner;

class SparseMatrix {
    private int rows;
    private int cols;
    private int[][] matrix;

    public SparseMatrix(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.matrix = new int[rows][cols];
    }

    // Insert element into the matrix
    public void insert(int row, int col, int value) {
        if (row >= 0 && row < rows && col >= 0 && col < cols) {
            matrix[row][col] = value;
            System.out.println("Element inserted successfully.");
        } else {
            System.out.println("Invalid position. Insertion failed.");
        }
    }

    // Display the original matrix
    public void display() {
        System.out.println("Original Matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Convert the matrix to a sparse representation
    public int[][] toSparse() {
        int count = 0;

        // Count non-zero elements
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] != 0) {
                    count++;
                }
            }
        }

        // Create sparse matrix
        int[][] sparseMatrix = new int[count + 1][3];
        sparseMatrix[0][0] = rows;
        sparseMatrix[0][1] = cols;
        sparseMatrix[0][2] = count;

        int k = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] != 0) {
                    sparseMatrix[k][0] = i;
                    sparseMatrix[k][1] = j;
                    sparseMatrix[k][2] = matrix[i][j];
                    k++;
                }
            }
        }

        return sparseMatrix;
    }

    // Display the sparse matrix representation
    public void displaySparse(int[][] sparseMatrix) {
        System.out.println("\nSparse Matrix:");
        for (int i = 0; i < sparseMatrix.length; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(sparseMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of rows in the matrix: ");
        int rows = scanner.nextInt();
        System.out.print("Enter the number of columns in the matrix: ");
        int cols = scanner.nextInt();

        SparseMatrix sparseMatrix = new SparseMatrix(rows, cols);

        // Insert elements into the matrix
        System.out.println("Enter the elements of the matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print("Enter element at position (" + i + ", " + j + "): ");
                int value = scanner.nextInt();
                sparseMatrix.insert(i, j, value);
            }
        }

        // Display the original matrix
        sparseMatrix.display();

        // Convert and display the sparse matrix representation
        int[][] sparseRep = sparseMatrix.toSparse();
        sparseMatrix.displaySparse(sparseRep);

        scanner.close();
    }
}