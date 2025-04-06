package midi.composition.data;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MidiCsvParser {
	
	/**
	 * @param filePath path to the csv to be parse
	 * @return all the rows in the csv as list of MidiEventData
	 * This method parses a properly formated csv to MidiEventData which can be played in sequencer
	 */
	
	public static List<MidiEventData> parseCsv (String filePath)
	{
	    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) 
	    {
	    	
	    	List<MidiEventData> midiList = new ArrayList<>();
	    	String line;
            while (( line = reader.readLine()) != null) {
                String[] values = line.split(",");
                midiList.add(lineToMidiEventData(values));
            }
            reader.close();
            return midiList;
        }
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(Exception e){
			System.out.println("error occured when trying to read from file: "+ e.getMessage());
			e.printStackTrace();
		}
	    return null;
	    
	}
	
	/**
	 * @param values array of data parsed from csv must be in [tick, on/off, channel, note, velocity]
	 * @return values mapped to MidiEvent Data
	 */
	private static MidiEventData lineToMidiEventData(String[] values)
	{
		int lineLength =6; //also number of params MidiEventData constructor takes
		int[] intValues = new int[lineLength];
		for(int i=0;i<lineLength; i++)
		{
			try { //one of the columns can't be parsed, because it is on/off
				intValues[i] = Integer.parseInt(values[i]);				
			}
			catch(Exception e)
			{
				//manual mapping, on=1,off=0
				if(values[i].contains("off")) 
				{
					intValues[i]=0;
				}
				else 
				{
					intValues[i]=1;
				}
			}
		}
		 var midiData = new MidiEventData(intValues[0], 
				 						intValues[4], 
				 						intValues[3], 
				 						intValues[2], 
				 						intValues[5], 
				 						intValues[1]);
		 return midiData;
	}
}
