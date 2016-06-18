package com.dshck.dphl.nitro;

import com.dshck.dphl.CartridgeMemory;
import com.dshck.dphl.CartridgeStructure;

/**
 * 
 * @author Phillip Groves
 *
 */
public final class NitroFileHeader implements CartridgeStructure {
	
	/**  */
	private final CartridgeMemory memory;
	
	/**  */
	private final int address;
	
	/**  */
	private String stamp;

	/**  */
	private int fileSize;
	
	/**  */
	private int endian;
	
	/**  */
	private int headerSize;
	
	/**  */
	private int sectionCount;
	
	/**
	 * 
	 * @param memory
	 * @param address
	 */
	public NitroFileHeader( CartridgeMemory memory, int address ) {
		this.memory = memory;
		this.address = address;
		reload();
	}
	
	@Override
	public void reload() {
		this.stamp = memory.getString( address, 4 );
		this.endian = memory.getShort( address + 4 );
		this.fileSize = memory.getInteger( address + 8 );
		this.headerSize = memory.getShort( address + 12 );
		this.sectionCount = memory.getShort( address + 14 );
	}

	@Override
	public void save() {
		memory.putString( address, stamp );
		memory.putShort( address + 4, endian );
		memory.putInteger( address + 8, fileSize );
		memory.putShort( address + 12, headerSize );
		memory.putShort( address + 14, sectionCount );
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
	public void setStamp(String stamp) {
		this.stamp = stamp;
	}

	/**
	 * 
	 * @return
	 */
	public int getFileSize() {
		return fileSize;
	}

	/**
	 * 
	 * @param fileSize
	 */
	public void setFileSize(int fileSize) {
		this.fileSize = fileSize;
	}

	/**
	 * 
	 * @return
	 */
	public int getHeaderSize() {
		return headerSize;
	}

	/**
	 * 
	 * @param headerSize
	 */
	public void setHeaderSize(int headerSize) {
		this.headerSize = headerSize;
	}

	/**
	 * 
	 * @return
	 */
	public int getSectionCount() {
		return sectionCount;
	}

	/**
	 * 
	 * @param sectionCount
	 */
	public void setSectionCount(int sectionCount) {
		this.sectionCount = sectionCount;
	}
}
