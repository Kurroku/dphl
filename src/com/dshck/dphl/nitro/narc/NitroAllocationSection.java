package com.dshck.dphl.nitro.narc;

import com.dshck.dphl.CartridgeMemory;
import com.dshck.dphl.CartridgeStructure;
import com.dshck.dphl.util.StringUtil;

/**
 * 
 * @author Phillip Groves
 *
 */
public class NitroAllocationSection implements CartridgeStructure {

	/**  */
	private final CartridgeMemory memory;
	
	/**  */
	private final int address;
	
	/**  */
	private String stamp;
	
	/**  */
	private int sectionSize;
	
	/**  */
	private int fileCount;
	
	/**
	 * 
	 * @param memory
	 * @param address
	 */
	protected NitroAllocationSection( CartridgeMemory memory, int address ) {
		this.memory = memory;
		this.address = address;
		reload();
	}

	@Override
	public void reload() {
		this.stamp = StringUtil.reverse( memory.getString(address, 4) );
		System.out.println( Integer.toHexString( address + 4 ) );
		this.sectionSize = memory.getInteger( address + 4 );
		this.fileCount = memory.getInteger( address + 8 );
	}

	@Override
	public void save() {
		memory.putString( address, StringUtil.reverse( stamp ) );
		memory.putInteger( address + 4, sectionSize );
		memory.putInteger( address + 8, fileCount );
	}

	/**
	 * 
	 * @return
	 */
	public String getStamp() {
		return stamp;
	}

	/**
	 * 
	 * @param stamp
	 */
	public void setStamp( String stamp ) {
		this.stamp = stamp;
	}

	/**
	 * 
	 * @return
	 */
	public int getSectionSize() {
		return sectionSize;
	}

	/**
	 * 
	 * @param sectionSize
	 */
	public void setSectionSize( int sectionSize ) {
		this.sectionSize = sectionSize;
	}

	/**
	 * 
	 * @return
	 */
	public int getFileCount() {
		return fileCount;
	}

	/**
	 * 
	 * @param fileCount
	 */
	public void setFileCount( int fileCount ) {
		this.fileCount = fileCount;
	}
}
