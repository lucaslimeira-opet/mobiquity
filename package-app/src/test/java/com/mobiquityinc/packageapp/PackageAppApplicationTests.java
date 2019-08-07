package com.mobiquityinc.packageapp;

import static org.junit.Assert.assertEquals;

import java.net.URL;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mobiquityinc.packageapp.exception.APIException;
import com.mobiquityinc.packageapp.util.PackerConstants;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PackageAppApplicationTests {

	private Packer packer;

	@Before
	public void contextLoads() {
		packer = new Packer();  
	}

	@Test
	public void testPackValid() throws APIException {
		StringBuilder sbExpected = new StringBuilder();
		sbExpected.append("[4]" + "\n");
		sbExpected.append("-" + "\n");
		sbExpected.append("[2, 7]" + "\n");
		sbExpected.append("[8, 9]" + "\n");

		URL url = getFilePath("/valid.txt");
		String packResult = packer.pack(url.getFile());

		assertEquals(sbExpected.toString(), packResult);
	}

	@Test
	public void testPackInvalidPackageMaxWeight() {
		URL url = getFilePath("/invalidPackageMaxWeight.txt");
		try {
			String packResult = packer.pack(url.getFile());
			Assert.fail();
		} catch (APIException e) {
			assertEquals("Max weight that a package can take is " + PackerConstants.APP_MAX_PACKAGE_WEIGHT, e.getMessage());
		}
	}

	

	@Test
	public void testPackInvalidItemMaxWeight() {
		URL url = getFilePath("/invalidItemMaxWeight.txt");
		try {
			String packResult = packer.pack(url.getFile());
			Assert.fail();
		} catch (APIException e) {
			assertEquals("Max weight of an item is " + PackerConstants.APP_MAX_ITEM_WEIGHT, e.getMessage());
		}
	}

	@Test
	public void testPackInvalidItemMaxPrice() {
		URL url = getFilePath("/invalidItemMaxPrice.txt");
		try {
			String packResult = packer.pack(url.getFile());
			Assert.fail();
		} catch (APIException e) {
			assertEquals("Max cost of an item is " + PackerConstants.APP_MAX_ITEM_COST, e.getMessage());
		}
	}

	@Test
	public void testEmptyFilePath() {
		try {
			packer.pack("");
			Assert.fail();
		} catch (APIException e) {
			assertEquals("No filePath has been provided", e.getMessage());
		}
	}

	@Test
	public void testNullFilePath() {
		try {
			packer.pack(null);
			Assert.fail();
		} catch (APIException e) {
			assertEquals("No filePath has been provided", e.getMessage());
		}
	}

	@Test
	public void testPackNoFile() {
		try {
			packer.pack("itdoesnotexist.txt");
			Assert.fail();
		} catch (APIException e) {
			assertEquals("The system cannot find the file specified", e.getMessage());
		}
	}
	
	
	private URL getFilePath(String fileName) {
		URL url = this.getClass().getResource(fileName);
		return url;
	}

}