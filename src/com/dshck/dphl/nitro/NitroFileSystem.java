package com.dshck.dphl.nitro;

import java.net.URI;
import java.nio.file.FileStore;
import java.nio.file.FileSystem;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.WatchService;
import java.nio.file.attribute.UserPrincipalLookupService;
import java.nio.file.spi.FileSystemProvider;
import java.util.Map;
import java.util.Set;

import com.dshck.dphl.CartridgeMemory;

/**
 * 
 * @author Phillip Groves
 *
 */
public class NitroFileSystem extends FileSystem {
	
	/**
	 * 
	 * @param memory
	 * @param uri
	 * @param env
	 */
	public NitroFileSystem( CartridgeMemory memory, URI uri, Map<String, ?> env ) {
		
	}
	
	@Override
	public void close() {
		// TODO: Close resources
	}

	@Override
	public Iterable<FileStore> getFileStores() {
		return null;
	}

	@Override
	public Path getPath( String first, String... more ) {
		return null;
	}

	@Override
	public PathMatcher getPathMatcher( String syntaxAndPattern ) {
		return null;
	}

	@Override
	public Iterable<Path> getRootDirectories() {
		return null;
	}

	@Override
	public String getSeparator() {
		return null;
	}

	@Override
	public UserPrincipalLookupService getUserPrincipalLookupService() {
		return null;
	}

	@Override
	public boolean isOpen() {
		return false;
	}

	@Override
	public boolean isReadOnly() {
		return false;
	}

	@Override
	public WatchService newWatchService() {
		return null;
	}

	@Override
	public FileSystemProvider provider() {
		return null;
	}

	@Override
	public Set<String> supportedFileAttributeViews() {
		return null;
	}

}
