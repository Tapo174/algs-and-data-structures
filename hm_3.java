import java.util.Scanner;

class node {

    node left, right;
    int data;

// красный ==> true, черный ==> false
    boolean color;

    node(int data) {
        this.data = data;
        left = null;
        right = null;
        color = true;
    }
}

public class hm_3 {

    private static node root = null;

    node rotateLeft(node myNode) {
    System.out.printf("поворот влево!\n");
    node child = myNode.right;
    node childLeft = child.left;

    child.left = myNode;
    myNode.right = childLeft;

    return child;
  }

    node rotateRight(node myNode) {
        System.out.printf("поворот вправо\n");
        node child = myNode.left;
        node childRight = child.right;

        child.right = myNode;
        myNode.left = childRight;

        return child;
    }

    boolean isRed(node myNode) {
        if (myNode == null) {
        return false;
        }
        return (myNode.color == true);
    }

    void swapColors(node node1, node node2) {
        boolean temp = node1.color;
        node1.color = node2.color;
        node2.color = temp;
    }

    node insert(node myNode, int data) {
        if (myNode == null) {
        return new node(data);
        }

        if (data < myNode.data) {
        myNode.left = insert(myNode.left, data);
        } else if (data > myNode.data) {
        myNode.right = insert(myNode.right, data);
        } else {
        return myNode;
        }

// Случай 1. Когда правый дочерний элемент красный, а левый дочерний элемент черный или не существует.
    if (isRed(myNode.right) && !isRed(myNode.left)) {
        myNode = rotateLeft(myNode);
        swapColors(myNode, myNode.left);
    }

// Случай 2. Когда левый дочерний, а также левый потомок выделены красным цветом
    if (isRed(myNode.left) && isRed(myNode.left.left)) {
        myNode = rotateRight(myNode);
        swapColors(myNode, myNode.right);
    }

// Случай 3. Когда и левый, и правый дочерние элементы окрашены в красный цвет.
    if (isRed(myNode.left) && isRed(myNode.right)) {
// Изменить цвет на черный.
        myNode.left.color = false;
        myNode.right.color = false;
    }

    return myNode;
}

void inorder(node node) {
    if (node != null) {
        inorder(node.left);
        char c = '●';
        if (node.color == false)
            c = '◯';
        System.out.print(node.data + ""+c+" ");
        inorder(node.right);
        }
    }  
public static void main(String[] args) {

    hm_3 node = new hm_3();
    Scanner scan = new Scanner(System.in);
    char ch;
    do {
        System.out.println("Введите целое число");

        int num = scan.nextInt();
        root = node.insert(root, num);

        node.inorder(root);
        System.out.println("\nВы хотите продолжить? (введите y или n)");
        ch = scan.next().charAt(0);
        } while (ch == 'Y' || ch == 'y');
    }
}