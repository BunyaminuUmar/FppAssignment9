package Problem1;



public class ArrayQueueImpl {
	private int[] arr = new int[10];
	private int size = 0;
	private int front = -1;
	private int rear = 0;

	public boolean isEmpty() {
		return size == 0;
	}
	public int size(){
		return size;
	}
	public void enqueue(int value){
		if (size== arr.length){
			resizeArray();
		}
		arr[rear] = value;
		rear = (rear + 1) % arr.length;
		if (front == -1){
			front = 0;
		}
		size++;
	}
	public int dequeue(){
		if (isEmpty()){
			throw new IllegalStateException("Queue is Empty!");
		}
		int dequeueValue = arr[front];
		front = (front +1) % arr.length;
		size--;
		if (isEmpty()){
			front = -1;
			rear = 0;
		}
		return dequeueValue;
	}
	public int peek(){
		if (isEmpty()){
			throw new IllegalStateException("Queue is Empty!");
		}
		return arr[front];
	}
	private void resizeArray() {
		int newSize = arr.length * 2;
		int[] newArray = new int[newSize];
		for (int i = 0; i < size; i++) {
			newArray[i] = arr[(front + i) % arr.length];
		}
		front = 0;
		rear = size;
		arr = newArray;
	}

	public static void main(String[] args) {
		ArrayQueueImpl q = new ArrayQueueImpl();
		q.enqueue(5);
		q.enqueue(6);
		q.enqueue(7);
		q.enqueue(8);
		System.out.println(q.peek());
		System.out.println(q.size());
		for(int i = 0; i < 15; i++)
			q.enqueue(i);
		for(int i = 0; i < 14; i++)
			q.dequeue();
		System.out.println(q.size());
		System.out.println(q.peek());
	}
}

