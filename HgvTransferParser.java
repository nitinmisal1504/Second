package com.prominent;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import org.json.simple.JSONObject;

public class HgvTransferParser {
    ObjectMapper objectMapper = new ObjectMapper();
    public void hgvChangeInitiatedDate2Format(File fileToUpdate) throws IOException {
        try {

            File inputFile = new File(fileToUpdate.toURI());
            // Read existing file
            CSVReader reader = new CSVReader(new FileReader(inputFile));
            List<String[]> csvBody = reader.readAll();
            // get CSV row column and replace with by using row and column
        for(int i=1,j=0; i<csvBody.size(); i++){

                String[] strArray = csvBody.get(i);
                String initiatedDate2 = strArray[0];
                //String[] spiltInitiatedDate2=initiatedDate2.split("/");
            if(strArray[j].contains("/")) {
                String new_InitiatedDate2 = initiatedDate2.replace("/", "-");
                csvBody.get(i)[j] = new_InitiatedDate2; //Target replacement
            }
            /*
            for(int j=0; j<strArray.length; j++){
                if(strArray[j].equalsIgnoreCase("Update_date")){ //String to be replaced
                    csvBody.get(i)[j] = "Updated_date"; //Target replacement
                }
            }*/

        }
        System.out.println("Done.......");
        reader.close();

        // Write to CSV file which is open
        CSVWriter writer = new CSVWriter(new FileWriter(inputFile));
        writer.writeAll(csvBody);
        writer.flush();
        writer.close();

        }catch (Exception e){
            System.out.println(e);
        }

    }
    public static boolean isPureAscii(String v) {
        return StandardCharsets.US_ASCII.newEncoder().canEncode(v);
        // or "ISO-8859-1" for ISO Latin 1
        // or StandardCharsets.US_ASCII with JDK1.7+
    }
}


/*



        /*
        //String fileName = String.valueOf(file);
        // System.out.println("Filename="+fileName);
        try (FileReader fileReader = new FileReader(file)) {
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = null;
            JSONObject obj=new JSONObject();
            while ((line = bufferedReader.readLine()) != null) {
                //JsonNode jsonNode = objectMapper.readTree(line);
                String initiatedDate2 = jsonNode.get("InitiatedDate2").asText();
                String splitInitiatedDate2[] = initiatedDate2.split("/");
                String record0 = splitInitiatedDate2[0];
                String record1 = splitInitiatedDate2[1];
                String record2 = splitInitiatedDate2[2];
                String new_InitiatedDate2 = record0 + "-" + record1 + "-" + record2;

                /*
                obj.put("name",name);
                obj.put("id",id);
                obj.put("mobile",mobile);
                //jsonData+= id+" "+name+" "+mobile+"\n";
                //studList.add("\n"+String.valueOf(obj));
                System.out.println(obj);



            }
            /*System.out.println(jsonData);
            fileWriter.write(studList.toString());
            fileWriter.close();*/
                //System.out.println("Done........");
                /*
                String value = fieldName == null ? null : jsonNode.get(fieldName).asText();

                if (value != null) {
                    if (value.length() >4 || !isPureAscii(value)) {
                        System.out.println(file.getName() + "," + id + "," + value.length());
                    }
                }
            }
            }
            bufferedReader.close();
            fileReader.close();
*/

