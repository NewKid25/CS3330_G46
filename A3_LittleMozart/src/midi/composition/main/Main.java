package midi.composition.main;

import java.util.List;

import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;

import midi.composition.factory.*;
import midi.composition.data.MidiCsvParser;
import midi.composition.data.MidiEventData;
import midi.composition.strategy.*;
import midi.composition.strategyclasses.HigherPitchStrategy;

public class Main {
    public static void main(String[] args) {
    	//Parser Testin
//    	String songPath = "./src/midi/composition/input/mystery_song.csv"; //path is relative to root of project, not this file
//    	var parser = new MidiCsvParser();
//    	var midiList = parser.parseCsv(songPath);
//        for (var midiData : midiList) {
//            System.out.println(midiData.toString());
//        }
//    }
        try {
            List<MidiEventData> midiEvents = MidiCsvParser.parseCsv("./src/midi/composition/input/mystery_song.csv");
            Sequence sequence = new Sequence(Sequence.PPQ, 384);
            Track track = sequence.createTrack();
//            MidiEventFactoryAbstract factoryAbstract = new StandardMidiEventFactoryAbstract();
            MidiEventFactoryAbstract factoryAbstract = new LegatoMidiEventFactoryAbstract();
//            MidiEventFactoryAbstract factoryAbstract = new StaccatoMidiEventFactoryAbstract();
            MidiEventFactory factory = factoryAbstract.createFactory();
            // Choose an instrument strategy (e.g., Trumpet, BassGuitar, Piano)
            InstrumentStrategy instrumentStrategy = new ElectricBassGuitarStrategy();
            instrumentStrategy.applyInstrument(track, 0);
            instrumentStrategy = new TrumpetStrategy();
            instrumentStrategy.applyInstrument(track, 1);
            instrumentStrategy = new AcousticGrandPianoStrategy();
            instrumentStrategy.applyInstrument(track, 2);
            instrumentStrategy = new SaxStrategy();
            instrumentStrategy.applyInstrument(track, 3);
            instrumentStrategy = new BassoonStrategy();
            instrumentStrategy.applyInstrument(track, 4);


            
//        	ShortMessage msg = new ShortMessage();
//        	msg.setMessage(ShortMessage.PROGRAM_CHANGE, 0, 33, 100);
//        	MidiEvent eventTemp = new MidiEvent(msg, 0);
//        	track.add(eventTemp);
//             Choose a pitch strategy (e.g., HigherPitch, LowerPitch)
            PitchStrategy pitchStrategy = new HigherPitchStrategy();
            for (MidiEventData event : midiEvents) {
                int modifiedNote = pitchStrategy.modifyPitch(event.getNote());
//                modifiedNote =event.getNote();

                // call this as much as you want if you want to get a higher pitch
                modifiedNote = pitchStrategy.modifyPitch(modifiedNote);
                if (event.getNoteOnOff() == ShortMessage.NOTE_ON) {
                    track.add(factory.createNoteOn(event.getStartEndTick(),
                            modifiedNote,
                            event.getVelocity(),
                            event.getChannel()));
                } else {
                    track.add(factory.createNoteOff(event.getStartEndTick(), modifiedNote, event.getChannel()));
                }
            }
            // Playing the sequence
            Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.open();
            sequencer.setSequence(sequence);
            sequencer.start();
            while (sequencer.isRunning() | sequencer.isOpen()) {
            	System.out.println("sequencer running");
                Thread.sleep(100);
            }
            Thread.sleep(500);
            sequencer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

