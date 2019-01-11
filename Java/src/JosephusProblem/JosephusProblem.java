/**
 * Created by tina on 2019/1/7.
 */
class Node {
    private int value;
    private Node next;

    Node(int value){
        this.value = value;
        this.next = null;
    }

    public void setNextNode(Node nextNode){
        this.next = nextNode;
    }

    public Node getNextNode(){
        return this.next;
    }

    public int getValue(){
        return this.value;
    }
}

class List {
    private Node head;

    List(int nodeNum){
        Node preNode;
        Node curNode;

        this.head = new Node(0);
        preNode = head;
        for (int i = 1; i < nodeNum; i++){
            curNode = new Node(i);
            preNode.setNextNode(curNode);
            preNode = curNode;
        }
        preNode.setNextNode(this.head);
    }

    public Node getListHead(){
        return this.head;
    }
}

public class JosephusProblem {
    public static void main(String []argvs){
        int nodeNum = Integer.parseInt(argvs[0]);
        int countNum = Integer.parseInt(argvs[1]);
        System.out.println("When node number is " + nodeNum + ", count number is " + countNum);
        System.out.println("The last number is " + Josephus(nodeNum, countNum));
        return;
    }

    public static int Josephus(int nodeNum, int countNum){
        if (countNum == 1){
            return nodeNum - 1;
        }

        List list = new List(nodeNum);
        Node head = list.getListHead();
        Node preNode = null;
        Node curNode = head;
        while(curNode.getNextNode() != curNode){
            for (int i = 1; i < countNum; i++) {
                preNode = curNode;
                curNode = curNode.getNextNode();
            }
            preNode.setNextNode(curNode.getNextNode());
            curNode.setNextNode(null);
            curNode = preNode.getNextNode();
        }
        return curNode.getValue();
    }
}
