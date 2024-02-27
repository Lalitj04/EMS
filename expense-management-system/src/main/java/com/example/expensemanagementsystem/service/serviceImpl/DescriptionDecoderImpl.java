package com.example.expensemanagementsystem.service.serviceImpl;

import com.example.expensemanagementsystem.entity.TnxDescriptionAnalysis;
import com.example.expensemanagementsystem.repository.TnxDescriptionAnalysisRepository;
import com.example.expensemanagementsystem.service.DescriptionDecoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DescriptionDecoderImpl implements DescriptionDecoder {

    @Autowired
    TnxDescriptionAnalysisRepository descriptionAnalyserRepo;

    @Override
    public String decodeDescription(String description) {
        List<TnxDescriptionAnalysis> keywords = descriptionAnalyserRepo.findByOperation("START");
        String decodedString = null;
        for (TnxDescriptionAnalysis key : keywords) {
            if (description.startsWith(key.getKeyword())) {
                decodedString = key.getType();
                description = description.substring(key.getKeyword().length());
                break;
            }
        }
        if (decodedString != null) {
            keywords = descriptionAnalyserRepo.findByOperation("CONTAINS");
            for (TnxDescriptionAnalysis key : keywords) {
                if (description.toLowerCase().contains(key.getKeyword().toLowerCase())) {
                    decodedString += key.getType();
                    break;
                }
            }
            keywords = descriptionAnalyserRepo.findByOperation("START-DASH");
            String splitter = null;
            String index = null;
            for (TnxDescriptionAnalysis key : keywords) {
                if (description.startsWith(key.getKeyword())) {
                    splitter = key.getType();
                    index = key.getIndex();
                    break;
                }
            }
            if (splitter != null) {
                String[] tnx = description.split(splitter);
                String[] indexes = index.split(",");
                for (String ind : indexes) {
                    decodedString += " " + tnx[Integer.parseInt(ind)];
                }
            }
        } else {
            decodedString = description;
        }

        return decodedString;
    }

}
