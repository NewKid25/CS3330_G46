package midi.composition.strategy.interfaces;

import javax.sound.midi.Track;


public interface InstrumentStrategy{
	/**
	 * This method is to make the instrument play the track
	 * @param track-track given
	 * @param channel-channel type
	 */
	void applyInstrument(Track track, int channel);
}
