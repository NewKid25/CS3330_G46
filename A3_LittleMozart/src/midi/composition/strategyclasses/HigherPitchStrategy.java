package midi.composition.strategyclasses;

import midi.composition.strategy.PitchStrategy;

public class HigherPitchStrategy implements PitchStrategy{

	@Override
	public int modifyPitch(int note) {
		note = note + 2;
		return note;
	}

}
