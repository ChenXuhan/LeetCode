package easy;

import java.util.ArrayList;
import java.util.List;
import easy.ListNode;

public class NC03_ListNodeToArrayList {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> array = new ArrayList<Integer>();
        if(listNode==null){
            return array;
        }
        ListNode phead = listNode;
        while(phead!=null){
            array.add(phead.val);
            phead = phead.next;
        }
        return array;
    }
}
