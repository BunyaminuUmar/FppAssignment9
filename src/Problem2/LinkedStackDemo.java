package Problem2;
class LinkedStack {
    class Node {
        Object data;
        Node next;

        Node(Object item) {
            data = item;
        }
    }

    Node head;
    int numberOfNodes;

    LinkedStack(){
        this.numberOfNodes = 0;
        head = new Node(0);
    }

    public void push(Object item) {
        addAtFirst(numberOfNodes, item);
    }

    public void addAtFirst(int index, Object item) {
        if(index < numberOfNodes) index = 0;
        if(index > numberOfNodes)return;
        Node pred = head;

        for(int i = 0; i < index; i ++){
            pred = pred.next;
        }
        Node addNode = new Node(item);
        addNode.next = pred.next;
        pred.next = addNode;
        numberOfNodes++;
    }
    public Object deleteAtFirst(int index){
        if(index < 0 || index > numberOfNodes){
            return null;
        }
        Node pred = head;
        for(int i = 0; i < index; i++){
            pred = pred.next;
        }
        Object item = pred.next.data;
        pred.next = pred.next.next;
        return item;
    }
    public Object pop() {
        numberOfNodes--;
        return deleteAtFirst(numberOfNodes );
    }
    public Object get(int index){
        if(index < 0 )return null;
        if(index > numberOfNodes)return null;
        Node pred = head;
        for(int i = 0; i < index; i++){
            pred = pred.next;
        }
        return pred.data;
    }

    public Object peek(){
        return get(numberOfNodes );
    }

    public static void main(String[] args) {
        LinkedStack stack = new LinkedStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop());
        System.out.println(stack.peek());
    }
}

