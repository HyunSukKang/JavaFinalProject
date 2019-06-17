package edu.handong.analysis.datamodel;

public class ListNode {
	private String data;
    private ListNode link;

    public ListNode() {
    	data = null;
        link = null;     
    }

    public ListNode(String newData, ListNode linkNode) {
        data = newData;
        link = linkNode;
    }
    
    public void setData(String newData) {
        data = newData;
    }

    public String getData() {
        return data;
    }

    public void setLink(ListNode newLink) {
        link = newLink;
    }

    public ListNode getLink() {
        return link;
    }
    
}
