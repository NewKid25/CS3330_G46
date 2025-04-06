package midi.composition.strategy;

import midi.composition.strategy.interfaces.PitchStrategy;

public class LowerPitchStrategy implements PitchStrategy{

	@Override
	public int modifyPitch(int note) {
		note = note - 2;
		return note;
	}

}
