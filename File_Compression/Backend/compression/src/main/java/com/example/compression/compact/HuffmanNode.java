package com.example.compression.compact;

public class HuffmanNode implements Comparable<HuffmanNode>{
    byte data;
    int frequency;
    public HuffmanNode left,right;
    public HuffmanNode(byte data,int frequency){
        this.data=data;
        this.frequency=frequency;
        this.right=null;
        this.left=null;
    }
    public HuffmanNode(byte data,int frequency, HuffmanNode left,HuffmanNode right){
        this.data=data;
        this.frequency=frequency;
        this.right=right;
        this.left=left;
    }
    public int getFrequency(){
        return this.frequency;
    }
    public byte getData(){
        return this.data;
    }

    public boolean isLeaf(){
        return left==null && right==null;
    }

    @Override
    public int compareTo(HuffmanNode o) {
        return Integer.compare(this.frequency,o.frequency);
    }
}
