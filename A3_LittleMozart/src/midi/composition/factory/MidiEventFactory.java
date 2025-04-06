package midi.composition.factory;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;


public interface MidiEventFactory {
	/**
	 * makes a note play a sound
	 * @param tick-tick speed of note
	 * @param note-music note type
	 * @param velocity-velocity of note
	 * @param channel-channel of note
	 * @return MidiEvent
	 * @throws InvalidMidiDataException-makes sure invalid midi type isn't put in
	 */
	MidiEvent createNoteOn(int tick, int note, int velocity, int channel) throws InvalidMidiDataException;
	/**
	 * makes a note stop playing a sound
	 * @param tick-tick speed
	 * @param note- note type
	 * @param channel- note channel
	 * @return MidiEvent
	 * @throws InvalidMidiDataException-makes sure invalid midi type isn't put in
	 */
	MidiEvent createNoteOff(int tick, int note, int channel) throws InvalidMidiDataException;
}
