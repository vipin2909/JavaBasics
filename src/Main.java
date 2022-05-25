import java.util.*;
class Node {
    int data;
    Node next;
    Node() {
    }
    Node(int data) {
        this.data = data;
    }
    Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
}
public class Main {
    public Node newNode(int key) {
        Node node = new Node(key, null);
        return node;
    }
    public void printList(Node node) {
        Node ptr = node;
        while(ptr != null) {
            System.out.print(ptr.data + " ->");
            ptr = ptr.next;
        }
        System.out.println("null");
    }
    public Node appendNode(Node node, int key) {
        Node current = node;
        Node newNode = newNode(key);
        if(current == null) {
            node = newNode;
        }
        else {
            while(current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        return node;
    }

    Node mergeKNodes(Node[] lists) {
//        if(lists.length == 0 || lists == null) {
//            return null;
//        }
//        Node dummyNode = new Node(0);
//        Node p = dummyNode;
//
//        PriorityQueue<Node> pq = new PriorityQueue<>(lists.length, (a, b) -> (a.data - b.data));
//        for(Node list: lists) {
//            if(list != null) {
//                pq.add(list);
//            }
//        }
//
//        while(!pq.isEmpty()) {
//            Node node = pq.poll();
//            p.next = node;
//            if(node.next != null) {
//                pq.add(node.next);
//            }
//            p = p.next;
//        }
//        return dummyNode.next;
        if(lists.length == 0) {
            return null;
        }
        if(lists.length == 1) {
            return lists[0];
        }
        int j = 1;
        int length = lists.length;
        while(length > 1) {
            for(int i = 0; i < length/2; i++) {
                lists[i] = merge2Lists(lists[i], lists[length-i-1]);
            }
            length = (length+1)/2;
        }
        return lists[0];
    }
    Node removeNthFromEnd(Node node, int n) {
        Node start = new Node();
        start.next = node;
        Node slo = start;
        Node fast = start;

        for(int i = 0; i < n; i++) {
            fast = fast.next;
        }
        return start.next;
    }
    Node merge2Lists(Node l1, Node l2) {
        Node dummy = new Node(0);
        Node prev = dummy;
        while(l1 != null && l2 != null) {
            if(l1.data < l2.data) {
                dummy.next = l1;
                l1 = l1.next;
            }
            else {
                dummy.next = l2;
                l2 = l2.next;
            }
            dummy = dummy.next;

        }
        if(l1 == null) {
            dummy.next = l2;
        }
        else if(l2 == null) {
            dummy.next = l1;
        }
        return prev.next;
    }

    public void swapNodes(int x, int y, Node head) {
        if(x == y) {
            return;
        }
        Node prevX = null, currX = head;
        while(currX != null && currX.data != x) {
            prevX = currX;
            currX = currX.next;
        }
        Node prevY = null, currY = head;
        while(currY != null && currY.data != y) {
            prevY = currY;
            currY = currY.next;
        }

        if(currX == null || currY == null ) {
            return;
        }
        if(prevX != null) {
            prevX.next = currY;
            System.out.print("--prev-x--    ");
            printList(head);
        }
        else {
            head = currY;
            System.out.print("--prev-x head position--    ");
            printList(head);
        }
        if(prevY != null) {

            prevY.next = currX;
            System.out.print("--prev-y--    ");
            printList(head);
        }
        else {
            head = currX;
            System.out.print("--prev-y-position--    ");
            printList(head);
        }
        Node temp = currX.next;
        System.out.print("--after temp node--    ");
        printList(head);
        currX.next = currY.next;
        System.out.print("--after-current-x---    ");
        printList(head);
        currY.next = temp;
        System.out.print("--after curr-x && curr-y---    " );
        printList(head);

    }
    public void swapPairs(Node head) {
        if(head == null || head.next == null) {
            return;
        }
        Node dummy = new Node(0);
        dummy.next = head;
        Node last_node = dummy;
        printList(last_node);
        while(head != null && head.next != null) {
            Node temp = head.next.next;
            head.next.next = last_node.next;
            last_node.next = head.next;
            head.next = temp;
            last_node = head;
            head = head.next;

        }
    }
    Node reverse(Node head, int k) {
        if(head == null) {
            return null;
        }
        if(head.next == null) {
            return head;
        }
        Node curr = head;
        Node next = null;
        Node prev = null;
        int count = 0;
        while(count < k && curr != null ) {
            next = curr.next;
            System.out.print("next vaulue-- ");
                    printList(next);
            curr.next = prev;
            prev = curr;
            curr = next;
          count++;
        }
        printList(head);
        if(next != null) {
            head.next = reverse(next, k);
            System.out.print("This is inside if statement--  ");
            printList(head);
        }

        return prev;

    }
    Node reverseSubset(Node head, int left, int right) {
        if(head == null || left == right || right == 1) {
            return head;
        }
        Node dummy1 = new Node(0);
        Node dummy = dummy1;
        Node curr = head;
        Node cu = null;
        if(left == 1) {
            head = reverseList(head, right-left);
        }
        else {
            int count = 0;
            System.out.print("This is the value of current node in reverseSubarray-> ");
            printList(curr.next);
            while(count < left - 1 && curr != null) {
                dummy.next = new Node(curr.data);
                curr = curr.next;
                count += 1;
                dummy = dummy.next;
            }
            System.out.print("This is the value of current after first while loop for left == 2 ");
            printList(dummy1);
             cu = dummy1;
            while(cu.next != null) {
                cu = cu.next;
            }
            cu.next = reverseList(curr, right-left);
            System.out.println("This is value of dummy1 Node ---- ");
            printList(dummy1);

        }
        return dummy1.next;
    }
    public boolean isPalindrome(Node head) {
        Node dummy = head;
        Node curr = head;
        Node rev = reverseLinkedList(head);
        System.out.println("This is the value of reverse linked list -- ");
        printList(rev);
        while(curr != null && curr.data == rev.data) {
            curr = curr.next;
            rev = rev.next;
        }
        if(curr == null && rev == null) {
            return true;
        }
        return false;
    }
    Node reverseLinkedList(Node head) {
        Node curr = head;
        Node next = null, prev = null;
        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    Node reverseList(Node head, int n) {
        Node curr = head;
        Node next = null;
        Node prev = null;
        int count = 0;
        while(count <= n && curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count+=1;
        }
        Node tempPrev = prev;
        System.out.print("This is the value of tempPrev -> ");
        printList(tempPrev);
        while(tempPrev.next != null) {
            tempPrev = tempPrev.next;
        }
        System.out.print("This is value of current -> ");
        printList(curr);
        tempPrev.next = curr;
        return prev;
    }

    Node rotateList(Node head, int k) {
        Node dummy = new Node(0);
        Node curr = dummy;
        int count = 0;
        Node temp = head;
        while(temp != null) {
            temp = temp.next;
//            curr = curr.next;
            count++;
        }
        k %= count;
        Node cu = head;
        System.out.print("this is value of cu -- ");
        printList(cu);
        int i = 0;
        while(i < count - k && cu != null) {
            curr.next = new Node(cu.data);
            cu = cu.next;
            curr = curr.next;
            i+=1;
        }

        Node an = cu;
//        an.next = dummy.next;
        System.out.print("This is value of an -- ");
        Node t = an;
        while(t.next != null) {
            t = t.next;
        }
        t.next = dummy.next;
        printList(an);
//        an.next = curr;
        return an;

    }

    public Node getInsertionNode(Node headA, Node headB) {
        int count1 = 0;
        int count2 = 0;
        Node A = headA;
        Node B = headB;
        while(headA != null) {
            count1++;
            headA = headA.next;
        }
        while(headB != null) {
            count2++;
            headB = headB.next;
        }
        if(count1>count2)
        {
            while(count1-count2!=0)
            {
                count1--;
                A=A.next;
            }
            while(A!=B)
            {
                A=A.next;
                B=B.next;
            }
            return A;
        }
        else
        {
            while(count2-count1!=0)
            {
                count2--;
                B=B.next;
                //System.out.println(B.val);
            }
            while(A!=B)
            {
                A=A.next;
                B=B.next;
            }
            return B;

        }
    }

//    Node isPalindromeUsingStack(Node head) {
//        Node slow = head;
//        boolean isPalin = true;
//        Stack<Integer> stack = new Stack<>();
//        while(slow != null) {
//            stack.push(slow.data);
//            slow = slow.next;
//        }
//        while(head != null) {
//            int i = stack.pop();
//            if(head.data == i) {
//                isPalin = true;
//            }
//            else {
//                isPalin = false;
//                break;
//            }
//            head = head.next;
//        }
//        return isPalin;
//    }


    public static void main(String[] args) {
        int[][] keys = {{1, 2, 3, 4, 5}, {2, 3, 4, 5, 6}, {3, 4, 5, 6, 7}, {4, 5, 6, 7, 8}, {5, 6, 7, 8, 9}};
        Node[] lists = new Node[keys.length];
        int p = 0;
        Main obj = new Main();
        for (int[] key : keys) {
            Node head = null;
            for (int k : key) {
                head = obj.appendNode(head, k);
            }
            lists[p++] = head;
        }
//        Node ans = obj.mergeKNodes(lists);
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        Node an = null;
//        int k = sc.nextInt();
        int k = 9;
        for(int key: array) {
            an = obj.appendNode(an, key);
        }
        obj.printList(an);
//        obj.swapNodes(10, 20, an);
//        obj.swapPairs(an);
//        Node mainList =         obj.reverse(an, k);
//        obj.printList(mainList);
//        Node mainList = obj.reverseSubset(an, 3, 10);
//        System.out.println("This is mainList --> ");
//        obj.printList(mainList);
          Node ans = obj.rotateList(an, k);
          System.out.print("The value of final ans is -- ");
          obj.printList(ans);
//        System.out.println("The linked list palindrome: " + obj.isPalindrome(an));
    }
    void reverseArray(int arr[],
                             int start, int end)
    {
        int temp;

        while (start < end)
        {
            temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

}

