import com.sun.deploy.util.ArrayUtil;
import com.sun.xml.internal.ws.policy.EffectiveAlternativeSelector;

import java.util.Arrays;

public class MutableStringArray {
    int i;
    String[] string=new String[i];

    public void test(){
        int a=getLength();
        System.out.println("The length is "+a);
        for (int j = 0; j <i ; j++) {
            System.out.print(string[j]);
        }
        System.out.println("");
    }

    //在这个动态数组的末尾添加一个元素，返回值为Boolean变量。表示是否添加成功
    public boolean add(String s){
        boolean a=false;
        i=i+1;
        string= Arrays.copyOf(string,i);
        string[i-1]=s;
        if(string[i-1].compareTo(s)==0){
            a=true;
        }
        return a;
    }

    // 将这个String数组中的所有元素添加到这个动态数组的末尾
    public void add(String[] s){
        int k=s.length;
        for (int j = 0; j <k ; j++) {
            add(s[j]);
        }
    }

    //在这个动态数组下标为index的位置添加s，返回值为Boolean变量，表示是否添加成功
    public boolean addAt(String s,int index){
        boolean a =false;
        i=i+1;
        string=Arrays.copyOf(string,i);
        //数据后移
        for (int j = i-1; j >index ; j--) {
            string[j]=string[j-1];
        }
        //添加到指定位置
        string[index]=s;
        if(getLength()==i){
            a=true;
        }
        return a;
    }

    //删除这个动态数组的最后一个元素，返回值为Boolean变量，表示是否删除成功
    public  boolean deleteLast(){
        boolean a=false;
        string[i-1]=null;
        i--;
        string=Arrays.copyOf(string,i);
        if(getLength()==i){
            a=true;
        }
        return a;
    }

    //删除这个动态数组下标为index的元素，返回值为boolean变量，表示是否删除成功
    public boolean deleteAt(int index){
        //数据前移
        for (int j = index; j <i-1 ; j++) {
            string[j]=string[j+1];
        }
        //删除最后一个元素
        return deleteLast();
    }

    //清空删除整个动态数组，返回值为……
    public boolean clear(){
        boolean a= false;
        for (int j = 0; j <i ; j++) {
            string[j]=null;
        }
        i=0;
        string=Arrays.copyOf(string,i);
        if(getLength()==0){
           a=true;
        }
        return a;
    }

    //将这个动态数组下标为index的元素值改为s
    public void changeAt(String s,int index){
        string[index]=s;
    }

    //返回这个动态数组下标为index的元素
    public String get(int index){
        String a=string[index];
        return a;
    }

    //检查这个动态数组中是否包含s,返回Boolean
    public boolean contains(String s){
        boolean a=false;
        for (int j = 0; j <i; j++) {
            if(string[j].compareTo(s)==0){
                a=true;
                break;
            }
        }
        return a;
    }

    //返回目前该动态数组的长度，长度数值的类型为int
    public int getLength(){
        int a=0;
        a=string.length;
        return a;
    }
}
