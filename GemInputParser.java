package com.prominent;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class GemInputParser {
    ObjectMapper objectMapper = new ObjectMapper();
    public void process(File file, String fieldName) throws IOException {
            //String fileName = String.valueOf(file);
           // System.out.println("Filename="+fileName);
            try (FileReader fileReader = new FileReader(file)) {
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                String line = null;
                while ((line = bufferedReader.readLine()) != null) {
                    JsonNode jsonNode = objectMapper.readTree(line);
                    String id = jsonNode.get("Id").asText();
                    JsonNode fieldNode = jsonNode.get(fieldName);
                    String value = fieldNode == null ? null : jsonNode.get(fieldName).asText();

                    if (value != null) {
                        if (value.length() >7 || !isPureAscii(value)) {
                            System.out.println(file.getName() + "," + id + "," + value.length()+" " +value);
                        }
                    }
                    /*
                    ArrayNode arrayNode = (ArrayNode) jsonNode.get("responses");
                    for (JsonNode node : arrayNode) {
                        String resId = node.get("responseId").asText();
                        JsonNode fieldNode = node.get("values").get(fieldName);
                        String value = fieldNode == null ? null : fieldNode.asText();
                        if (value != null) {
                            if (value.length() >= 250 || !isPureAscii(value)) {
                                System.out.println(file.getName() + "," + resId + "," + value.length());
                            }
                        }
                    }*/

                }
                bufferedReader.close();
                fileReader.close();

        }catch (Exception e){
            System.out.println(e);
        }

    }


    public static boolean isPureAscii(String v) {
        return StandardCharsets.US_ASCII.newEncoder().canEncode(v);
        // or "ISO-8859-1" for ISO Latin 1
        // or StandardCharsets.US_ASCII with JDK1.7+
    }
    public void process(File file, String firstFieldName, int firstFieldLength, String secondFieldName, int secondFieldLength,String thirdFieldName, int thirdFieldLength)  throws IOException {
        //String fileName = String.valueOf(file);
        // System.out.println("Filename="+fileName);
        try (FileReader fileReader = new FileReader(file)) {
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                JsonNode jsonNode = objectMapper.readTree(line);
                String id = jsonNode.get("Id").asText();

                JsonNode firstFieldNode = jsonNode.get(firstFieldName);
                String value = firstFieldNode == null ? null : jsonNode.get(firstFieldName).asText();

                JsonNode secondFieldNode = jsonNode.get(secondFieldName);
                String secondValue = secondFieldNode == null ? null : jsonNode.get(secondFieldName).asText();

                JsonNode thirdFieldNode = jsonNode.get(secondFieldName);
                String thirdValue = thirdFieldNode == null ? null : jsonNode.get(thirdFieldName).asText();

                if (value != null) {
                    if (value.length() >firstFieldLength || !isPureAscii(value)) {
                        System.out.println(file.getName() + "," + id + "," + value.length()+" First Field Value: "+value);
                    }
                }

                if (secondValue != null) {
                    if (secondValue.length() >secondFieldLength || !isPureAscii(value)) {
                        System.out.println(file.getName() + "," + id + "," + secondValue.length()+" Second Field Value: " +secondValue);
                    }
                }

                if (thirdValue != null) {
                    if (thirdValue.length() >thirdFieldLength || !isPureAscii(value)) {
                        System.out.println(file.getName() + "," + id + "," + thirdValue.length()+" Third Field Value: " +thirdValue);
                    }
                }
            }
            bufferedReader.close();
            fileReader.close();

        }catch (Exception e){
            System.out.println(e);
        }

    }
}
