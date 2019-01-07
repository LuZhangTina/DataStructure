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
    private Node preNode;
    private Node curNode;

    List(int nodeNum){
        this.head = new Node(0);
        this.head.setNextNode(this.head);
        this.preNode = this.head;
        for (int i = 1; i < nodeNum; i++){
            this.curNode = new Node(i);
            this.curNode.setNextNode(this.head);
            this.preNode.setNextNode(this.curNode);
            this.preNode = this.curNode;
        }
        this.preNode = this.head;
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
