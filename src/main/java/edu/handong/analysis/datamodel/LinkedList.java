package edu.handong.analysis.datamodel;

public class LinkedList {
private ListNode head;
	
	public LinkedList() {
		head = null;
	}

	public void showList() {
		ListNode position = head;
		while(position != null) {
			System.out.println(position.getData());
			position = position.getLink();
		}
	}
	
	public int length() {
		int count = 0;
		ListNode position = head;
		while(position != null) {
			count++;
			position = position.getLink();
		}
		return count;
	}
	
	public void addANodeToStart(ExcelType2 addData) {
		head = new ListNode(addData, head);
	}
	
	public void deleteHeadNode() {
		if(head != null)
			head = head.getLink();
		else {
			System.out.println("Deleting from an empty list.");
			System.exit(0);
		}
	}
	
	public boolean onList(ExcelType2 target) {
		return find(target) != null;
	}
	
	private ListNode find(ExcelType2 target) {
		boolean found = false;
		ListNode position = head;
		while((position != null) && !found) {
			ExcelType2 dataAtPosition = position.getData();
			if(dataAtPosition.equals(target))
				found = true;
			else
				position = position.getLink();
		}
		return position;
	}
}
