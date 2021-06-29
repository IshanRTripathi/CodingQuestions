package main.java.otherCodingQuestions;

import main.java.customClass.ListNode;

public class ReverseLinkedListInPlace {
    public static void main(String[] args) {
        ListNode head= new ListNode(1
                , new ListNode(2
                , new ListNode(3
                , new ListNode(4
                , new ListNode(5
        )))));
        ListNode ans= new ReverseLinkedListInPlace().reverseList(head);
        while(ans!=null){
//            System.out.println(ans.val);
            ans=ans.next;
        }
    }

    ListNode h= new ListNode();
    ListNode t= h;
    private ListNode reverseList(ListNode head) {
//        reverseListHelper1(head);
//        return h.next;

        return reverseListHelper2(head);
    }

    private ListNode reverseListHelper2(ListNode head) {
        if(head==null || head.next==null)
            return head;

        ListNode temp= reverseListHelper2(head.next);
        System.out.println(temp.val);
        System.out.println(head.val);
        head.next.next=head;
        head.next= null;
        return temp;
    }

    void reverseListHelper1(ListNode head){
        if(head==null){
            return;
        }
        reverseListHelper1(head.next);
        head.next=null;
        t.next= head;
        t=t.next;
    }
}
