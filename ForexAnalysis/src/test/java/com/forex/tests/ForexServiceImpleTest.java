package com.forex.tests;

import static org.junit.Assert.assertTrue;

import java.util.List;

import com.forex.model.ForexData;
import com.forex.services.ForexService;
import com.forex.servicesImpl.ForexServiceImpl;

import org.junit.BeforeClass;
import org.junit.Test;

public class ForexServiceImpleTest {

	private static ForexService fx;
	@BeforeClass
	public static void init(){
		fx=new ForexServiceImpl();
		
	}
	@Test
	public void testStoreAndGetData(){
		
		ForexData data=new ForexData();
		data.setInstrument("EUR_IDR");
		data.setTimeStamp(1457718575151l);
		data.setBuyPrice(15236);
		data.setSellPrice(16223);
		fx.store(data);
		System.out.println(fx.getData(data.getInstrument(), data.getTimeStamp()));
		assertTrue(fx.getData(data.getInstrument(), data.getTimeStamp())!=null);
	}
	
	@Test
	public void testScanNoTimeRange(){
		List<ForexData> data=fx.scan("EUR_USD");
		assertTrue(data!=null);
		assertTrue(fx.scan("EUR_USD").size()==150);
	}
	
	@Test
	public void testScanWithTimeRange(){
		List<ForexData> data=fx.scanWithinTimeRange("EUR_JPY", 1457973255951l, 1457973970000l);
		assertTrue(data!=null);
		assertTrue(data.size()==21);
		
	}
	
	
	

	
	
	
}
