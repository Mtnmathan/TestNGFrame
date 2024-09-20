package utilities;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class FileReaderAndWriter {

    private Properties props = new Properties();
    private String filePath;

    public FileReaderAndWriter(String filePath) {
        this.filePath = filePath;
    }

    public Properties readData() throws IOException {
        try (FileInputStream fis = new FileInputStream(filePath)) {
            props.load(fis);
        }
        return props;
    }
    
    public String getURL() throws IOException {
        readData();
        return props.getProperty("URL");
    }
    
    public String getInputSearchTerm() throws IOException {
    	readData();
		return props.getProperty("SearchTerm");	
    }
    
    public String getIndex() throws IOException {
        readData();
        return props.getProperty("Index");
    }

    
    public void writeData(String key, String value) throws IOException {
        // Load the existing properties without overwriting them
//        props.load(new FileInputStream(filePath));
        readData();
        
        // Use OutputStream to append the new value at the end
        try (OutputStream out = new FileOutputStream(filePath, true)) {
            out.write(("\n" + key + "=" + value).getBytes());
        }
    }
}
