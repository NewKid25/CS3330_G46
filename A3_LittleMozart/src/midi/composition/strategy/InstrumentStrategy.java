package midi.composition.strategy;

import javax.sound.midi.Track;

public interface InstrumentStrategy {
	void applyInstrument(Track track, int channel);
}
