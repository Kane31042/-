public class StringTest {
    public static void main(String[] args) {
        MutableStringArray string=new MutableStringArray();
        string.add("a");
        string.test();
        String[] s={"b","c","d"};
        string.add(s);
        string.deleteLast();
        string.test();
        string.addAt("m",2);
        string.test();
        string.changeAt("n",2);
        string.test();
        string.deleteAt(2);
        string.test();
        boolean a=false;
        a=string.contains("a");
        if(a){
            System.out.println("its true");
        }else {
            System.out.println("its false");
        }
        boolean b=false;
        a=string.contains("p");
        if(b){
            System.out.println("its true");
        }else {
            System.out.println("its false");
        }
        string.clear();
        string.test();
    }
}
