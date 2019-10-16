public class PutStringTogether {
    int i;
    String[] string;
    String[] newString;
    String[] oldString;
    //设定一个数组
    public void setI(int i){
        this.i=i;
    }
    public int getI(){
        return i;
    }
    public String[] putString(){
        String[] string=new String[i];
        String[] oldString=getOldString();
        String[] newString=getNewString();
        System.arraycopy(oldString,0,string,0,oldString.length);
        System.arraycopy(string,oldString.length,newString,0,newString.length);
        return string;
    }
    public void setOldString(String[] oldString){
        oldString=this.oldString;
    }
    public String[] getOldString(){
        return oldString;
    }
    public void setNewString(String[] newString){
        newString=this.newString;
    }
    public String[] getNewString(){
        return newString;
    }



}
