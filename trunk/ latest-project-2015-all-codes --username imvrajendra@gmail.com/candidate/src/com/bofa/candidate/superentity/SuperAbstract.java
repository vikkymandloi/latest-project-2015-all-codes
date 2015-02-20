/**
 * 
 */
package com.bofa.candidate.superentity;

import java.io.Serializable;

/**
 * @author vmandloi
 * A marker interface for implementing all the other interfaces which will be usefull for our project
 */
public interface SuperAbstract extends Serializable, Comparable<Object>{

	/**
	 * @param o
	 * @return
	 */
	int compareTo(Object o);
	
}
