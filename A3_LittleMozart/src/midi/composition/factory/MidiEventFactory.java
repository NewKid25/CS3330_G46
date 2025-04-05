package midi.composition.factory;

import javax.sound.midi.MidiEvent;

import midi.composition.exception.InvalidMidiDataException;

public interface MidiEventFactory {
	MidiEvent createNoteON(int tick, int note, int velocity, int channel) throws InvalidMidiDataException;
	MidiEvent createNoteOFF(int tick, int note, int velocity, int channel) throws InvalidMidiDataException;
}
