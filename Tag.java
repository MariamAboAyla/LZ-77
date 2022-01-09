// Arwa Hazem Mohamed khalil 20190663
//Mariam Khalid Sayed Abd El-Raouf 20190518
package com.company;
public class Tag {
     int pos,len;
     char next;
     public Tag(){}
    public Tag(int pos ,int len,char next){
        this.len = len;
        this.next = next;
        this.pos = pos;
    }
    public void setval(int pos,int len,char next){
        this.len = len;
        this.next = next;
        this.pos = pos;
    }

    public int getLen() {
        return len;
    }

    public int getPos() {
        return pos;
    }

    public char getNext() {
        return next;
    }

    public void display(){
        System.out.println(pos+" , "+len+" , "+next);
    }
}
