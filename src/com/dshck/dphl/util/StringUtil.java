package com.dshck.dphl.util;

public class StringUtil {

	public static String reverse( String text ) {
		char[] characters = text.toCharArray();
		StringBuilder builder = new StringBuilder();
		for ( int i = 0; i < characters.length; i++ )
			builder.append( characters[characters.length - i - 1] );
		return builder.toString();
	}
}
