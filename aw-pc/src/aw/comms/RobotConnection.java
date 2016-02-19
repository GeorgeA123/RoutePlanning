package aw.comms;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;

import lejos.pc.comm.NXTComm;
import lejos.pc.comm.NXTCommException;
import lejos.pc.comm.NXTInfo;

/**
 * Handles the connection between the PC and the NXT robot and creates the data
 * streams.
 */
public class RobotConnection {
	private NXTInfo nxt;

	private BufferedReader br;
	private DataOutputStream dos;

	/**
	 * Creates an instance of RobotConnection for a specific NXT robot.
	 * 
	 * @param nxt
	 *            An NXTInfo object defining a robot's bluetooth information
	 */
	public RobotConnection(NXTInfo nxt) {
		this.nxt = nxt;
	}

	/**
	 * Initialises the connection beteween the PC and the robot.
	 * 
	 * @param nxtComm
	 *            The NXTComm object
	 * @throws NXTCommException
	 */
	public void connect(NXTComm nxtComm) throws NXTCommException {
		if (nxtComm.open(nxt)) {
			br = new BufferedReader(new InputStreamReader(nxtComm.getInputStream()));
			dos = new DataOutputStream(nxtComm.getOutputStream());
		}
	}

	/**
	 * Returns the DataInputStream for the RobotConnection
	 * 
	 * @return The DataInputStream
	 */
	public BufferedReader getBufferedReader() {
		return br;
	}

	/**
	 * Returns the DataOutputStream for the RobotConnection
	 * 
	 * @return The DataOutputStream
	 */
	public DataOutputStream getDataOutputStream() {
		return dos;
	}
}
