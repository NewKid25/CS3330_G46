package midi.composition.strategy.interfaces;

public interface PitchStrategy {
	/**
	 * This method modifies the pitch of a note
	 * @param note-note given
	 * @return note
	 */
	int modifyPitch(int note);
}
