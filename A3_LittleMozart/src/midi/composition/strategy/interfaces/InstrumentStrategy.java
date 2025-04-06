package midi.composition.strategy.interfaces;

import javax.sound.midi.Track;

public interface InstrumentStrategy{
	void applyInstrument(Track track, int channel);
}
