package node;

public class Node <E>{
	private E element;
	private Node<E> next;
	
	public E getElement(){
		return this.element;
		}
	public Node<E> getNext(){
		return this.next;
		}
	public Node(E el, Node<E> n){
		this.element = el;
		this.next = n;
		}
	public Node() {
		this.element = null;
		this.next = null;
	}
	public E setElement(E newEl){
		E tmp = this.element; 
		this.element = newEl; 
		return tmp;
		}
	public Node<E> setNext(Node<E> n){
		Node<E> tmp = this.next;
		this.next = n;
		return tmp; 
		} 
	
	}
