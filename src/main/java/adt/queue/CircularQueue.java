package adt.queue;

public class CircularQueue<T> implements Queue<T> {

	private T[] array;
	private int tail;
	private int head;
	private int elements;

	public CircularQueue(int size) {
		array = (T[]) new Object[size];
		head = -1;
		tail = -1;
		elements = 0;
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if (isFull()) {
			throw new QueueOverflowException();
		} else if (!element.equals(null)) {
			tail = (tail + 1) % array.length;
			if (head == -1) {
				head = 0;
			} 
			array[tail] = element;
			elements ++;
		}
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		T result = null;
		if (isEmpty()) {
			throw new QueueUnderflowException();
		} else {
			result = array[head];
			array[head] = null;
			head = (head + 1) % array.length;
			elements --;
			if (elements == 0) {
				head = -1;
				tail = -1;
			}
		}
		return result;
	}

	@Override
	public T head() {
		T result = null;
		if (!isEmpty()) {
			result = array[head];
		}
		return result;
	}

	@Override
	public boolean isEmpty() {
		return head == - 1;
	}

	@Override
	public boolean isFull() {
		return elements == array.length;
	}

}
