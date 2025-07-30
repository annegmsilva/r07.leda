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

	// FALTA TERMINAR ENQUEUE E DEQUEUE
	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if (isFull()) {
			throw new QueueOverflowException();
		} else if (!element.equals(null)) {
			if (elements - 1 == tail || elements - 1 == head) {
				tail = 0;
				head ++;
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
			elements --;
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
		return tail == array.length - 1;
	}

}
