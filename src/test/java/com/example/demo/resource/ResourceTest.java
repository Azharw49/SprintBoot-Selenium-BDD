package com.example.demo.resource;

import static org.junit.jupiter.api.DynamicTest.stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.FileCopyUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.example.demo.SpringBaseTestNGTest;

@PropertySource("file:data/test.csv")
public class ResourceTest extends SpringBaseTestNGTest{
	
	@Value("file:data/test.csv")
	private Resource resource;
	
	@Value("https://mkyong.com/java/java-read-a-file-from-resources-folder")
	private Resource url;
	
	@Value("${screenshot.path}")
    private Path path;
	
	@Autowired
	private ResourceLoader resourceLoader; 
	
	@Test(dataProvider = "readData")
	public void resourceTest(String saveAs , String url) throws IOException
	{
		FileCopyUtils.copy(
                resourceLoader.getResource(url).getInputStream(),
                Files.newOutputStream(path.resolve(saveAs+".html"))
        );
		Files.writeString(Path.of(saveAs+".csv"), saveAs + "," + url);
        
		
		
	}
	
	@DataProvider
	public Object[][] readData() throws IOException
	{
		
		return Files.readAllLines(resource.getFile().toPath())
		                   .stream()
		                   .skip(0)
		                   .map(s -> s.split(","))
		                   .toArray(Object[][]::new);
		
	}

}
