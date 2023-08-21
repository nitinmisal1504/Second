package com.prominent;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class QualtricsInputParser {
    ObjectMapper objectMapper = new ObjectMapper();
    public void process(File file, String fieldName) throws IOException {
        String fileContent = Files.readString(Paths.get(file.toURI()));
        JsonNode jsonNode = objectMapper.readTree(fileContent);
        ArrayNode arrayNode = (ArrayNode) jsonNode.get("responses");
        for(JsonNode node: arrayNode){
            String resId = node.get("responseId").asText();
            //String qid4_text=node.get("QID4_TEXT").asText();
//            JsonNode fieldNode = node.get("values").get(fieldName);
            JsonNode fieldNode = node.get("values");
            String value = fieldNode==null?null:fieldNode.asText();
            /*if(resId==null){
                System.out.println(file.getName()+","+resId+","+value.length());
            }*/
            if(value!=null){
                if(value.length()>0 || !isPureAscii(value)){
                //if(value.length()>1000){
                    System.out.println(file.getName()+","+resId+","+value.length());
                }
                System.out.println(fieldNode.size());
            }else{

                System.out.println("null");
            }
        }
    }
    public static boolean isPureAscii(String v) {
        return StandardCharsets.US_ASCII.newEncoder().canEncode(v);
        // or "ISO-8859-1" for ISO Latin 1
        // or StandardCharsets.US_ASCII with JDK1.7+
    }
}
