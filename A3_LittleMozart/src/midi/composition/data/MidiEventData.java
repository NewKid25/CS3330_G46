package midi.composition.data;

import javax.sound.midi.ShortMessage;

public class MidiEventData {
    private int startEndTick, velocity, note, channel, noteOnOff;
    private int instrument;
    
    /**
     * 
     * @param startEndTick-
     * @param velocity-
     * @param note-music note
     * @param channel- music channel
     * @param instrument-type of instrument
     * @param noteOnOff-if note is on or off
     */
    public MidiEventData(int startEndTick, int velocity, int note,
                           int channel, int instrument, int noteOnOff) {
        this.startEndTick = startEndTick;
        this.velocity = velocity;
        this.note = note;
        this.channel = channel;
        this.instrument = instrument;
        this.noteOnOff = noteOnOff;
    }
    
    /**
     * gets the startEndTick
     * @return the startEndTick
     */
	public int getStartEndTick() {
		return startEndTick;
	}
	/**
	 * sets the startEndTick
	 * @param startEndTick-the startEndTick given
	 */
	public void setStartEndTick(int startEndTick) {
		this.startEndTick = startEndTick;
	}
	/**
	 * gets the velocity
	 * @return the velocity
	 */
	public int getVelocity() {
		return velocity;
	}
	/**
	 * sets the velocity
	 * @param velocity-velocity given
	 */
	public void setVelocity(int velocity) {
		this.velocity = velocity;
	}
	/**
	 * gets the note
	 * @return the note
	 */
	public int getNote() {
		return note;
	}
	/**
	 * sets the note
	 * @param note-note given
	 */
	public void setNote(int note) {
		this.note = note;
	}
	/**
	 * returns the channel
	 * @return channel
	 */
	public int getChannel() {
		return channel;
	}
	/**
	 * sets the channel
	 * @param channel-channel given
	 */
	public void setChannel(int channel) {
		this.channel = channel;
	}
	/**
	 * returns if the note is on or off
	 * @return noteOnOFF
	 */
	public int getNoteOnOff() {
		return noteOnOff*144;//144 is the code for ShortMessage.NOTE_ON
	}
	/**
	 * sets the node on or off
	 * @param noteOnOff
	 */
	public void setNoteOnOff(int noteOnOff) {
		this.noteOnOff = noteOnOff;
	}
	/**
	 * returns type of instrument
	 * @return type of instrument
	 */
	public int getInstrument() {
		return instrument;
	}
	/**
	 * sets the type of instrument
	 * @param instrument-instrument given
	 */
	public void setInstrument(int instrument) {
		this.instrument = instrument;
	}


	@Override
	/**
	 * toString method for adding all the data into one line.
	 */
	public String toString() {
		return "MidiEventData [startEndTick=" + startEndTick + ", velocity=" + velocity + ", note=" + note
				+ ", channel=" + channel + ", noteOnOff=" + noteOnOff + ", instrument=" + instrument + "]";
	}
    

}
