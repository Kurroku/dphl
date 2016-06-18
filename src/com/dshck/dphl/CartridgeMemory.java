package com.dshck.dphl;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 
 * @author Phillip Groves
 *
 */
public class CartridgeMemory {

	
	/** The internal position, or cursor, of this buffer. */
	private int position;
	
	/** A representation of memory as a byte array */
	private byte[] memory;

	/**
	 * 
	 * @param rom
	 */
	public CartridgeMemory( File rom ) {
		try {
			RandomAccessFile bytes = new RandomAccessFile( rom, "r" );
			memory = new byte[(int)bytes.length()];
			bytes.read( memory );
			bytes.close();
		} catch ( IOException e ) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @return
	 */
	public int get() {
		return get( position );
	}

	/**
	 * 
	 * @param address
	 * @return
	 */
	public int get( int address ) {
		setPosition(address + 1);
		return memory[address] & 0xFF;
	}

	/**
	 * 
	 * @param value
	 */
	public void put( int value ) {
		put( position, value );
	}
	
	/**
	 * 
	 * @param address
	 * @param value
	 */
	public void put( int address, int value ) {
		setPosition( address + 1 );
		memory[address] = (byte) value;
	}

	/**
	 * 
	 * @param address
	 * @param length
	 * @return
	 */
	public int[] getBytes( int address, int length ) {
		int[] values = new int[length];
		for ( int i = 0; i < values.length; i++ )
			values[i] = get( address + i );
		return values;
	}
	
	/**
	 * 
	 * @param values
	 * @param address
	 */
	public void putBytes( int[] values, int address ) {
		for ( int i = 0; i < values.length; i++ )
			put( values[i], address + i );
	}

	/**
	 * 
	 * @return
	 */
	public int getShort() {
		return getShort( position );
	}

	/**
	 * 
	 * @param address
	 * @return
	 */
	public int getShort( int address ) {
		setPosition(address + 2);
		return get( address ) | ( get( address + 1 ) << 8 );
	}

	/**
	 * 
	 * @param value
	 */
	public void putShort( int value ) {
		put( position, value );
	}
	
	/**
	 * 
	 * @param address
	 * @param value
	 */
	public void putShort( int address, int value ) {
		setPosition( address + 2 );
	}

	/**
	 * 
	 * @param address
	 * @param length
	 * @return
	 */
	public int[] getShorts( int address, int length ) {
		int[] values = new int[length];
		for ( int i = 0; i < values.length; i++ )
			values[i] = getShort( address + ( i * 2) );
		return values;
	}

	/**
	 * 
	 * @param address
	 * @param values
	 */
	public void putShorts( int address, int[] values ) {
		for ( int i = 0; i < values.length; i++ )
			putShort( address + ( i * 2 ), values[i] );
	}
	
	/**
	 * 
	 * @return
	 */
	public int getInteger() {
		return getInteger( position );
	}
	
	/**
	 * 
	 * @param address
	 * @return
	 */
	public int getInteger( int address ) {
		setPosition( address + 4 );
		int value = 0;
		for ( int i = 0; i < 4; i++ )
			value |= get( address + i ) << ( 0 + ( i * 8 ) );
		return value;
	}
	
	/**
	 * 
	 * @param value
	 */
	public void putInteger( int value ) {
		putInteger( position, value );
	}
	
	/**
	 * 
	 * @param address
	 * @param value
	 */
	public void putInteger( int address, int value ) {
		setPosition( address + 4 );
	}
	
	/**
	 * 
	 * @param address
	 * @param length
	 * @return
	 */
	public int[] getIntegers( int address, int length ) {
		int[] values = new int[length];
		for ( int i = 0; i < values.length; i++ )
			values[i] = getInteger( address + ( i * 4) );
		return values;
	}

	/**
	 * 
	 * @param address
	 * @param values
	 */
	public void putIntegers( int address, int[] values ) {
		for ( int i = 0; i < values.length; i++ )
			putInteger( address + ( i * 4 ), values[i] );
	}
	
	/**
	 * 
	 * @return
	 */
	public int getPointer() {
		return getPointer( position );
	}
	
	/**
	 * 
	 * @param address
	 * @return
	 */
	public int getPointer( int address ) {
		return 0;
	}

	/**
	 * 
	 * @param address
	 * @param length
	 * @return
	 */
	public int[] getPointers( int address, int length ) {
		return null;
	}

	/**
	 * 
	 * @param address
	 * @param length
	 * @return
	 */
	public String getString( int address, int length ) {
		StringBuilder builder = new StringBuilder();
		for ( int i = 0; i < length; i++ ) {
			char character = (char) get( address + i );
			if ( character != 0 )
				builder.append( character );
		}
		return builder.toString();
	}

	/**
	 * 
	 * @param address
	 * @return
	 */
	public String getString( int address ) {
		return null;
	}

	/**
	 * 
	 * @param address
	 * @param length
	 * @return
	 */
	public String[] getStrings( int address, int length ) {
		String[] strings = new String[length];
		setPosition( address );
		for ( int i = 0; i < length; i++ )
			strings[i] = getString( position );
		return strings;
	}
	
	/**
	 * 
	 * @param address
	 * @param characters
	 */
	public void putString( int address, String characters ) {
		
	}
	
	/**
	 * 
	 * @return
	 */
	public byte[] array() {
		return memory;
	}
	
	/**
	 * 
	 * @param address
	 */
	private void setPosition( int address ) {
		position = address;
	}
}
