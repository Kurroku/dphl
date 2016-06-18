package com.dshck.dphl;

/**
 * 
 * @author Phillip Groves
 *
 */
public final class CartridgeHeader implements CartridgeStructure {
	
	/**  */
	private final CartridgeMemory memory;
	
	/**  */
	private String title, gameCode, makerCode;
	
	/**  */
	private int deviceCode, encryptionSeed, fileLengthType, gameVersion, internalFlags;
	
	/**  */
	private int arm9Offset, arm9EntryAddress, arm9LoadAddress, arm9Length;
	
	/**  */
	private int arm7Offset, arm7EntryAddress, arm7LoadAddress, arm7Length;
	
	/**  */
	private int fileNameTableAddress, fileNameTableLength;
	
	/**  */
	private int fileAllocationTableAddress, fileAllocationTableLength;
	
	/**  */
	private int arm9OverlayAddress, arm9OverlayLength;
	
	/**  */
	private int arm7OverlayAddress, arm7OverlayLength;
	
	
	/**  */
	private int normalCardControlRegisterSettings, secureCardControlRegisterSettings;
	
	/**  */
	private int secureAreaCRC16, secureTransferTimeout;
	
	/**  */
	private int arm9AutoloadAddress, arm7AutoloadAddress;
	/* TODO: Support for more header fields in the future */
	
	/**
	 * 
	 * @param file
	 */
	public CartridgeHeader( CartridgeMemory memory ) {
		this.memory = memory;
		reload();
	}
	
	@Override
	public void reload() {
		this.title = memory.getString( 0x0, 12 );
		this.gameCode = memory.getString( 0xC, 4 );
		this.makerCode = memory.getString( 0x10, 2 );
		this.deviceCode = memory.get( 0x12 );
		this.encryptionSeed = memory.get();
		this.fileLengthType = memory.get();
		this.gameVersion = memory.get( 0x1E );
		this.internalFlags = memory.get();
		this.arm9Offset = memory.getInteger();
		this.arm9EntryAddress = memory.getInteger();
		this.arm9LoadAddress = memory.getInteger();
		this.arm9Length = memory.getInteger();
		this.arm7Offset = memory.getInteger();
		this.arm7EntryAddress = memory.getInteger();
		this.arm7LoadAddress = memory.getInteger();
		this.arm7Length = memory.getInteger();
		this.fileNameTableAddress = memory.getInteger( 0x40 );
		this.fileNameTableLength = memory.getInteger( 0x44 );
		this.fileAllocationTableAddress = memory.getInteger( 0x48 );
		this.fileAllocationTableLength = memory.getInteger( 0x4C );
		this.arm9OverlayAddress = memory.getInteger();
		this.arm9OverlayLength = memory.getInteger();
		this.arm7OverlayAddress = memory.getInteger();
		this.arm7OverlayLength = memory.getInteger();
		this.normalCardControlRegisterSettings = memory.getInteger();
		this.secureCardControlRegisterSettings = memory.getInteger();
		this.secureAreaCRC16 = memory.getShort();
		this.secureTransferTimeout = memory.getShort();
		this.arm9AutoloadAddress = memory.getInteger();
		this.arm7AutoloadAddress = memory.getInteger();
		
	}

	@Override
	public void save() {
		memory.putString( 0, title );
		memory.putString( 0xC, gameCode );
		memory.putString( 0x10, makerCode );
		memory.put( 0x12, deviceCode );
		memory.put( encryptionSeed );
		memory.put( fileLengthType );
		memory.put( 0x1E, gameVersion );
		memory.put( internalFlags );
		memory.putInteger( arm9Offset );
		memory.putInteger( arm9EntryAddress );
		memory.putInteger( arm9Length );
		memory.putInteger( arm7Offset );
		memory.putInteger( arm7EntryAddress );
		memory.putInteger( arm7Length );
		memory.putInteger( fileNameTableAddress );
		memory.putInteger( fileNameTableLength );
		memory.putInteger( fileAllocationTableAddress );
		memory.putInteger( fileAllocationTableLength );
		memory.putInteger( arm9OverlayAddress );
		memory.putInteger( arm9OverlayLength );
		memory.putInteger( arm7OverlayAddress );
		memory.putInteger( arm7OverlayLength );
		memory.putInteger( normalCardControlRegisterSettings  );
		memory.putInteger( secureCardControlRegisterSettings );
		memory.putInteger( secureAreaCRC16 );
		memory.putInteger( secureTransferTimeout );
		memory.putInteger( arm9AutoloadAddress );
		memory.putInteger( arm7AutoloadAddress );
	}
	
	/**
	 * 
	 * @return
	 */
	public String getTitle() {
		return title;
	}
	
