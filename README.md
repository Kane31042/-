红岩网校移动开发部Android 第1次作业-Lv.5-钱可欣-2019210107
====
作业：实现一个动态数组，并上传至GitHub\
具体要求：\
1.类名为MutableStringArray\
2.需要实现增删改查方法\
3.使用Markdown语法\
作业过程：\
其实一开始写的时候我以为害挺简单的，结果跑的时候疯狂报错，原因就是在开始的时候写了一个这个：
```
 int i;
 String[] string;
```
hin显然这个是错的,我天真地以为这样就阔以改变数组长度了，结果当然是不行的（而且实际上还有其他问题（当然别人肯定一下就看出来了），不过还是太天真的我到后来才发现，所以后面再说）。\
所以就得想别的办法，之后就是漫长的试错过程\
这个问题的关键就在于要解决数组的长度是固定的问题，为了解决这个，我想到可以重新建立一个数组，然后把旧的数组和新的数组都放到一起（当时只是考虑加的问题，本来寻思加法解决了减法应该也差不多，不过到后来加法问题也没解决hhh）。\
这样的话数组的长度问题就可以解决了，因为我在最开始定义的一个i，然后在每一个会改变数组长度的方法里对i进行了增加或减少的赋值，然后在方法里定义一个新的数组，长度为i，比如这样(只是举例，因为最后没这么用)：
```
i=i+1;
String[] newString=new String[i];
```
新的问题来了：长度解决了，新的数组有了，旧的数组该怎么办？

FBIWARNING：\
请看到以下内容的带佬们不要打我
---
我想到写一个saveOldString(不要在意为什么不是set，我觉得这样比较直观hhh）和一个getOldString的方法来存储和读取之前的数组，然而发现实现起来非常困难，因为要在合成新的数组之后调用saveOldString把数组存储起来然后要用的时候再用get来获取，一开始是这么写的(我才发现我这里居然用的是set):
```
    public void setOldString(String[] oldString){
        oldString=this.oldString;
    }
    public String[] getOldString(){
        return oldString;
    }
```
这就是getset方法，然后这样一来的话还是要写一个String[] oldString（又错了）;我寻思这样行不通，然后想到在增删的方法里调用saveOldString(String[] oldString)把新数组存储起来（变为旧数组），要用的时候再调用getOldString把它拿出来。听上去十分美好，但实际上写的时候根本行不通（原代码被删了，我不想再回忆痛苦往事了），为此我还又写了一个PutStringTogether和SaveOldString的类试图实现这样的功能，结果当然还是不行der，毕竟实际上原理还是一个样，这个代码还留在文件里，因为看上去排版谜之好看hhh，而且也写了也不太想删（以后说不定会成为黑历史），虽然没用但也还是留着了。\
反正就在这里卡了两天，后来我发现用Arrays这个类就可以解决问题了！！！我之前在干什么啊Kora！\
具体实现是这样的(只是举例）：
```
String[] string=new String[1];
string=Arrays.copyOf(string,2);
```
这样的话，本来长度只有1的数组就可以变成2了！感天动地！\
接下来就是开开心心改bug的过程，但后来跑的时候马上就出问题了：
```
Exception in thread "main" java.lang.NullPointerException
```
???\
前两天学长刚和我讲了空指针异常没多久就碰上了\
排查了一下，就发现了最开始的问题：
```
 String[] string;
```
我本来以为这个和int一样会默认长度为0，结果这玩意一开始必须得定义长度。害，基础不扎实活该报错\
后来就改成了：
```
 String[] string=new String[i];
```
问题就解决啦。\
写到这里我才发现我在这个地方纠缠了好久，作业要求的增删改查都还没讲，不过其实这个就是主要问题，解决了就好了，实际上方法不难，也没啥好写的\
不过还是想说两句hhh\
我在原有方法的基础上又写了一个test方法，在测试的时候用来直观显示结果：
```
    public void test(){
        int a=getLength();
        System.out.println("The length is "+a);//我加了一句输出更直观
        for (int j = 0; j <i ; j++) {
            System.out.print(string[j]);
        }
        System.out.println("");
    }
	//返回目前该动态数组的长度，长度数值的类型为int
    public int getLength(){
        int a=0;
        a=string.length;
        return a;
    }
```
在写增加一个数组的时候我直接调用了一开始写的增加一个元素的方法hhh，偷懒了
```
    // 将这个String数组中的所有元素添加到这个动态数组的末尾
    public void add(String[] s){
        int k=s.length;
        for (int j = 0; j <k ; j++) {
            add(s[j]);
        }
    }
```
deleteAt方法我也用了删除最后一个元素的方法，总之怎么偷懒怎么来（不是）\
~~小声bb：其实我不明白作业要求的返回Boolean干啥子用~~\
第一次尝试写这个，其实不知道该写啥，感觉就是记录黑历史啊喂，写这个好花时间嗷。\
最后把东西上传到Github发现好复杂……弄了好久\
如果有啥可以改进的请务必提出，感谢！
