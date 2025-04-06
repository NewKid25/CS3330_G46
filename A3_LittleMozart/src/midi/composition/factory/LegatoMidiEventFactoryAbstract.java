package midi.composition.factory;

public class LegatoMidiEventFactoryAbstract implements MidiEventFactoryAbstract{

	@Override
	public MidiEventFactory createFactory() {
		
		return new LegatoMidiEventFactory();
	}

}
