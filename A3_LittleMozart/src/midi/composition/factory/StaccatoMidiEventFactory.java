package midi.composition.factory;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.ShortMessage;

public class StaccatoMidiEventFactory implements MidiEventFactory{

	@Override
	/**
	 * @param tick- tick speed
	 * @param note- music note
	 * @param velocity- note velocity
	 * @param channel- note channel
	 * this method makes a staccato note play
	 */
	public MidiEvent createNoteOn(int tick, int note, int velocity, int channel) throws InvalidMidiDataException {
		ShortMessage message = new ShortMessage();
		try {
			message.setMessage(ShortMessage.NOTE_ON, channel, note, velocity);
		} catch (InvalidMidiDataException e) {
			e.printStackTrace();
		}
		MidiEvent event = new MidiEvent(message, tick);
		return event;
	}

	@Override
	/**
	 * @param tick- tick speed
	 * @param note- music note
	 * @param velocity- note velocity
	 * @param channel- note channel
	 * this method turns off a stacatto note
	 */
	public MidiEvent createNoteOff(int tick, int note, int channel) throws InvalidMidiDataException {
		ShortMessage message = new ShortMessage();
		try {
			message.setMessage(ShortMessage.NOTE_OFF, channel, note, 0);
		} catch (InvalidMidiDataException e) {
			e.printStackTrace();
		}
		MidiEvent event = new MidiEvent(message, tick-120);
		return event;
	}

}
