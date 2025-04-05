package midi.composition.strategy;

import javax.sound.midi.Track;
import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.ShortMessage;

public class ElectricBassGuitarStrategy implements InstrumentStrategyInterface{

	int instrumentNumber = 33; 
	
	@Override
	public void applyInstrument(Track track, int channel) {
        try {        	
        	ShortMessage msg = new ShortMessage();
        	msg.setMessage(ShortMessage.PROGRAM_CHANGE, channel, instrumentNumber, 0);
        	MidiEvent event = new MidiEvent(msg, 0);
        	track.add(event);
        	
        }
        catch(InvalidMidiDataException e)
        {
        	e.printStackTrace();
        }
	}

}