	/**
	 * 
	 * @param title
	 */
	public void setTitle( String title ) {
		if ( title.length() > 12 || title == null )
			throw new IllegalStateException( "Title must be non-null, length 0-12 characters!" );
		this.title = title;
	}

	/**
	 * 
	 * @return
	 */
	public String getGameCode() {
		return gameCode;
	}
	
	/**
	 * 
	 * @param code
	 */
	public void setGameCode( String code ) {
		if ( code.length() != 4 || code == null )
			throw new IllegalStateException( "Game code must be non-null, length 4 characters!" );
		this.gameCode = code;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getMakerCode() {
		return makerCode;
	}
	
	/**
	 * 
	 * @param code
	 */
	public void setMakerCode( String code ) {
		if ( code.length() != 2 || code == null )
			throw new IllegalStateException( "Maker code must be non-null, length 2 characters!" );
		this.makerCode = code;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getDeviceCode() {
		return deviceCode;
	}

	/**
	 * 
	 * @param deviceCode
	 */
	public void setDeviceCode(int deviceCode) {
		this.deviceCode = deviceCode;
	}

	/**
	 * 
	 * @return
	 */
	public int getEncryptionSeed() {
		return encryptionSeed;
	}

	/**
	 * 
	 * @param encryptionSeed
	 */
	public void setEncryptionSeed(int encryptionSeed) {
		this.encryptionSeed = encryptionSeed;
	}

	/**
	 * 
	 * @return
	 */
	public int getFileLengthType() {
		return fileLengthType;
	}

	/**
	 * 
	 * @param fileLengthType
	 */
	public void setFileLengthType(int fileLengthType) {
		this.fileLengthType = fileLengthType;
	}

	/**
	 * 
	 * @return
	 */
	public int getGameVersion() {
		return gameVersion;
	}

	/**
	 * 
	 * @param gameVersion
	 */
	public void setGameVersion(int gameVersion) {
		this.gameVersion = gameVersion;
	}

	/**
	 * 
	 * @return
	 */
	public int getInternalFlags() {
		return internalFlags;
	}

	/**
	 * 
	 * @param internalFlags
	 */
	public void setInternalFlags(int internalFlags) {
		this.internalFlags = internalFlags;
	}

	/**
	 * 
	 * @return
	 */
	public int getArm9Offset() {
		return arm9Offset;
	}

	/**
	 * 
	 * @param arm9Offset
	 */
	public void setArm9Offset(int arm9Offset) {
		this.arm9Offset = arm9Offset;
	}

	/**
	 * 
	 * @return
	 */
	public int getArm9EntryAddress() {
		return arm9EntryAddress;
	}

	/**
	 * 
	 * @param arm9EntryAddress
	 */
	public void setArm9EntryAddress(int arm9EntryAddress) {
		this.arm9EntryAddress = arm9EntryAddress;
	}

	/**
	 * 
	 * @return
	 */
	public int getArm9LoadAddress() {
		return arm9LoadAddress;
	}

	/**
	 * 
	 * @param arm9LoadAddress
	 */
	public void setArm9LoadAddress(int arm9LoadAddress) {
		this.arm9LoadAddress = arm9LoadAddress;
	}

	/**
	 * 
	 * @return
	 */
	public int getArm9Length() {
		return arm9Length;
	}

	/**
	 * 
	 * @param arm9Length
	 */
	public void setArm9Length(int arm9Length) {
		this.arm9Length = arm9Length;
	}

	/**
	 * 
	 * @return
	 */
	public int getArm7Offset() {
		return arm7Offset;
	}

	/**
	 * 
	 * @param arm7Offset
	 */
	public void setArm7Offset(int arm7Offset) {
		this.arm7Offset = arm7Offset;
	}

	/**
	 * 
	 * @return
	 */
	public int getArm7EntryAddress() {
		return arm7EntryAddress;
	}

	/**
	 * 
	 * @param arm7EntryAddress
	 */
	public void setArm7EntryAddress(int arm7EntryAddress) {
		this.arm7EntryAddress = arm7EntryAddress;
	}

	/**
	 * 
	 * @return
	 */
	public int getArm7LoadAddress() {
		return arm7LoadAddress;
	}

	/**
	 * 
	 * @param arm7LoadAddress
	 */
	public void setArm7LoadAddress(int arm7LoadAddress) {
		this.arm7LoadAddress = arm7LoadAddress;
	}

	/**
	 * 
	 * @return
	 */
	public int getArm7Length() {
		return arm7Length;
	}

	/**
	 * 
	 * @param arm7Length
	 */
	public void setArm7Length(int arm7Length) {
		this.arm7Length = arm7Length;
	}

	/**
	 * 
	 * @return
	 */
	public int getFileNameTableAddress() {
		return fileNameTableAddress;
	}

	/**
	 * 
	 * @param fileNameTableAddress
	 */
	public void setFileNameTableAddress(int fileNameTableAddress) {
		this.fileNameTableAddress = fileNameTableAddress;
	}

	/**
	 * 
	 * @return
	 */
	public int getFileNameTableLength() {
		return fileNameTableLength;
	}

	/**
	 * 
	 * @param fileNameTableLength
	 */
	public void setFileNameTableLength(int fileNameTableLength) {
		this.fileNameTableLength = fileNameTableLength;
	}

	/**
	 * 
	 * @return
	 */
	public int getFileAllocationTableAddress() {
		return fileAllocationTableAddress;
	}

	/**
	 * 
	 * @param fileAllocationTableAddress
	 */
	public void setFileAllocationTableAddress(int fileAllocationTableAddress) {
		this.fileAllocationTableAddress = fileAllocationTableAddress;
	}

	/**
	 * 
	 * @return
	 */
	public int getFileAllocationTableLength() {
		return fileAllocationTableLength;
	}

	/**
	 * 
	 * @param fileAllocationTableLength
	 */
	public void setFileAllocationTableLength(int fileAllocationTableLength) {
		this.fileAllocationTableLength = fileAllocationTableLength;
	}

	/**
	 * 
	 * @return
	 */
	public int getArm9OverlayAddress() {
		return arm9OverlayAddress;
	}

	/**
	 * 
	 * @param arm9OverlayAddress
	 */
	public void setArm9OverlayAddress(int arm9OverlayAddress) {
		this.arm9OverlayAddress = arm9OverlayAddress;
	}

	/**
	 * 
	 * @return
	 */
	public int getArm9OverlayLength() {
		return arm9OverlayLength;
	}

	/**
	 * 
	 * @param arm9OverlayLength
	 */
	public void setArm9OverlayLength(int arm9OverlayLength) {
		this.arm9OverlayLength = arm9OverlayLength;
	}

	/**
	 * 
	 * @return
	 */
	public int getArm7OverlayAddress() {
		return arm7OverlayAddress;
	}

	/**
	 * 
	 * @param arm7OverlayAddress
	 */
	public void setArm7OverlayAddress(int arm7OverlayAddress) {
		this.arm7OverlayAddress = arm7OverlayAddress;
	}

	/**
	 * 
	 * @return
	 */
	public int getArm7OverlayLength() {
		return arm7OverlayLength;
	}

	/**
	 * 
	 * @param arm7OverlayLength
	 */
	public void setArm7OverlayLength(int arm7OverlayLength) {
		this.arm7OverlayLength = arm7OverlayLength;
	}

	/**
	 * 
	 * @return
	 */
	public int getNormalCardControlRegisterSettings() {
		return normalCardControlRegisterSettings;
	}

	/**
	 * 
	 * @param normalCardControlRegisterSettings
	 */
	public void setNormalCardControlRegisterSettings(int normalCardControlRegisterSettings) {
		this.normalCardControlRegisterSettings = normalCardControlRegisterSettings;
	}

	/**
	 * 
	 * @return
	 */
	public int getSecureCardControlRegisterSettings() {
		return secureCardControlRegisterSettings;
	}

	/**
	 * 
	 * @param secureCardControlRegisterSettings
	 */
	public void setSecureCardControlRegisterSettings(int secureCardControlRegisterSettings) {
		this.secureCardControlRegisterSettings = secureCardControlRegisterSettings;
	}

	/**
	 * 
	 * @return
	 */
	public int getSecureAreaCRC16() {
		return secureAreaCRC16;
	}

	/**
	 * 
	 * @param secureAreaCRC16
	 */
	public void setSecureAreaCRC16(int secureAreaCRC16) {
		this.secureAreaCRC16 = secureAreaCRC16;
	}

	/**
	 * 
	 * @return
	 */
	public int getSecureTransferTimeout() {
		return secureTransferTimeout;
	}

	/**
	 * 
	 * @param secureTransferTimeout
	 */
	public void setSecureTransferTimeout(int secureTransferTimeout) {
		this.secureTransferTimeout = secureTransferTimeout;
	}

	/**
	 * 
	 * @return
	 */
	public int getArm9AutoloadAddress() {
		return arm9AutoloadAddress;
	}

	/**
	 * 
	 * @param arm9AutoloadAddress
	 */
	public void setArm9AutoloadAddress(int arm9AutoloadAddress) {
		this.arm9AutoloadAddress = arm9AutoloadAddress;
	}

	/**
	 * 
	 * @return
	 */
	public int getArm7AutoloadAddress() {
		return arm7AutoloadAddress;
	}

	/**
	 * 
	 * @param arm7AutoloadAddress
	 */
	public void setArm7AutoloadAddress(int arm7AutoloadAddress) {
		this.arm7AutoloadAddress = arm7AutoloadAddress;
	}
}
