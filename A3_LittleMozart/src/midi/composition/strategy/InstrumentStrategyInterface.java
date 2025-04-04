package midi.composition.strategy;

import javax.sound.midi.Track;

public interface InstrumentStrategyInterface {
	void applyInstrument(Track track, int channel);
}
