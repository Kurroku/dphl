package com.dshck.dphl.nitro;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.AccessMode;
import java.nio.file.CopyOption;
import java.nio.file.DirectoryStream;
import java.nio.file.DirectoryStream.Filter;
import java.nio.file.FileSystem;
import java.nio.file.LinkOption;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.FileAttributeView;
import java.nio.file.spi.FileSystemProvider;
import java.util.Map;
import java.util.Set;

import com.dshck.dphl.CartridgeMemory;

/**
 * 
 * @author Phillip Groves
 *
 */
public class NitroFileSystemProvider extends FileSystemProvider {

	/**  */
	private final CartridgeMemory rom;
	
	/**
 	* 
 	* @param rom
 	*/
	public NitroFileSystemProvider( CartridgeMemory rom ) {
		this.rom = rom;
	}
	
	@Override
	public void checkAccess( Path path, AccessMode... modes ) throws IOException {
		
	}

	@Override
	public void copy( Path source, Path destination, CopyOption... options ) {
		
	}

	@Override
	public void createDirectory( Path path, FileAttribute<?>... attributes ) {
		
	}

	@Override
	public void delete( Path path ) {
		
	}

	@Override
	public <V extends FileAttributeView> V getFileAttributeView( Path path, Class<V> type, LinkOption... options ) {
		return null;
	}

	@Override
	public NitroFileStore getFileStore( Path path ) {
		return null;
	}

	@Override
	public FileSystem getFileSystem( URI uri ) {
		return null;
	}

	@Override
	public Path getPath( URI uri ) {
		return null;
	}

	@Override
	public String getScheme() {
		return null;
	}

	@Override
	public boolean isHidden( Path path ) {
		return false;
	}

	@Override
	public boolean isSameFile( Path path, Path path2 ) {
		return false;
	}

	@Override
	public void move( Path source, Path target, CopyOption... options ) {
		
	}

	@Override
	public SeekableByteChannel newByteChannel( Path path, Set<? extends OpenOption> options, FileAttribute<?>... attrs ) {
		return null;
	}

	@Override
	public DirectoryStream<Path> newDirectoryStream( Path path, Filter<? super Path> filter ) {
		return null;
	}
	
	@Override
	public InputStream newInputStream( Path path, OpenOption... options ) {
		return null;
	}
	
	@Override
	public NitroFileSystem newFileSystem( URI uri, Map<String, ?> env ) {
		return new NitroFileSystem( rom, uri, env );
	}
	
	@Override
	public OutputStream newOutputStream( Path path, OpenOption... options ) {
		return null;
	}
	
	@Override
	public <A extends BasicFileAttributes> A readAttributes( Path path, Class<A> type, LinkOption... options ) {
		return null;
	}

	@Override
	public Map<String, Object> readAttributes( Path path, String attributes, LinkOption... options) {
		return null;
	}

	@Override
	public void setAttribute( Path path, String attribute, Object value, LinkOption... options ) {
		
	}
}
