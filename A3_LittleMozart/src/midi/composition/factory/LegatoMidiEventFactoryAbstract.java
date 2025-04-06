package midi.composition.factory;

public class LegatoMidiEventFactoryAbstract implements MidiEventFactoryAbstract{

	@Override
	/**
	 * creates a new LegatoMidiFactory
	 */
	public MidiEventFactory createFactory() {
		
		return new LegatoMidiEventFactory();
	}

}
