package com.example.compression.Service;

import ch.qos.logback.core.pattern.color.BoldYellowCompositeConverter;
import com.example.compression.compact.HuffmanNode;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

@Service
public class compactService {

    private static final int BUFFER_Size=8192;

    public byte[] compress(byte[] data) throws IOException{
        if(data.length==0) return data;

        Map<Byte,Integer> frequencyMap=buildFrequencyMap(data);

        HuffmanNode root= buildHuffmanTree(frequencyMap);

        Map<Byte,String > huffmanCodes=generateCodes(root);

        String encodedData =encodeData(data,huffmanCodes);

        return createCompressedOutput(encodedData,huffmanCodes);
    }



    private Map<Byte, String> generateCodes(HuffmanNode root) {
        Map<Byte,String> code=new HashMap<>();
        recursionGentration(root,"",code);
        return code;
    }

    private void recursionGentration(HuffmanNode root, String code, Map<Byte, String> codes) {
        if(root==null) return;
        if(root.isLeaf()){
            codes.put(root.getData(),code.isEmpty() ? "0":code);

        }
        recursionGentration(root.left,code+"0",codes);
        recursionGentration(root.right,code+"1",codes);
    }

    private HuffmanNode buildHuffmanTree(Map<Byte, Integer> frequencyMap) {
        PriorityQueue<HuffmanNode> pq=new PriorityQueue<>();

        for(Map.Entry<Byte,Integer> entry : frequencyMap.entrySet()){
            pq.offer(new HuffmanNode(entry.getKey(),entry.getValue()));
        }

        while(pq.size()>1){
            HuffmanNode left=pq.poll();
            HuffmanNode right=pq.poll();
            HuffmanNode parent =new HuffmanNode((byte)0, left.getFrequency()+right.getFrequency(),
                    left,right);
            pq.offer(parent);
        }

        return pq.poll();
    }




    private Map<Byte, Integer> buildFrequencyMap(byte[] data) {
        Map<Byte,Integer> frequencyMap=new HashMap<>();
        for(byte b: data){
            frequencyMap.put(b,frequencyMap.getOrDefault(b,0)+1);
        }

        return frequencyMap;
    }
}
