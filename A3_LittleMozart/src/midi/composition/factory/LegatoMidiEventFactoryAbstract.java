package midi.composition.factory;

import javax.sound.midi.MidiEvent;
import javax.sound.midi.ShortMessage;

import midi.composition.exception.InvalidMidiDataException;

public class LegatoMidiEventFactoryAbstract implements MidiEventFactory{

	@Override
	public MidiEvent createNoteOn(int tick, int note, int velocity, int channel) throws InvalidMidiDataException {
		ShortMessage message = new ShortMessage();
		try {
			message.setMessage(ShortMessage.NOTE_ON, channel, note, velocity);
		} catch (javax.sound.midi.InvalidMidiDataException e) {
			e.printStackTrace();
		}
		MidiEvent event = new MidiEvent(message, tick);
		return event;
	}

	@Override
	public MidiEvent createNoteOff(int tick, int note, int channel) throws InvalidMidiDataException {
		ShortMessage message = new ShortMessage();
		try {
			message.setMessage(ShortMessage.NOTE_OFF, channel, note, 0);
		} catch (javax.sound.midi.InvalidMidiDataException e) {
			e.printStackTrace();
		}
		MidiEvent event = new MidiEvent(message, tick);
		return event;
	}
	
}
