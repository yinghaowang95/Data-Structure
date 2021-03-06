package com.wyh.linkedlistStack;
/**
 * Interface Stack<E>   <------ ArrayStack<E>
 *ArrayStack<E>
 *void pust(E)		O(1)均摊
 *E pop()			O(1)均摊
 *E peck()			O(1)
 *int getSzie()		O(1)
 *boolean isEmpty()	O(1)
 **/
public class ArrayStack<E> implements Stack<E>{
	
	Array<E> array;
	public ArrayStack(int capacity) {
		array=new Array<>(capacity);
	}
	
	public ArrayStack() {
		array=new Array<>();
	}
	
	@Override
	public int getSize() {
		return array.getSize();
	}
	@Override
	public boolean isEmpty() {
		return array.isEmpty();
	}
	
	public int getCapacity() {
		return array.getCapacity();
	}
	@Override
	public void push(E e) {
		array.addLast(e);
	}
	@Override
	public E pop() {
		return array.removeLast();
	}
	@Override
	public E peck() {
		return array.getLast();
	}
	@Override
	public String toString() {
		StringBuilder res=new StringBuilder();
		res.append("Stack: ");
		res.append("[");
		for(int i=0;i<array.getSize();i++) {
			res.append(array.get(i));
			if(i!=array.getSize()-1) {
				res.append(",");
			}
		}
		res.append("] top");
		return res.toString();
	}
}
