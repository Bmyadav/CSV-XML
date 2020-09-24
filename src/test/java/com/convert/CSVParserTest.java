package com.convert;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Locale;

import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.shadow.com.univocity.parsers.csv.CsvParser;

import com.convert.controller.CSVConvertController;

public class CSVParserTest {

	private static final Class<? extends Throwable> IOException = null;
	CSVConvertController csvParser;
	private Object[] nextLine;
	private static Locale systemLocal;

	@BeforeClass
	@BeforeAll
	public static void storeSystemLocal() {
		systemLocal = Locale.getDefault();
	}

	@After
	@AfterEach
	public void setUp() {
		Locale.setDefault(systemLocal);
	}

	@Before
	@BeforeEach
	public void setup() {
		Locale.setDefault(Locale.ENGLISH);
		csvParser=new  CSVConvertController();

		assertEquals("text", nextLine[2]);
	}

	@Test(expected = IOException.class)
	public void testFalsIgnoreQuatations() throws IOException {
		csvParser = new CSVConvertController().StatefulBeanToCsv(false).build();
		String testString ="text,test\",textFile,TXT";
		Assertions.parseLine(testString), ()->{
			csvParser.parseLine(testString);
		});
	}

}
