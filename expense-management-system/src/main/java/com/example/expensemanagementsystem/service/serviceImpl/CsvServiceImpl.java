package com.example.expensemanagementsystem.service.serviceImpl;

import com.example.expensemanagementsystem.entity.TransactionDetailsEntity;
import com.example.expensemanagementsystem.service.CsvService;
import com.example.expensemanagementsystem.service.DescriptionDecoder;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

@Service
public class CsvServiceImpl implements CsvService {

    @Autowired
    DescriptionDecoder dd;

    @Override
    public List<String> readFile(MultipartFile file) {
        String type = getFileType(file);
        List<String> data = new ArrayList<>();
       // if("CSV".equals(type)){
            data = readCsv(file);
            return data;//"Success";
       // }
//        else{
//           return readPdf(file);
//        }

    }

    private String getFileType(MultipartFile file){
        if(MediaType.APPLICATION_PDF_VALUE.equals(file.getContentType()) ||
                Objects.requireNonNull(file.getOriginalFilename()).toLowerCase().endsWith(".pdf")){
            return "PDF";
        } else if(MediaType.TEXT_PLAIN_VALUE.equals(file.getContentType()) ||
                Objects.requireNonNull(file.getOriginalFilename()).toLowerCase().endsWith(".csv")){
            return "CSV";
        }else{
            return null;
        }
    }

    private List<String> readCsv(MultipartFile file){
        List<String> tns= new ArrayList<>();

        try (CSVReader csvReader = new CSVReader(new InputStreamReader(file.getInputStream()))) {
            List<String[]> data = csvReader.readAll();
            boolean print = false;
            for(String[] d: data) {
                if(d[0].equals("Txn Date")){
                    print = true;
                }
                if(print){
                    String ds = dd.decodeDescription(d[2].trim());
                    System.out.println(ds);
                   tns.add(ds);
                }

            }
        } catch (IOException | CsvException e) {
            throw new RuntimeException(e);
        }
        return tns;
    }

    private List<TransactionDetailsEntity> getListOfTransactionsDetails(List<String[]> data){
        List<TransactionDetailsEntity> transactions = new ArrayList<>();
        Map<String,Long> tnsTypeToId = new HashMap<>();
        for(String[] tnx: data){

        }
        return transactions;
    }

    private String readPdf(MultipartFile file){
        List<String[]> data = new ArrayList<>();
        try (InputStream inputStream = file.getInputStream()) {
            PDDocument document = PDDocument.load(inputStream,"0411@7123");
            PDFTextStripper pdfTextStripper = new PDFTextStripper();
            String text = pdfTextStripper.getText(document);
            String[] lines = text.split("\\r?\\n");
            for(String line:lines){
                System.out.println(line);
            }
            document.close();
            return text;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
