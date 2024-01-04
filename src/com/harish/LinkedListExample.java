package com.harish;

public class LinkedListExample {

	Node head;
	int index;

	class Node{
		Object data;
		Node next;
		int index;
		Node(Object node,int index){
			this.data=node;
			this.index=index;
		}
	}
	
	public void insert(Object obj) {
		Node node=new Node(obj,index);
		if(head==null) {
			head=node;
		}else {
			Node temp=head;
			while(temp.next!=null) {
				temp=temp.next;
			}
			temp.next=node;
			index++;
		}
	}
	
	public void insertNodeAtStart(Object obj) {
		Node node=new Node(obj,index);
		if(head==null) {
			head=node;
		}else {
			//Node temp=head;
			node.next=head;
			head=node;
		}
		index++;
	}
	
	public void insertNodeAtMiddle(Object obj,Object afterNode) {
		Node node=new Node(obj,index);
		if(head!=null) {
			Node temp=head;
			while(temp.next!=null) {
				if(temp.data.equals(afterNode)) {
					Node nextaddress=temp.next;
					temp.next=node;
					node.next=nextaddress;
					break;
				}else {
					temp=temp.next;
				}
				index++;
			}	
		}	
	}
	
	public void insertNodeAtEnd(Object obj) {
		Node node=new Node(obj,index);
		if(head==null) {
			head=node;
		}else {
			Node temp=head;
			while(temp.next!=null) {
				temp=temp.next;
			}
			temp.next=node;
			index++;
		}
	}
	
	public void removeNode(Object obj) {
		Node node=new Node(obj,index);
		Node previous = null;
		if(head!=null) {
			Node temp=head;
			while(temp.next!=null) {
				if(temp.data.equals(obj)) {
					Node nextaddress=temp.next;
					previous.next=nextaddress;
					temp.next=null;
					break;
				}
				temp=temp.next;
			}
		}
	}
	
	public Object get(int indextobePassed) {
		if(head!=null) {
			Node temp=head;
			while(temp.next!=null) {
				if(temp.index==indextobePassed) {
					return temp.data;
				}else {
					temp=temp.next;
				}
			}
			if(temp.index==indextobePassed) {
				return temp.data;
			}
			
		}
		return null;
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("[");
		if(head==null) {
			sb.toString().concat(" ]");
		}else {
			Node temp=head;
			while(temp.next!=null) {
				sb.append(temp.data+",");
				temp=temp.next;
			}
			sb.append(temp.data);
		}
		return sb.toString().concat("]");
	}
	
	public Object returnFirstElement() {
		if(head==null) {
			return null;
		}else {
			return head.data;
		}
	}
	
	/*
	 * public Object returnLastElement() {
	 * 
	 * Node temp=head; }
	 */
	
	//remove and return the first element in the list
	public Object removeAndReturnFirstElement() {
		if(head!=null) {
			Node temp=head;
			if(temp.next!=null) {
				Node nextAddress=temp.next;
				Object removingElement=temp.data;
				head=nextAddress;
				index--;
				return removingElement;
			}
		}
		return null;
	}
	
	public boolean contains(Object obj) {
		if(head!=null) {
			Node temp=head;
			if(temp.data.equals(obj)) {
				return true;
			}
			while(temp.next!=null) {
				if(temp.data.equals(obj)) {
					return true;
				}else {
					temp=temp.next;
				}
			}
			if(temp.data.equals(obj)) {
				return true;
			}
		}
		return false;
	}
	
	public int size() {
		return index;
	}
	
	public static void main(String[] args) {
		LinkedListExample list = new LinkedListExample();
		list.insert(10);
		list.insert(20);
		list.insert(30);
		list.insert(40);
		list.insertNodeAtStart(5);
		list.insertNodeAtStart(2);
		list.insertNodeAtMiddle(11,10);
		list.insertNodeAtEnd(100);
		list.insertNodeAtEnd(200);
		//list.removeNode(20);
//		System.out.println(list.get(5));
//		System.out.println(list.index);
    	System.out.println(list);
		
		System.out.println(list.returnFirstElement());
		System.out.println(list.removeAndReturnFirstElement());
		System.out.println(list);
		System.out.println("contains : "+list.contains(100));
		System.out.print(list.size());
	}
}
