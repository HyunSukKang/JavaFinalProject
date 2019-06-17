package edu.handong.analysis.datamodel;

public class ListNode {
	private ExcelType2 data;
    private ListNode link;

    public ListNode() {
    	data = null;
        link = null;     
    }

    public ListNode(ExcelType2 newData, ListNode linkNode) {
        data = newData;
        link = linkNode;
    }
    
    public void setData(ExcelType2 newData) {
        data = newData;
    }

    public ExcelType2 getData() {
        return data;
    }

    public void setLink(ListNode newLink) {
        link = newLink;
    }

    public ListNode getLink() {
        return link;
    }
    
}
