package genomeAnalysis;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class WriteResult {
	
	public static void loadSequence(String chrLoad, String strandLoad, Integer strerLoad, Integer endLoad, String sequenceLoad) throws IOException{
		   
		   ArrayList<String> listOfSequence = new ArrayList<String>();
		   listOfSequence.add(sequenceLoad);
		   File locationFile = new File("./Result/resultHg19.txt");
		   FileWriter writeFile = null;
		   BufferedWriter fileLoad = null;
		   writeFile = new FileWriter(locationFile, true);
		   fileLoad = new BufferedWriter(writeFile);
		   if(!locationFile.exists()){
			     locationFile.createNewFile(); 
		       }
			   try{ 
				     fileLoad.append(strandLoad+" "+chrLoad+":"+strerLoad+"-"+endLoad+"               "+sequenceLoad);
				     fileLoad.newLine();
				     fileLoad.flush();
				     fileLoad.close(); 
			    } catch (IOException e) {
			         e.printStackTrace(); 
			    } catch (Exception e) {
			    	System.err.println("Error: "+e.getMessage());
			    } finally {
			    	try {
			    		  fileLoad.close();
			    		  writeFile.close(); 
			    	} catch (IOException e){
			    		e.printStackTrace();
			    	}	   
		        }
		    }
		}
