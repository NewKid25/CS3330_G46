package midi.composition.factory;

import javax.sound.midi.MidiEvent;

import midi.composition.exception.InvalidMidiDataException;

public interface MidiEventFactory {
	MidiEvent createNoteOn(int tick, int note, int velocity, int channel) throws InvalidMidiDataException;
	MidiEvent createNoteOff(int tick, int note, int channel) throws InvalidMidiDataException;
}
