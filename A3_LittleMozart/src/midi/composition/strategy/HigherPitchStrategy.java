package midi.composition.strategy;

import midi.composition.strategy.interfaces.PitchStrategy;

public class HigherPitchStrategy implements PitchStrategy{

	@Override
	/**
	 * Changes pitch to a higher pitch by 2 semitones
	 */
	public int modifyPitch(int note) {
		note = note + 2;
		return note;
	}

}
