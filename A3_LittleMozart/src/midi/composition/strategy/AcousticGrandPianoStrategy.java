package midi.composition.strategy;

import javax.sound.midi.Track;

import midi.composition.strategy.interfaces.InstrumentStrategy;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.ShortMessage;

public class AcousticGrandPianoStrategy implements InstrumentStrategy{

	int instrumentNumber = 0;
	
	@Override
	/**
	 * Sets the instrument type to Acoustic Grand Piano
	 */
	public void applyInstrument(Track track, int channel) {
        try {        	
        	ShortMessage msg = new ShortMessage();
        	msg.setMessage(ShortMessage.PROGRAM_CHANGE, channel, instrumentNumber, 100);
        	MidiEvent event = new MidiEvent(msg, 0);
        	track.add(event);
        	
        }
        catch(InvalidMidiDataException e)
        {
        	e.printStackTrace();
        }
	}
	
}
