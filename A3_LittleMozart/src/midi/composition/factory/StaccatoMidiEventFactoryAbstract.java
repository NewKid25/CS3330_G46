package midi.composition.factory;

public class StaccatoMidiEventFactoryAbstract implements MidiEventFactoryAbstract{

	@Override
	/**
	 * This creates a StaccatoMidiEventFactory
	 */
	public MidiEventFactory createFactory() {
		
		return new StaccatoMidiEventFactory();
	}

}
