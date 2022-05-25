public class StackImplementation {
    public static void main(String[] args) {
        ArrayStack s = new ArrayStack();
        s.push(10);
        s.push(20);
        s.push(30);
        System.out.println(s.pop() + " Pooped from stack");
        System.out.println("Top element is " + s.peek());
        System.out.print("Elemenets present in stack");
        s.print();

    }
}
