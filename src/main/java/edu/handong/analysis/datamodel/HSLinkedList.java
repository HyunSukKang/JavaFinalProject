package edu.handong.analysis.datamodel;

import java.util.ArrayList;

public class HSLinkedList<D> {
	private ListNode head;
	private ListNode tail;
	
	public HSLinkedList() {
		head = null;
	}
	
	public int length() {
		int count = 0;
		ListNode position = head;
		while(position != null) {
			count++;
			position = position.link;
		}
		return count;
	}
	
	public void insertNode(D addData) {
		if(length()==0) {
			tail=new ListNode(addData,null);
			head=tail;
		}else {
			tail.link = new ListNode(addData, null);
			tail = tail.link;
		}
	}
	
	public void deleteNode() {
		ListNode previous = getPreviousNode();
		
		tail = previous;
		previous.link = null;
		
	}
	
	private ListNode getPreviousNode() {
		ListNode current = head;
		ListNode previous = null;
		while(true) {
			if(current==tail)
				return previous;
			
			previous = current;
			current = current.link;
		}
	}
	
	public ArrayList<D> toArrayList() {
		ArrayList<D> list = new ArrayList<D>(length());
		ListNode position = head;
		while(position != null) {
			list.add(position.data);
			position = position.link;
		}
		return list;
	}
	
	private class ListNode{
		private D data;
		
		public D getData() {
			return data;
		}

		public ListNode getLink() {
			return link;
		}

		private ListNode link;
		
		public ListNode(D newData, ListNode linkedNode) {
			data = newData;
			link = linkedNode;
		}
	}
}