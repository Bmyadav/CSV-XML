package com.convert.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.convert.request.Sentence;
import com.convert.service.CSVService;
import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;

@Controller
public class CSVConvertController {

	@Autowired
	private CSVService csvService;

	@GetMapping("/export-csv")
	public void exportCSV(HttpServletResponse response) throws Exception {

		String filename = "textToCSV.csv";

		response.setContentType("text/csv");
		response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename\"" + filename + "\"");

		// create csv writer
		StatefulBeanToCsv<Sentence> writer = new StatefulBeanToCsvBuilder<Sentence>(response.getWriter())
				.withQuotechar(CSVWriter.NO_QUOTE_CHARACTER).withSeparator(CSVWriter.DEFAULT_SEPARATOR)
				.withOrderedResults(true).build();

		// write all users to csv file
		writer.write(csvService.listData());

	}

	public Object withignoreQuatations(boolean b) {
		// TODO Auto-generated method stub
		return toString();
	}
}
