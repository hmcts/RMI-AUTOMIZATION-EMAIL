package uk.gov.hmcts.reform.rmi.service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.net.URISyntaxException;
import java.security.InvalidKeyException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microsoft.azure.storage.CloudStorageAccount;
import com.microsoft.azure.storage.StorageException;
import com.microsoft.azure.storage.blob.CloudBlobClient;
import com.microsoft.azure.storage.blob.CloudBlobContainer;
import com.microsoft.azure.storage.blob.CloudBlockBlob;
import com.microsoft.azure.storage.blob.ListBlobItem;

import uk.gov.hmcts.reform.rmi.properties.ApplicationProperties;

@Service
public class FindFileInContainer {

	private static final Logger logger = LoggerFactory.getLogger(FindFileInContainer.class);
	
	@Autowired
	private ApplicationProperties applicationProperties;
	
	public static final String storageConnectionString ="DefaultEndpointsProtocol=http;" +		    
			"AccountName=attachmentemailsto;" +		    
		    "AccountKey=KhOFyjIGqxt3+7ytSHVe+cFRCgMLqsTbenbjfykp0cW0CrdYoSndwNzK6AmYAcuoO3XVyf7T9HQIAdq/f1s6DQ==";
	
	
	@SuppressWarnings("unused")
	public ByteArrayInputStream retunFileData(String fileName) {
			
		ByteArrayInputStream inStream = null;
		
		try {
				
				CloudStorageAccount storageAccount = CloudStorageAccount.parse(storageConnectionString); //Finding the Storage Container
				CloudBlobClient blobClient = storageAccount.createCloudBlobClient(); // Creating the client for Blob Storage
				CloudBlobContainer container = blobClient.getContainerReference("attachments"); //Finding the container
				CloudBlockBlob cbb = container.getBlockBlobReference(fileName); //Getting Stream for the file
				ByteArrayOutputStream downloadedBlob = new ByteArrayOutputStream();
				cbb.download(downloadedBlob); //writting file as ByteArrayOutPutStream				    
				    
				inStream= new ByteArrayInputStream(downloadedBlob.toByteArray());		
				
				
		}catch(InvalidKeyException e) {
			logger.error("Invalid Key For connecting azure storage account: " + e);
		}catch(URISyntaxException e) {
			logger.error("Invalid URL formed: " + e);		
		}catch(StorageException e) {
			logger.error("Some problem found in azure storage account: " + e);
		}
		
		return inStream;
	}
	
	@SuppressWarnings("unused")
	public String retunFileName(String findString) {
			
		String fineNameReturn = null;
		
		try {
				
				CloudStorageAccount storageAccount = CloudStorageAccount.parse(storageConnectionString); //Finding the Storage Container
				CloudBlobClient blobClient = storageAccount.createCloudBlobClient(); // Creating the client for Blob Storage
				CloudBlobContainer container = blobClient.getContainerReference("attachments"); //Finding the container
				
				for (ListBlobItem blobItem : container.listBlobs()) {
			        
			    	if(blobItem.getUri().toString().contains(findString)){			    		
			    		fineNameReturn = blobItem.getUri().toString().substring(blobItem.getUri().toString().indexOf(findString));			    		
			    	}else{
			    		fineNameReturn = "NOT_FOUND";
			    	}
			    }
				
				
		}catch(InvalidKeyException e) {
			logger.error("Invalid Key For connecting azure storage account: " + e);
		}catch(URISyntaxException e) {
			logger.error("Invalid URL formed: " + e);		
		}catch(StorageException e) {
			logger.error("Some problem found in azure storage account: " + e);
		}
		
		return fineNameReturn;
	}
}
