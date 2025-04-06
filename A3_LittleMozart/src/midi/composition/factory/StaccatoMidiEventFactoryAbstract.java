package midi.composition.factory;

public class StaccatoMidiEventFactoryAbstract implements MidiEventFactoryAbstract{

	@Override
	public MidiEventFactory createFactory() {
		
		return new StaccatoMidiEventFactory();
	}

}
