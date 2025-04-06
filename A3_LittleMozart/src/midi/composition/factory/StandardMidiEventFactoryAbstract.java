package midi.composition.factory;

public class StandardMidiEventFactoryAbstract implements MidiEventFactoryAbstract{

	@Override
	/**
	 * This creates a StandardMidiEventFactory
	 */
	public MidiEventFactory createFactory() {
		
		return new StandardMidiEventFactory();
	}

}
