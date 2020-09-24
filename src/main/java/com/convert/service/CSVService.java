package com.convert.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.convert.request.Sentence;

@Service
public class CSVService {

	public List<Sentence> listData(){
		
		List<Sentence> listAllData=new ArrayList<>();
		listAllData.add(new Sentence("what is you name?my name is something"));
		listAllData.add(new Sentence("java is a open source programming language"));
		return listAllData;
	}
	
}
