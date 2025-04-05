package midi.composition.main;

import java.util.List;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;

import midi.composition.factory.MidiEventFactoryAbstract;
import midi.composition.factory.StandardMidiEventFactoryAbstract;
import midi.composition.factory.MidiEventFactory;
import midi.composition.data.MidiCsvParser;
import midi.composition.data.MidiEventData;
import midi.composition.strategy.*;

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
            List<MidiEventData> midiEvents = MidiCsvParser.parseCsv("./files/mysterysong.csv");
            Sequence sequence = new Sequence(Sequence.PPQ, 384);
            Track track = sequence.createTrack();
            MidiEventFactoryAbstract factoryAbstract = new StandardMidiEventFactoryAbstract();
            // MidiEventFactoryAbstract factoryAbstract = new LegatoMidiEventFactoryAbstract();
            // MidiEventFactoryAbstract factoryAbstract = new StaccatoMidiEventFactoryAbstract();
            MidiEventFactory factory = factoryAbstract.createFactory();
            // Choose an instrument strategy (e.g., Trumpet, BassGuitar, Piano)
            InstrumentStrategy instrumentStrategy = new ElectricBassGuitarStrategy();
            instrumentStrategy.applyInstrument(track, 0);
            instrumentStrategy = new TrumpetStrategy();
            instrumentStrategy.applyInstrument(track, 1);
            // Choose a pitch strategy (e.g., HigherPitch, LowerPitch)
//            PitchStrategy pitchStrategy = new HigherPitchStrategy();
            for (MidiEventData event : midiEvents) {
//                int modifiedNote = pitchStrategy.modifyPitch(event.getNote());
                int modifiedNote =event.getNote();

                // call this as much as you want if you want to get a higher pitch
//                modifiedNote = pitchStrategy.modifyPitch(modifiedNote);
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
                Thread.sleep(100);
            }
            Thread.sleep(500);
            sequencer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

//package midi.composition.main;
//import javax.sound.midi.*;
//
//public class Main {
//
//    public static void main(String[] args) {
//        try {
//            // Create a new MIDI sequence with a resolution of 480 ticks per quarter note
//            Sequence sequence = new Sequence(Sequence.PPQ, 480);
//
//            // Get the first track from the sequence
//            Track track = sequence.createTrack();
//
//            // --- Instrument Selection ---
//            int channel = 0;
//            int programNumber = 27; // Clean Electric Guitar
//            ShortMessage programChange = new ShortMessage();
//            programChange.setMessage(ShortMessage.PROGRAM_CHANGE, channel, programNumber, 0);
//            MidiEvent programChangeEvent = new MidiEvent(programChange, 0); // At the beginning of the track (tick 0)
//            track.add(programChangeEvent);
//
//            // --- Playing Notes ---
//            int note = 60; // C4
//            int velocity = 100;
//            long startTick = 480; // Start after one quarter note
//            int durationTicks = 960; // Last for two quarter notes
//
//            // Note On event
//            ShortMessage noteOn = new ShortMessage();
//            noteOn.setMessage(ShortMessage.NOTE_ON, channel, note, velocity);
//            MidiEvent noteOnEvent = new MidiEvent(noteOn, startTick);
//            track.add(noteOnEvent);
//
//            // Pitch Bend (example during the note)
//            int pitchBendValue = 8192 + 500;
//            ShortMessage pitchBend = new ShortMessage();
//            pitchBend.setMessage(ShortMessage.PITCH_BEND, channel, pitchBendValue & 0x7F, (pitchBendValue >> 7) & 0x7F);
//            MidiEvent pitchBendEvent = new MidiEvent(pitchBend, startTick + durationTicks / 4);
//            track.add(pitchBendEvent);
//
//            // Note Off event
//            ShortMessage noteOff = new ShortMessage();
//            noteOff.setMessage(ShortMessage.NOTE_OFF, channel, note, 0);
//            MidiEvent noteOffEvent = new MidiEvent(noteOff, startTick + durationTicks);
//            track.add(noteOffEvent);
//
//            // --- Play the Sequence ---
//            Sequencer sequencer = MidiSystem.getSequencer();
//            sequencer.open();
//            sequencer.setSequence(sequence);
//
//            // Start playing
//            sequencer.start();
//
//            // Keep the program running until the sequencer finishes
//            while (sequencer.isRunning()) {
//                try {
//                    Thread.sleep(100);
//                } catch (InterruptedException e) {
//                    Thread.currentThread().interrupt();
//                    break;
//                }
//            }
//
//            // Close the sequencer
//            sequencer.close();
//
//        } catch (MidiUnavailableException e) {
//            System.err.println("MIDI device unavailable: " + e.getMessage());
//        } catch (InvalidMidiDataException e) {
//            System.err.println("Invalid MIDI data: " + e.getMessage());
//        }
//    }
//}