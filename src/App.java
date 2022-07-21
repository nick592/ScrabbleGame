public class App {
    public static void main(String[] args) throws Exception {

        Letter A = new Letter('A', 3);
        Letter B = new Letter('B', 7);
        Letter C = new Letter('C', 2);

        Hand myHand = new Hand();

        myHand.insert(A, 0);
        myHand.insert(B, 1);
        myHand.insert(C, 2);

        System.out.println(myHand);
        System.out.println(myHand.indexOf('A'));
        System.out.println(myHand.indexOf('Z'));
    
    }
}
