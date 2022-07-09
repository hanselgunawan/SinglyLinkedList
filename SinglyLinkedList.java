class SinglyLinkedList {

    static class ListNode {
        int item;
        ListNode next;
        ListNode(int item) {
            this.item = item;
        }
    }

    static class MyLinkedList {
        ListNode head;
        int size = 0;

        public void insert(int item) {
            ListNode node = new ListNode(item);

            if (head == null) {
                head = node;
            } else {
                ListNode curr;
                curr = head;
                while (curr.next != null) {
                    curr = curr.next;
                }
                curr.next = node;
            }

            size++;
        }

        public void show() {
            ListNode iterator;
            iterator = head;

            while (iterator != null) {
                System.out.print(iterator.item + " ");
                iterator = iterator.next;
            }
        }

        public int size() {
            return size;
        }

        public boolean isEmpty() {
            return head == null;
        }

        public int valueAt(int index) {
            if (index > size) return -1;
            if (index == 1) return head.item;

            ListNode curr;
            curr = head;
            while (index > 1) {
                curr = curr.next;
                index--;
            }

            return curr.item;
        }

        public void pushFront(int item) {
            ListNode node = new ListNode(item);
            node.next = head;
            head = node;
            size++;
        }

        public void popFront() {
            ListNode curr = head;
            curr = curr.next;
            head.next = null;
            head = curr;
            size--;
        }

        public void pushBack(int item) {
            ListNode node = new ListNode(item);
            if (size == 1) {
                head.next = node;
            }
            ListNode curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }

            curr.next = node;
            size++;
        }

        public void popBack() {
            ListNode curr = head;

            while (curr.next.next != null) {
                curr = curr.next;
            }

            curr.next = null;
            size--;
        }

        public int front() {
            return head.item;
        }

        public int back() {
            ListNode curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            return curr.item;
        }

        public void reverse() {
            if (head == null) return;

            ListNode sentinel = new ListNode(0);
            ListNode curr;
            ListNode prev;

            curr = head;
            prev = head;

            curr = curr.next;
            head.next = sentinel;

            while (curr != null) {
                sentinel.next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = sentinel.next;
            }

            head.next = null;
            head = prev;
        }

        public void insertAt(int index, int item) throws Exception {
            if (index > size) {
                throw new Exception("Index is greater than size!");
            }

            ListNode node = new ListNode(item);

            if (index == 1) {
                pushFront(item);
            } else if (index == size) {
                pushBack(item);
            } else {
                ListNode curr = head;
                ListNode prev = head;
                while (index > 1) {
                    prev = curr;
                    curr = curr.next;
                    index--;
                }
                node.next = curr;
                prev.next = node;
                size++;
            }
        }

        public void erase(int index) throws Exception{
            if (index > size) {
                throw new Exception("Index is greater than size!");
            }

            if (index == 1) {
                popFront();
            } else if (index == size) {
                popBack();
            } else {
                ListNode curr = head;
                index--;
                while (index > 1) {
                    curr = curr.next;
                    index--;
                }
                curr.next = curr.next.next;
                size--;
            }
        }

        public int valueNfromEnd(int positionFromEnd) {
            if (positionFromEnd > size) return -1;
            if (positionFromEnd == size) return head.item;

            ListNode curr = head;
            int indexFromEnd = size - (positionFromEnd-1);

            for (int i = 1; i < indexFromEnd; i++) {
                curr = curr.next;
            }

            return curr.item;
        }

        public void removeFirstValueOf(int itemRemoved) {
            ListNode curr = head;

            if (head.item == itemRemoved) {
                popFront();
            } else {
                while (curr != null) {
                    if (curr.next.item == itemRemoved) {
                        curr.next = curr.next.next;
                        break;
                    }
                    curr = curr.next;
                }
            }

            size--;
        }
    }

    public static void main(String[] args) throws Exception {
        MyLinkedList myLinkedList = new MyLinkedList();

        myLinkedList.insert(1);
        myLinkedList.insert(2);
        myLinkedList.insert(3);
        myLinkedList.show();

        System.out.println("");

        // Size
        System.out.println("SIZE: " + myLinkedList.size());

        // isEmpty
        System.out.println("isEmpty: " + myLinkedList.isEmpty());

        // valueAt
        System.out.println("VALUE AT 1: " + myLinkedList.valueAt(1));
        System.out.println("VALUE AT 2: " + myLinkedList.valueAt(2));
        System.out.println("VALUE AT 3: " + myLinkedList.valueAt(3));
        System.out.println("VALUE AT 4: " + myLinkedList.valueAt(4));

        // push front
        System.out.print("PUSH FRONT: ");
        myLinkedList.pushFront(4);
        myLinkedList.show();
        System.out.println("");

        // pop front
        System.out.print("POP FRONT: ");
        myLinkedList.popFront();
        myLinkedList.show();
        System.out.println("");

        // push back
        System.out.print("PUSH BACK: ");
        myLinkedList.pushBack(5);
        myLinkedList.show();
        System.out.println("");

        // pop back
        System.out.print("POP BACK: ");
        myLinkedList.popBack();
        myLinkedList.show();
        System.out.println("");

        // front
        System.out.println("FRONT: " + myLinkedList.front());

        // back
        System.out.println("BACK: " + myLinkedList.back());

        // reverse
        System.out.print("REVERSE LINKED LIST: ");
        myLinkedList.reverse();
        myLinkedList.show();
        System.out.println("");

        // insert at
        System.out.print("INSERT 5 at INDEX 1: ");
        myLinkedList.insertAt(1, 5);
        myLinkedList.show();
        System.out.println("");

        System.out.print("INSERT 6 at INDEX 3: ");
        myLinkedList.insertAt(3, 6);
        myLinkedList.show();
        System.out.println("");

        // erase
        System.out.print("ERASE 6 at INDEX 3: ");
        myLinkedList.erase(3);
        myLinkedList.show();
        System.out.println("");

        System.out.print("ERASE 1 at INDEX 4: ");
        myLinkedList.erase(4);
        myLinkedList.show();
        System.out.println("");

        // value from end
        System.out.print("VALUE AT POSITION 2 FROM END: ");
        System.out.println(myLinkedList.valueNfromEnd(2));

        myLinkedList.pushFront(5);
        myLinkedList.insertAt(2, 9);
        myLinkedList.insertAt(3, 9);

        myLinkedList.show();
        System.out.println("");

        // remove first value of
        System.out.print("REMOVE FIRST VALUE OF 9: ");
        myLinkedList.removeFirstValueOf(9);
        myLinkedList.show();
        System.out.println("");

        System.out.print("REMOVE FIRST VALUE OF 3: ");
        myLinkedList.removeFirstValueOf(3);
        myLinkedList.show();
        System.out.println("");

    }
}
