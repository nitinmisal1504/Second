package com.prominent;

import java.io.File;
import java.io.IOException;
public class JsonParsingAppMain {
    public static void main(String[] args) {
        //String filePath = "E:\\Hilton\\HRCC\\inputs\\Qualtrics\\Globalized";
        //String fieldName = "inbound_email_addresses__c";
        String filePath = "C:\\Users\\nitin\\Downloads\\HRCCSurvey_2022-02-26 (8).json";
        String fieldName = "Language__c"; // Initial_Message_Privacy__c Language__c Social_Network__c
        String firstFieldName = "Initial_Message_Privacy__c";
        int firstFieldLength = 3;
        //String filePath = "E:\\Hilton\\HRCC\\inputs\\qualtrics feedback input files\\4";
        //String fieldName = "Q_URL";
        //String filePath = "E:\\Hilton\\HRCC\\inputs\\gemTemp";
        // String fieldName = "RoomType_Code__c"; //“
        //int fieldLength = 50;
        JsonParsingAppMain jsonParsingAppMain = new JsonParsingAppMain();
        //     jsonParsingAppMain.process(filePath, fieldName);
        //jsonParsingAppMain.hgvChangeInitiatedDate2Format(filePath);
        jsonParsingAppMain.process(filePath, firstFieldName);
    }
/*
    public void process(String folderPath, String fieldName) {
        //QualtricsInputParser qualtricsInputParser = new QualtricsInputParser();
        GemInputParser gemInputParser = new GemInputParser();
        try {
            File inputFolder = new File(folderPath);
            if (inputFolder.isFile()) {
                //qualtricsInputParser.process(inputFolder, fieldName);
                gemInputParser.process(inputFolder, fieldName);
            } else {
                File files[] = inputFolder.listFiles();
                for (File file : files) {
                    //System.out.println(file.getPath());
                    //System.out.println(file.getName());
                    //qualtricsInputParser.process(file, fieldName);
                    gemInputParser.process(file, fieldName);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}*/
    /*
    public void hgvChangeInitiatedDate2Format(String folderPath) {
        HgvTransferParser hgvTransferParser=new HgvTransferParser();
        try {
            File inputFolder = new File(folderPath);
            if (inputFolder.isFile()) {
                hgvTransferParser.hgvChangeInitiatedDate2Format(inputFolder);
            } else {
                File files[] = inputFolder.listFiles();
                for (File file : files) {
                    //System.out.println(file.getPath());
                    //System.out.println(file.getName());
                    hgvTransferParser.hgvChangeInitiatedDate2Format(file);
                    //  gemInputParser.process(file,fieldName);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
*/
public void process(String folderPath, String fieldName) {
    QualtricsInputParser qualtricsInputParser = new QualtricsInputParser();
//    GemInputParser gemInputParser = new GemInputParser();
    try {
        File inputFolder = new File(folderPath);
        if (inputFolder.isFile()) {
            qualtricsInputParser.process(inputFolder, fieldName);
//            gemInputParser.process(inputFolder, firstFieldName,firstFieldLength,secondFieldName,secondFieldLength,thirdFieldName,thirdFieldLength);
        } else {
            File files[] = inputFolder.listFiles();
            for (File file : files) {
                //System.out.println(file.getPath());
                //System.out.println(file.getName());
                qualtricsInputParser.process(file, fieldName);
//                gemInputParser.process(file, firstFieldName,firstFieldLength,secondFieldName,secondFieldLength,thirdFieldName,thirdFieldLength);
            }
        }
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
}
}